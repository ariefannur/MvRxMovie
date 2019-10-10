package github.ariefannur.mvrx.movie.core.viewmodel

import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.Success
import github.ariefannur.mvrx.movie.core.base.MvRxViewModel
import github.ariefannur.mvrx.movie.core.state.MovieApi
import github.ariefannur.mvrx.movie.core.state.MovieHomeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel(val initialState: MovieHomeState, val api: MovieApi) : MvRxViewModel<MovieHomeState>(initialState) {


    fun getPopular() = withState { state ->

        setState {
            copy(movies = Loading())
        }

        GlobalScope.launch(parentJob) {

           val popular = api.getPopularMovie().results
           setState {
               copy(movies = Success(popular))
           }

        }
    }

    fun getLattes(starDate: String, endDate: String){

        setState {
            copy(movieLattes = Loading())
        }

        GlobalScope.launch(parentJob) {

            val popular = api.getNewestMovie(starDate, endDate).results
            setState {
                copy(movieLattes = Success(popular))
            }

        }
    }
}