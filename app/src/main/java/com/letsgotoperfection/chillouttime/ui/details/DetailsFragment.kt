package com.letsgotoperfection.chillouttime.ui.details

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
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
        imgMoviePoster.loadUrl(movie.poster_path)

//        btnShare.setOnClickListener {
//            shareContent()
//        }
//        btnBack.setOnClickListener {
//            NavigationManager.navigateBack(this.activity)
//        }
    }

    private fun getTitleTextView(toolbar: Toolbar): Any? {
        try {
            val toolbarClass = Toolbar::class.java
            val titleTextViewField = toolbarClass.getDeclaredField("mTitleTextView")
            titleTextViewField.isAccessible = true

            return titleTextViewField.get(toolbar)
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
        return null
    }

    override fun shareContent() {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, movie.original_title)
        startActivity(Intent.createChooser(shareIntent, getString(R.string.send_to)))
    }
}