package com.example.androidexperiment.module.login

import android.content.Intent
import com.example.androidexperiment.base.BasePresenter
import com.example.androidexperiment.base.BaseView

interface LoginContract {
    interface Presenter : BasePresenter{
        abstract fun performLogin(email: String?, password: String?)

    }

    interface View : BaseView<Presenter>{
        abstract fun redirectToProfile(intent: Intent)
    }
}