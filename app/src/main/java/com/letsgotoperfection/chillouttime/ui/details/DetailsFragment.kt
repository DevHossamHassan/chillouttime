package com.letsgotoperfection.chillouttime.ui.details

import android.os.Bundle
import android.view.View
import com.letsgotoperfection.chillouttime.NavigationManager
import com.letsgotoperfection.chillouttime.R
import com.letsgotoperfection.chillouttime.models.Movie
import com.letsgotoperfection.chillouttime.ui.base.BaseFragment
import com.letsgotoperfection.chillouttime.utils.loadUrl
import com.letsgotoperfection.chillouttime.utils.putArgs
import kotlinx.android.synthetic.main.fragment_details.*


/**
 * @author hossam.
 */
class DetailsFragment : BaseFragment<DetailsContract.Presenter>(), DetailsContract.View {

    override val fragmentLayoutResourceId = R.layout.fragment_details
    lateinit var movie: Movie

    companion object {
        fun newInstance(movie: Movie) = DetailsFragment().putArgs {
            val args = Bundle()
            args.putSerializable("movie", movie)
            val fragment = DetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun init(savedInstanceState: Bundle?) {
        presenter = DetailsPresenter(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movie = arguments.getSerializable("movie") as Movie
        setUpViews()
    }

    private fun setUpViews() {
        collapsingToolbar.title = movie.title
        txtMovieOverview.text = movie.overview
        txtMovieReleaseDate.text = movie.release_date
        txtMovieRate.text = movie.vote_average.toString()
        imgMoviePoster.loadUrl(movie.poster_path)
        imgBack.setOnClickListener {
            NavigationManager.navigateBack(this.activity)
        }
    }
}