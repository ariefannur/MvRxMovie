package github.ariefannur.mvrx.movie.feature.home


import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.mvrx.Loading
import github.ariefannur.mvrx.movie.R
import github.ariefannur.mvrx.movie.core.base.BaseActivity
import github.ariefannur.mvrx.movie.core.state.MovieHomeState
import github.ariefannur.mvrx.movie.core.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : BaseActivity(){


    override fun getLayout(): Int  = R.layout.activity_main

    private val movieViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rv_popular.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_new.layoutManager = LinearLayoutManager(this)

        movieViewModel.getPopular()
        val cal = Calendar.getInstance()
        cal.time = Date()
        val dateStart = "${cal.get(Calendar.YEAR)}-0${cal.get(Calendar.MONTH)}-01"
        val dateEnd = "${cal.get(Calendar.YEAR)}-0${cal.get(Calendar.MONTH)}-30"
        movieViewModel.getLattes(dateStart, dateEnd)
    }

    override fun invalidate() {
        movieViewModel.selectSubscribe(MovieHomeState::movies) {
            if (it is Loading) {

            }
            it.invoke()?.let {
                if (it.isNotEmpty()) {
                    Log.d("AF", " list popular : ${it.size}")
                    rv_popular.adapter = AdapterPopularMovie(it, false)
                }
            }
        }

        movieViewModel.selectSubscribe(MovieHomeState::movieLattes) {
            if (it is Loading) {

            }
            it.invoke()?.let {
                if (it.isNotEmpty()) {
                    Log.d("AF", " list lattes : ${it.size}")
                    rv_new.adapter = AdapterPopularMovie(it, true)
                }
            }
        }
    }

}
