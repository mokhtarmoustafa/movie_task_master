package com.mokhtar.trendsmovietask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mokhtar.androidmoviestask.data.remote.model.configuration.ConfigurationResponse
import com.mokhtar.androidmoviestask.data.remote.model.movie.MoviesResponse
import com.mokhtar.trendsmovietask.data.local.dao.MovieDao
import com.mokhtar.trendsmovietask.util.MoviesConverter

@Database(entities = [MoviesResponse::class, ConfigurationResponse::class], version = 1)

@TypeConverters(MoviesConverter::class)
abstract class MovieDataBase:RoomDatabase() {
    abstract  fun getDao(): MovieDao
}