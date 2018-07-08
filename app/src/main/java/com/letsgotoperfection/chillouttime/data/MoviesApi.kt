package com.letsgotoperfection.chillouttime.data

import com.letsgotoperfection.chillouttime.models.Results
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author hossam.
 */
interface MoviesApi {
    @GET("movie/now_playing?api_key=8e630989b36d359dcf7d077d1487584e")
    fun getPlayingMovies(@Query("page") count: Int = 1): Flowable<Results>
}