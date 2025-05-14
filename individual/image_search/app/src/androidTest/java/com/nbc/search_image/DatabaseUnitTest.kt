package com.nbc.search_image

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.nbc.search_image.database.dao.SearchDao
import com.nbc.search_image.database.dao.BookmarkDao
import com.nbc.search_image.database.model.ImageResourceEntity
import com.nbc.search_image.database.model.SearchEntity
import com.nbc.search_image.database.model.BookmarkEntity
import com.nbc.search_image.database.room.AppDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DatabaseUnitTest {

    private lateinit var db: AppDatabase
    private lateinit var searchDao: SearchDao
    private lateinit var searchImageBookmarkDao: BookmarkDao

    @Before
    fun init() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java,
        ).build()

        searchDao = db.newResourceDao()
        searchImageBookmarkDao = db.storageBoxDao()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insetTest() = runTest {
        val searchEntity = SearchEntity(
            title = "카페",
            dateTime = "2022-04-05 12:22:11",
            image = ImageResourceEntity(
                "https://search2.kakaocdn.net/argon/130x130_85_c/ALWWFnaAY6m",
                "https://t1.daumcdn.net/news/201711/22/akn/20171122161159421qxjf.jpg"
            ),
            isFavorite = false
        )
        searchDao.insertItem(searchEntity)

        searchDao.getAll().firstOrNull().let { entities ->
            Assert.assertEquals(entities?.first(), searchEntity)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun conflictTest() = runTest {
        val searchEntity = SearchEntity(
            title = "NewResourceEntity",
            dateTime = "2022-04-05 12:22:11",
            image = ImageResourceEntity(
                "https://search1.kakaocdn.net/argon/130x130_85_c/5jblOR3vpCO",
                "https://blog.kakaocdn.net/dn/bCcRcl/btsqh0GA7pe/OeeIcBOwt5XRkd7vJVjKd0/img.jpg"
            ),
            isFavorite = false
        )

        val bookmarkEntity = BookmarkEntity(
            title = "StorageBoxEntity",
            dateTime = "2022-04-05 12:22:11",
            image = ImageResourceEntity(
                "https://search2.kakaocdn.net/argon/130x130_85_c/ALWWFnaAY6m",
                "https://t1.daumcdn.net/news/201711/22/akn/20171122161159421qxjf.jpg"
            )
        )

        searchDao.insertItem(searchEntity)
        searchImageBookmarkDao.insertItem(bookmarkEntity)

        searchDao.getAll().firstOrNull().let { entities ->
            Assert.assertEquals(entities?.first(), searchEntity)
        }
        searchImageBookmarkDao.getAll().firstOrNull().let { entities ->
            Assert.assertEquals(entities?.first(), bookmarkEntity)
        }
    }
}