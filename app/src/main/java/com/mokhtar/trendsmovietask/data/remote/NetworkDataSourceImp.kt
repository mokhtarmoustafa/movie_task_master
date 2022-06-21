package com.mokhtar.trendsmovietask.data.remote

import com.mokhtar.androidmoviestask.data.remote.model.configuration.ConfigurationResponse
import com.mokhtar.androidmoviestask.data.remote.model.movie.MoviesResponse
import com.mokhtar.trendsmovietask.data.remote.NetworkDataSource
import com.mokhtar.trendsmovietask.data.remote.api.MoviesService
import retrofit2.Response
import javax.inject.Inject

class NetworkDataSourceImp @Inject constructor(private val apiService: MoviesService) :
    NetworkDataSource {

    override suspend fun getAllMoviesData(page: Int): Response<MoviesResponse> =
        apiService.getTrendingMovies(page=page)

    override suspend fun getConfigurationData(): Response<ConfigurationResponse> =
        apiService.getConfiguration()
}