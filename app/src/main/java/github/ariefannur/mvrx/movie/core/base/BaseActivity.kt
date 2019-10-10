package github.ariefannur.mvrx.movie.core.base

import android.os.Bundle
import com.airbnb.mvrx.BaseMvRxActivity
import com.airbnb.mvrx.MvRxView
import com.airbnb.mvrx.MvRxViewId

abstract class BaseActivity : BaseMvRxActivity(), MvRxView{

    abstract fun getLayout() : Int

    private val mvrxViewIdProperty = MvRxViewId()
    final override val mvrxViewId: String by mvrxViewIdProperty

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        postInvalidate()

    }


}