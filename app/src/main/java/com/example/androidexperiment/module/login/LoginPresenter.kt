package com.example.androidexperiment.module.login

import android.content.Intent
import com.example.androidexperiment.module.profile.ProfileActivity

class LoginPresenter(private var mView : LoginFragment?) : LoginContract.Presenter {

    override fun performLogin(email: String?, password: String?) {
        val intent = Intent(mView?.activity , ProfileActivity::class.java)
        intent.putExtra("email",email)
        intent.putExtra("password", password)
        mView?.redirectToProfile(intent)
    }

    override fun onDestroy() {
        mView = null
    }
}