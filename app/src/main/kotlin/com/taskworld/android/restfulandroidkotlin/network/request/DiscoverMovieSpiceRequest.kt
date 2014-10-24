package com.taskworld.android.restfulandroidkotlin.network.request

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest
import com.taskworld.android.restfulandroidkotlin.model.Movie
import com.taskworld.android.restfulandroidkotlin.api.TheMovieDB

/**
 * Created by Kittinun Vantasin on 10/24/14.
 */

class DiscoverMovieSpiceRequest(val sortBy: String) : RetrofitSpiceRequest<Movie.List, TheMovieDB>(javaClass<Movie.List>(), javaClass<TheMovieDB>()) {

    override fun loadDataFromNetwork(): Movie.List? {
        return getService().discoverMovies(sortBy)
    }

}
