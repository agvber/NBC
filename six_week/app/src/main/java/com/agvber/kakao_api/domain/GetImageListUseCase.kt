package com.agvber.kakao_api.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.agvber.kakao_api.data.repository.ImageRepository
import com.agvber.kakao_api.model.Images
import com.agvber.kakao_api.network.model.ImageSort
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetImageListUseCase(
    private val imageRepository: ImageRepository,
) {

    operator fun invoke(
        query: String,
        sort: ImageSort = ImageSort.ACCURACY,
    ): Pager<Int, Images.Item> {
        return Pager(
            PagingConfig(pageSize = 30)
        ) {
            ImagePagingSource(query = query, sort = sort)
        }
    }

    private inner class ImagePagingSource(
        private val query: String,
        private val sort: ImageSort = ImageSort.ACCURACY,
    ) : PagingSource<Int, Images.Item>() {
        override fun getRefreshKey(state: PagingState<Int, Images.Item>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                val anchorPage = state.closestPageToPosition(anchorPosition)
                anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
            }
        }

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Images.Item> {
            return try {
                val currentPageNumber = params.key ?: 1
                val images = withContext(Dispatchers.IO) {
                    imageRepository.getImage(
                        query = query,
                        sort = sort,
                        page = currentPageNumber,
                        size = 30
                    )
                }

                LoadResult.Page(
                    data = images.items,
                    prevKey = getPrevKey(currentPageNumber),
                    nextKey = getNextKey(currentPageNumber)
                )

            } catch (e: Exception) {
                e.printStackTrace()
                LoadResult.Error(e)
            }
        }

        private fun getPrevKey(currentKey: Int): Int? {
            if (currentKey == 1) {
                return null
            }
            return currentKey - 1
        }

        private fun getNextKey(currentKey: Int): Int? {
            if (currentKey == 80) {
                return null
            }
            return currentKey + 1
        }
    }
}