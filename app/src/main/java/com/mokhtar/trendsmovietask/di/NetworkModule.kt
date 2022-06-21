package com.mokhtar.trendsmovietask.di


import com.mokhtar.trendsmovietask.data.remote.api.MoviesService
import com.mokhtar.trendsmovietask.util.ApiInterceptor
import com.mokhtar.trendsmovietask.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(interceptor) //for log the response
            .addNetworkInterceptor(ApiInterceptor()) //for modify request to add apikey with each request
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS).build()
    }

    @Singleton
    @Provides
    fun provideGsonConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttp: OkHttpClient
    ): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(BASE_URL)
            .client(okHttp)
            .build()
    }


    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit): MoviesService =
        retrofit.create(MoviesService::class.java)


}