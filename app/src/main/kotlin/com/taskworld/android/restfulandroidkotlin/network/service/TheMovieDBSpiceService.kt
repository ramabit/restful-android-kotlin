package com.taskworld.android.restfulandroidkotlin.network.service

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService
import retrofit.RestAdapter
import com.taskworld.android.restfulandroidkotlin.api.TheMovieDB

class TheMovieDBSpiceService : RetrofitGsonSpiceService() {

    class object {

        val BASE_URL = "http://api.themoviedb.org/3"

        val API_KEY = "api_key"
        val API_VALUE = "11a11c4dcdc3909ab42b09a5e531b74f"
    }

    override fun getServerUrl(): String? {
        return BASE_URL
    }

    override fun createRestAdapterBuilder(): RestAdapter.Builder? {
        var builder = super<RetrofitGsonSpiceService>.createRestAdapterBuilder()
        builder.setRequestInterceptor { requestInterceptor -> requestInterceptor.addQueryParam(API_KEY, API_VALUE) }
            .setLogLevel(RestAdapter.LogLevel.FULL)
        return builder
    }

    override fun onCreate() {
        super<RetrofitGsonSpiceService>.onCreate()
        addRetrofitInterface(javaClass<TheMovieDB>())
    }
}
