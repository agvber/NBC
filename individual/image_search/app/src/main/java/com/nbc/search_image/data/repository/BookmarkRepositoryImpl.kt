package com.nbc.search_image.data.repository

import com.nbc.search_image.database.dao.BookmarkDao
import com.nbc.search_image.database.dao.SearchDao
import com.nbc.search_image.database.model.BookmarkEntity
import com.nbc.search_image.database.model.ImageResourceEntity
import com.nbc.search_image.domain.model.Bookmark
import com.nbc.search_image.domain.model.Search
import com.nbc.search_image.domain.repository.BookmarkRepository
import com.nbc.search_image.mapper.asExternalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val searchDao: SearchDao,
    private val bookmarkDao: BookmarkDao,
) : BookmarkRepository {
    override suspend fun addBookmark(search: Search) {
        searchDao.getItem(search.id).firstOrNull()?.let {
            bookmarkDao.insertItem(
                search.toStorageBoxEntity(it.dateTime)
            )
        }
    }

    override suspend fun deleteBookmark(id: String) {
        bookmarkDao.deleteItems(listOf(id))
    }

    override fun getBookmarkItems(): Flow<List<Bookmark>> {
        return bookmarkDao.getAll().map { entities ->
            entities.map { it.asExternalModel() }
        }
    }
}

private fun Search.toStorageBoxEntity(dateTime: String): BookmarkEntity = BookmarkEntity(
    id = id,
    title = title,
    dateTime = dateTime,
    image = ImageResourceEntity(image.thumbnailUrl, image.originalUrl),
)