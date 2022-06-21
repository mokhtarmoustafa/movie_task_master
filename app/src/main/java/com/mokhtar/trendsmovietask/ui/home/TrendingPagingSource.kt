package com.mokhtar.trendsmovietask.ui.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mokhtar.trendsmovietask.data.remote.NetworkDataSourceImp
import com.mokhtar.androidmoviestask.data.remote.model.movie.Movie
import retrofit2.HttpException
import java.io.IOException

class TrendingPagingSource(
    private val service: NetworkDataSourceImp,
) : PagingSource<Int, Movie>() {


    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val response = service.getAllMoviesData(
                page = nextPage
            )
            LoadResult.Page(
                data = response.body()!!.results,
                prevKey = null,
                nextKey = response.body()!!.page+1
            )
        } catch (ex: IOException) {
            LoadResult.Error(ex)
        } catch (ex: HttpException) {
            LoadResult.Error(ex)
        }
    }

}
