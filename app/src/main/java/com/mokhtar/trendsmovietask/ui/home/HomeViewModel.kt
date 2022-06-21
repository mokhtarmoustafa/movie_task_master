package com.mokhtar.trendsmovietask.ui.home

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mokhtar.androidmoviestask.data.remote.model.configuration.ConfigurationResponse
import com.mokhtar.androidmoviestask.data.remote.model.movie.Movie
import com.mokhtar.androidmoviestask.data.remote.model.movie.MoviesResponse
import com.mokhtar.trendsmovietask.data.remote.repository.MoviesRepository
import com.mokhtar.trendsmovietask.ui.base.BaseViewModel
import com.mokhtar.trendsmovietask.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val moviesMoviesRepositoryImp: MoviesRepository
) : BaseViewModel(),
    HomeViewModelUseCases {

    //region variables

    private var _moviesData = MutableStateFlow<State<MoviesResponse>>(State.Loading())
    private var _configurationData = MutableStateFlow<State<ConfigurationResponse>>(State.Loading())

    override val configurationLiveData: Flow<State<ConfigurationResponse>>
        get() = _configurationData
    //endregion


//region helper function


    override val movieList: Flow<PagingData<Movie>> =
        _moviesData.flatMapLatest {
            moviesMoviesRepositoryImp.getTrends(FIRST_PAGE_INDEX).flow.cachedIn(viewModelScope)
        }


    override fun getConfigurationData() {
        viewModelScope.launch {
            moviesMoviesRepositoryImp.getConfigurationData().collect {
                it?.let {
                    _configurationData.value = it
                }

            }
        }
    }



    companion object {
        const val FIRST_PAGE_INDEX = 0
    }

    //endregion
}