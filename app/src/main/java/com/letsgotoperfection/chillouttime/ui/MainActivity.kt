package com.letsgotoperfection.chillouttime.ui

import com.letsgotoperfection.chillouttime.NavigationManager
import com.letsgotoperfection.chillouttime.R
import com.letsgotoperfection.chillouttime.ui.base.BaseActivity
import com.letsgotoperfection.chillouttime.ui.movies.MoviesFragment


class MainActivity : BaseActivity() {

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }

    override fun getTitleResourceId(): String {
        return getString(R.string.app_name)
    }

    override fun init() {
        NavigationManager.attachAsRoot(this, MoviesFragment())
    }
}
