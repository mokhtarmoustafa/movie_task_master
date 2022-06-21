package com.mokhtar.trendsmovietask.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.mokhtar.trendsmovietask.data.remote.NetworkController
import com.mokhtar.androidmoviestask.data.remote.NetworkDataSourceImp
import com.mokhtar.androidmoviestask.data.remote.model.configuration.ConfigurationResponse
import com.mokhtar.androidmoviestask.data.remote.model.movie.MoviesResponse
import com.mokhtar.trendsmovietask.data.local.dao.MovieDao
import com.mokhtar.trendsmovietask.ui.home.TrendingPagingSource
import com.mokhtar.trendsmovietask.util.State
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

@ActivityRetainedScoped
class MoviesRepository @Inject constructor(
    private val moviesService: NetworkDataSourceImp,
    private val dao: MovieDao
)
     {
     fun getAllMoviesData(): Flow<State<MoviesResponse>> {
      return object: NetworkController<MoviesResponse, MoviesResponse>(){
          override suspend fun saveRemoteData(response: MoviesResponse) =Unit

          override fun fetchFromLocal(): Flow<MoviesResponse>? =null

          override suspend fun fetchFromRemote(): Response<MoviesResponse> = moviesService.getAllMoviesData(1)

      }.asFlow().flowOn(Dispatchers.IO)
    }

     fun getConfigurationData(): Flow<State< ConfigurationResponse>> {
       return   object: NetworkController<ConfigurationResponse, ConfigurationResponse>(){
           override suspend fun saveRemoteData(response: ConfigurationResponse) =dao.insertNewConfiguration(response)

           override fun fetchFromLocal(): Flow<ConfigurationResponse> =dao.getAllConfiguration()

           override suspend fun fetchFromRemote(): Response<ConfigurationResponse> = moviesService.getConfigurationData()
       }.asFlow().flowOn(Dispatchers.IO)
    }

         fun getTrends(
             page:Int
         ) = Pager(
             PagingConfig(
                 pageSize = 20,
                 maxSize = 100
             )
         ) {
             TrendingPagingSource(moviesService)
         }

}


