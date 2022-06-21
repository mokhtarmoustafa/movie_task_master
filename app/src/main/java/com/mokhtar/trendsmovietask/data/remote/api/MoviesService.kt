package com.mokhtar.trendsmovietask.data.remote.api

import com.mokhtar.androidmoviestask.data.remote.model.configuration.ConfigurationResponse
import com.mokhtar.androidmoviestask.data.remote.model.movie.MoviesResponse
import com.mokhtar.trendsmovietask.util.CONFIGURATION_URL
import com.mokhtar.trendsmovietask.util.TRENDING_MOVIES_URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET(TRENDING_MOVIES_URL)
    suspend fun getTrendingMovies(
        @Query("page") page:Int?=1
    ): Response<MoviesResponse>


    @GET(CONFIGURATION_URL)
    suspend fun getConfiguration(
    ):Response<ConfigurationResponse>


}