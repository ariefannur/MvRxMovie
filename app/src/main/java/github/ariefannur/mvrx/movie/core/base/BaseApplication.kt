package github.ariefannur.mvrx.movie.core.base

import android.app.Application
import github.ariefannur.mvrx.movie.core.di.networkModule
import github.ariefannur.mvrx.movie.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    private val modules = listOf(
        networkModule, viewModelModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@BaseApplication)
            modules(modules)

        }
    }
}