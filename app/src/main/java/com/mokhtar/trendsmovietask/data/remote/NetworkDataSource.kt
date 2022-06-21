package com.mokhtar.androidmoviestask.data.remote

import com.mokhtar.androidmoviestask.data.remote.model.configuration.ConfigurationResponse
import com.mokhtar.androidmoviestask.data.remote.model.movie.MoviesResponse
import com.mokhtar.androidmoviestask.util.State
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

@ActivityRetainedScoped
interface NetworkDataSource {

    suspend fun getAllMoviesData(page:Int): Response<MoviesResponse>

   suspend fun getConfigurationData(): Response<ConfigurationResponse>
}