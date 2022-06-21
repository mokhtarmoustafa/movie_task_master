package com.mokhtar.trendsmovietask.di

import android.content.Context
import androidx.room.Room
import com.mokhtar.trendsmovietask.data.local.MovieDataBase
import com.mokhtar.trendsmovietask.data.local.dao.MovieDao
import com.mokhtar.trendsmovietask.util.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        MovieDataBase::class.java,
        DB_NAME
    ).build()


    @Provides
    @Singleton
    fun provideDao(roomDatabase: MovieDataBase): MovieDao {
        return roomDatabase.getDao()
    }
}