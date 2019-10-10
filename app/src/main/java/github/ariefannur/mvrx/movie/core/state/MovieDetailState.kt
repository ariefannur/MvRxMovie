package github.ariefannur.mvrx.movie.core.state

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import github.ariefannur.mvrx.movie.core.model.Movie

data class MovieDetailState (
    val movie: Async<Movie> = Uninitialized
) : MvRxState