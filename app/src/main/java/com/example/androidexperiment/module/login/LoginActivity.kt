package com.example.androidexperiment.module.login

import android.view.View
import com.example.androidexperiment.base.BaseActivity
import com.example.androidexperiment.util.AppPreference

class LoginActivity : BaseActivity(){

    lateinit var loginFragment: LoginFragment

    override fun initializeFragment() {
        initializeView()
        setTitle("Sign In")
        AppPreference.init(applicationContext)
        btBack?.visibility = View.GONE
        btProfile?.visibility = View.GONE
        loginFragment = LoginFragment()
        setCurrentFragment(loginFragment)
    }
}