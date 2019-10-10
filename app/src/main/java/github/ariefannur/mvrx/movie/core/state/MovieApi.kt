package github.ariefannur.mvrx.movie.core.state

import github.ariefannur.mvrx.movie.core.model.Movie
import github.ariefannur.mvrx.movie.core.model.MovieResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi{

    @GET("trending/movie/week")
    suspend fun getPopularMovie() : MovieResult

    @GET("discover/movie")
    suspend fun getNewestMovie(
        @Query("primary_release_date.gt") startDate:String,
        @Query("primary_release_date.lte") endDate:String
                               ) : MovieResult

    @GET("movie/{id}")
    suspend fun getDetailMovie(@Path("id") id:Int) : Movie


}