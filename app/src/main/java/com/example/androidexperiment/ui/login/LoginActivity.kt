package com.example.androidexperiment.ui.login

import android.view.View
import com.example.androidexperiment.base.BaseActivity
import com.example.androidexperiment.util.AppPreference
import kotlinx.android.synthetic.main.base_toolbar_layout.*

class LoginActivity : BaseActivity(){

    lateinit var loginFragment: LoginFragment

    override fun initializeFragment() {
        initializeView()
        setTitle("Sign In")
        AppPreference.init(applicationContext)
        btBack.visibility = View.GONE
        bt_Profile.visibility = View.GONE
        loginFragment = LoginFragment()
        setCurrentFragment(loginFragment)
    }
}