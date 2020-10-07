package com.example.androidexperiment.module.login

import android.view.View
import com.example.androidexperiment.base.BaseActivity

class LoginActivity : BaseActivity(){

    lateinit var loginFragment: LoginFragment

    override fun initializeFragment() {
        initializeView()
        btBack!!.visibility = View.GONE
        loginFragment = LoginFragment()
        setCurrentFragment(loginFragment)
    }
}