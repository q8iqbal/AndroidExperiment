package com.example.androidexperiment.ui.login

import android.content.Intent
import com.example.androidexperiment.base.BasePresenter
import com.example.androidexperiment.base.BaseView

interface LoginContract {
    interface Presenter : BasePresenter{
        fun performLogin(email: String?, password: String?)

    }

    interface View : BaseView<Presenter>{
        fun redirectToProfile(intent: Intent)
    }
}