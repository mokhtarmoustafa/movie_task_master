package com.mokhtar.trendsmovietask.data.remote

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.mokhtar.trendsmovietask.util.State

import kotlinx.coroutines.flow.*
import retrofit2.Response


abstract class NetworkController<RESULT, REQUEST> {
    fun asFlow() = flow {

        // Emit Loading State
        emit(State.loading())


        try {

            // Emit Database content first
            fetchFromLocal()?.let {
                emit(State.success(it.first()))
            }
            // Fetch latest currency from remote
            val apiResponse = fetchFromRemote()

            // Parse body
            val remoteCurrencies = apiResponse.body()

            // Check for response validation
            if (apiResponse.isSuccessful && remoteCurrencies != null) {
                // Save currencies into the persistence storage
                emit(State.success(remoteCurrencies as RESULT))
                saveRemoteData(remoteCurrencies)
            } else {
                emit(State.error(apiResponse.message()))
            }
        } catch (e: Exception) {
            // Exception occurred! Emit error
            emit(State.error("Network error! Can't get latest Data."))
            e.printStackTrace()
        }
    }

    /**
     * Saves retrieved from remote into the persistence storage.
     */
    @WorkerThread
    abstract suspend fun saveRemoteData(response: REQUEST)

    /**
     * Retrieves all data from persistence storage.
     */

    @MainThread
    abstract fun fetchFromLocal(): Flow<RESULT>?

    /**
     * Fetches [Response] from the remote end point.
     */
    @MainThread
    protected abstract suspend fun  fetchFromRemote(): Response<REQUEST>
}