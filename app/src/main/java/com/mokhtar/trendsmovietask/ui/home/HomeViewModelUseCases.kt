package com.mokhtar.trendsmovietask.ui.home

import androidx.paging.PagingData
import com.mokhtar.androidmoviestask.data.remote.model.configuration.ConfigurationResponse
import com.mokhtar.androidmoviestask.data.remote.model.movie.Movie
import com.mokhtar.trendsmovietask.util.State
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow

@ActivityRetainedScoped
interface HomeViewModelUseCases {


    val movieList: Flow<PagingData<Movie>>
    val configurationLiveData: Flow<State<ConfigurationResponse>>

    fun getConfigurationData()
}