package com.letsgotoperfection.chillouttime.ui.details

import com.letsgotoperfection.chillouttime.models.Movie
import com.letsgotoperfection.chillouttime.ui.base.BasePresenter


/**
 * @author hossam.
 */
class DetailsPresenter(private val detailsView: DetailsContract.View)
    : BasePresenter<DetailsContract.View>(detailsView), DetailsContract.Presenter {

    override fun getExistedMovie(): Movie {
        return DetailsModel.movie
    }

    override fun destroy() {
        DetailsModel.destroy()
    }
}