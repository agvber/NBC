package com.nbc.search_image.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.nbc.search_image.data.paging.SearchImageRemoteMediator
import com.nbc.search_image.database.dao.PagingRemoteKeysDao
import com.nbc.search_image.database.dao.RecentSearchQueryDao
import com.nbc.search_image.database.dao.SearchDao
import com.nbc.search_image.domain.model.RecentSearchQuery
import com.nbc.search_image.domain.repository.SearchRepository
import com.nbc.search_image.mapper.asExternalModel
import com.nbc.search_image.domain.model.Search
import com.nbc.search_image.network.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


internal class SearchRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val searchDao: SearchDao,
    private val remoteKeysDao: PagingRemoteKeysDao,
    private val recentSearchQueryDao: RecentSearchQueryDao
) : SearchRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getSearchImage(query: String): Flow<PagingData<Search>> {
        val pagingConfig = PagingConfig(pageSize = 30, initialLoadSize = 30)
        val remoteMediator = SearchImageRemoteMediator(
            networkDataSource = networkDataSource,
            searchDao = searchDao,
            remoteKeysDao = remoteKeysDao,
            recentSearchQueryDao = recentSearchQueryDao,
            query = query
        )

        return Pager(
            config = pagingConfig,
            remoteMediator = remoteMediator
        ) {
            searchDao.getPagingSource()
        }
            .flow
            .map { pagingData ->
                pagingData.map {
                    it.asExternalModel()
                }
            }
    }

    override fun getRecentQueries(limit: Int): Flow<List<RecentSearchQuery>> {
        return recentSearchQueryDao.getRecentSearchQueries(limit).map { entities ->
            entities.map { it.asExternalModel() }
        }
    }
}