package github.ariefannur.mvrx.movie.feature.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object{
        fun previewDetail(context: Context, id:Int){
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("id", id)
            }
            context.startActivity(intent)
        }
    }

}