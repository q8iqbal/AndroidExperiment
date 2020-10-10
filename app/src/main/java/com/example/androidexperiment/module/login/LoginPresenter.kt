package com.example.androidexperiment.module.login

import android.content.Intent
import android.content.SharedPreferences
import com.example.androidexperiment.module.dashboard.DashboardActivity
import com.example.androidexperiment.util.AppPreference

class LoginPresenter(private var mView : LoginFragment?) : LoginContract.Presenter {

    override fun performLogin(email: String?, password: String?) {
        val intent = Intent(mView?.activity , DashboardActivity::class.java)
        AppPreference.write(AppPreference.EMAIL, email.toString())
        AppPreference.write(AppPreference.PASSWORD, password.toString())
        mView?.redirectToProfile(intent)
    }

    override fun onDestroy() {
        mView = null
    }
}