package com.mokhtar.trendsmovietask.data.remote

import com.mokhtar.androidmoviestask.data.remote.model.configuration.ConfigurationResponse
import com.mokhtar.androidmoviestask.data.remote.model.movie.MoviesResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response

@ActivityRetainedScoped
interface NetworkDataSource {

    suspend fun getAllMoviesData(page:Int): Response<MoviesResponse>

   suspend fun getConfigurationData(): Response<ConfigurationResponse>
}