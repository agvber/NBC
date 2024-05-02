package com.nbc.search_image.database.di

import android.content.Context
import androidx.room.Room
import androidx.room.withTransaction
import com.nbc.search_image.database.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun providesRoomDatabase(
        @ApplicationContext appContext: Context,
    ): AppDatabase {
        return Room
            .databaseBuilder(appContext, AppDatabase::class.java, "app-db")
            .build()
    }
}