package com.mokhtar.trendsmovietask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mokhtar.androidmoviestask.data.remote.model.configuration.ConfigurationResponse
import com.mokhtar.androidmoviestask.data.remote.model.movie.MoviesResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movieResponse: MoviesResponse)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewConfiguration(configurationResponse: ConfigurationResponse)


    @Query("SELECT * FROM TBL_MOVIE")
    fun getAllMovies(): Flow<MoviesResponse>

    @Query("SELECT * FROM TBL_CONFIGURATION")
    fun getAllConfiguration(): Flow<ConfigurationResponse>

}