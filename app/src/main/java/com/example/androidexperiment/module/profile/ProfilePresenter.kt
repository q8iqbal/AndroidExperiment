package com.example.androidexperiment.module.profile

import com.example.androidexperiment.base.BasePresenter

class ProfilePresenter(private var mView : ProfileFragment?) : ProfileContract.Presenter {
    override fun onDestroy() {
        mView = null
    }
}