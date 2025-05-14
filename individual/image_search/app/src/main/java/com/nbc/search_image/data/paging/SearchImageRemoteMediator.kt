package com.nbc.search_image.data.paging

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.nbc.search_image.database.dao.PagingRemoteKeysDao
import com.nbc.search_image.database.dao.RecentSearchQueryDao
import com.nbc.search_image.database.dao.SearchDao
import com.nbc.search_image.database.model.ImageResourceEntity
import com.nbc.search_image.database.model.PagingRemoteKeysEntity
import com.nbc.search_image.database.model.RecentSearchQueryEntity
import com.nbc.search_image.database.model.SearchEntity
import com.nbc.search_image.network.NetworkDataSource
import com.nbc.search_image.network.model.ImageResponse

// https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide#search-image
private const val KAKAO_PAGE_FIRST_INDEX = 1
private const val KAKAO_PAGE_LAST_INDEX = 80

@OptIn(ExperimentalPagingApi::class)
class SearchImageRemoteMediator(
    private val networkDataSource: NetworkDataSource,
    private val searchDao: SearchDao,
    private val remoteKeysDao: PagingRemoteKeysDao,
    private val recentSearchQueryDao: RecentSearchQueryDao,
    private val query: String,
) : RemoteMediator<Int, SearchEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, SearchEntity>,
    ): MediatorResult {
        return try {
            val key: Int = generateKey(loadType, state)
                .also { Log.d("SearchImageRemoteMediator", "Key: $it") }
                ?: return MediatorResult.Success(endOfPaginationReached = true)

            val response = getResponse(position = key, pageSize = state.config.pageSize)
            checkRefreshState(loadType)
            insertRemoteKey(key, response.meta.isEnd)
            insertSearchData(response)

            MediatorResult.Success(response.meta.isEnd)
        } catch (e: Exception) {
            e.printStackTrace()
            MediatorResult.Error(e)
        }
    }

    private suspend fun generateKey(
        loadType: LoadType,
        state: PagingState<Int, SearchEntity>,
    ) = when (loadType) {
        LoadType.REFRESH -> {
            state.anchorPosition?.let { position ->
                state.closestItemToPosition(position)?.let {
                    remoteKeysDao.getRemoteKeys(query)?.currentKey
                }
            }
                ?: KAKAO_PAGE_FIRST_INDEX
        }

        LoadType.PREPEND -> {
            remoteKeysDao.getRemoteKeys(query)?.prevKey
        }

        LoadType.APPEND -> {
            remoteKeysDao.getRemoteKeys(query)?.nextKey
        }
    }

    private suspend fun getResponse(
        position: Int,
        pageSize: Int,
    ): ImageResponse = networkDataSource.getImages(
        query = query,
        page = position,
        size = pageSize
    )

    private suspend fun checkRefreshState(loadType: LoadType) {
        if (loadType == LoadType.REFRESH) {
            remoteKeysDao.clearRemoteKeys()
            searchDao.clear()
            recentSearchQueryDao.upsertItem(
                RecentSearchQueryEntity(query, System.currentTimeMillis())
            )
        }
    }

    private suspend fun insertSearchData(response: ImageResponse) {
        searchDao.insertReplaceAll(
            response.documents.map { document ->
                document.toEntity()
            }
        )
    }

    private suspend fun insertRemoteKey(key: Int, isEnd: Boolean) {
        remoteKeysDao.insertAll(
            listOf(
                PagingRemoteKeysEntity(
                    queried = query,
                    prevKey = getPrevKey(key),
                    nextKey = getNextKey(key, isEnd),
                    currentKey = key
                )
            )
        )
    }

    private fun getPrevKey(key: Int) =
        if (key == KAKAO_PAGE_FIRST_INDEX) null else key - 1

    private fun getNextKey(key: Int, isEnd: Boolean) = if (isEnd) null else key + 1
}

private fun ImageResponse.Document.toEntity(): SearchEntity =
    SearchEntity(
        title = this.displaySiteName,
        dateTime = this.datetime,
        image = ImageResourceEntity(thumbnailUrl = thumbnailUrl, originalUrl = imageUrl),
        isFavorite = false
    )
