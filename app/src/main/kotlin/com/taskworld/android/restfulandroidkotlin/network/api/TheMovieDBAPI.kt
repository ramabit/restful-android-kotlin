package com.taskworld.android.restfulandroidkotlin.network.api

import com.taskworld.android.restfulandroidkotlin.model.Cast
import com.taskworld.android.restfulandroidkotlin.model.Image
import com.taskworld.android.restfulandroidkotlin.model.Movie
import com.taskworld.android.restfulandroidkotlin.model.TV
import retrofit.http.*

/**
 * Created by Kittinun Vantasin on 10/24/14.
 */

interface TheMovieDBAPI {

    interface MovieAPI {
        @GET("/{path}")
        fun get(@EncodedPath("path") path: String): Movie

        @GET("/{path}/now_playing")
        fun getNowPlayingList(@EncodedPath("path") path: String): Movie.ResultList

        @GET("/{path}/top_rated")
        fun getTopRatedList(@EncodedPath("path") path: String): Movie.ResultList

        @GET("/{path}/credits")
        fun getCastList(@EncodedPath("path") path: String): Cast.CastList

        @GET("/{path}/images")
        fun getPosterImageList(@EncodedPath("path") path: String): Image.PosterList

        @POST("/{path}")
        fun post(@EncodedPath("path") path: String, @Body movie: Movie)
    }

    interface Authentication {
        @GET("/authentication/token/new")
        fun getRequestToken(): Map<String, String>

        @GET("/authentication/token/validate_with_login")
        fun validateToken(@Query("username") username: String, @Query("password") password: String, @Query("request_token") token: String): Map<String, String>

        @GET("/authentication/session/new")
        fun getNewSession(@Query("request_token") token: String): Map<String, String>
    }

    interface TVAPI {
        @GET("/{path}")
        fun get(@EncodedPath("path") path: String): TV

        @GET("/{path}/airing_today")
        fun getAiringTodayList(@EncodedPath("path") path: String): TV.ResultList

        @GET("/{path}/popular")
        fun getPopularList(@EncodedPath("path") path: String): TV.ResultList

        @POST("/{path}")
        fun post(@EncodedPath("path") path: String, @Body TV: TV)
    }
}

