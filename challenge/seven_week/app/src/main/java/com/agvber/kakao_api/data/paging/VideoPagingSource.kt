package com.agvber.kakao_api.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.agvber.kakao_api.domain.model.Sort
import com.agvber.kakao_api.network.NetworkDataSource
import com.agvber.kakao_api.network.model.NetworkSort
import com.agvber.kakao_api.network.model.VideoResponse
import com.agvber.kakao_api.network.model.asNetworkModel

private const val FIRST_PAGE_INDEX = 1

class VideoPagingSource(
    private val query: String,
    private val sort: Sort = Sort.ACCURACY,
    private val networkDataSource: NetworkDataSource,
) : PagingSource<Int, VideoResponse.Document>() {
    override fun getRefreshKey(state: PagingState<Int, VideoResponse.Document>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VideoResponse.Document> {
        return try {
            val currentPageNumber = params.key ?: FIRST_PAGE_INDEX
            val networkResponse = getNetworkResponse(currentPageNumber, 30)

            LoadResult.Page(
                data = networkResponse.documents,
                prevKey = getPrevKey(currentKey = currentPageNumber),
                nextKey = getNextKey(
                    currentKey = currentPageNumber,
                    isEnd = networkResponse.meta.isEnd
                )
            )

        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    private suspend fun getNetworkResponse(page: Int, size: Int) =
        networkDataSource.getVideos(
            query = query,
            sort = sort.asNetworkModel(),
            page = page,
            size = size
        )

    private fun getPrevKey(currentKey: Int): Int? {
        if (currentKey == 1) {
            return null
        }
        return currentKey - 1
    }

    private fun getNextKey(currentKey: Int, isEnd: Boolean): Int? {
        if (isEnd) {
            return null
        }
        return currentKey + 1
    }
}