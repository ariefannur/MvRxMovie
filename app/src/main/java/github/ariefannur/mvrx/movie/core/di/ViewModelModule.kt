package github.ariefannur.mvrx.movie.core.di

import github.ariefannur.mvrx.movie.core.state.MovieHomeState
import github.ariefannur.mvrx.movie.core.viewmodel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        HomeViewModel(MovieHomeState(), get())
    }
}