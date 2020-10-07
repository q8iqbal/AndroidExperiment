package com.example.androidexperiment.module.profile

import com.example.androidexperiment.base.BasePresenter
import com.example.androidexperiment.base.BaseView

interface ProfileContract {
    interface Presenter : BasePresenter{

    }

    interface View : BaseView<Presenter>{
        abstract fun displayIntent();
    }
}