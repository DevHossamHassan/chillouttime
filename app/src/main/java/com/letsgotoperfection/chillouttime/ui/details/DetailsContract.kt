package com.letsgotoperfection.chillouttime.ui.details

import android.app.Fragment
import com.letsgotoperfection.chillouttime.models.Movie
import com.letsgotoperfection.chillouttime.ui.base.BaseContract


/**
 * @author hossam.
 */
class DetailsContract : BaseContract {

    interface View : BaseContract.View<Fragment>

    interface Presenter : BaseContract.Presenter {
        fun getExistedMovie(): Movie
        fun destroy()
    }
}