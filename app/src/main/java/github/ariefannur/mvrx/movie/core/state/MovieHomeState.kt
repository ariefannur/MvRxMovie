package github.ariefannur.mvrx.movie.core.state

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import github.ariefannur.mvrx.movie.core.model.Movie

data class MovieHomeState(
    val movies: Async<List<Movie>> = Uninitialized,
    val movieLattes: Async<List<Movie>> = Uninitialized
) : MvRxState