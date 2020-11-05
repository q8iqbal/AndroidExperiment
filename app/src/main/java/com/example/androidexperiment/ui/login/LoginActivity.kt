package com.example.androidexperiment.ui.login

import android.view.View
import com.example.androidexperiment.base.BaseActivity
import com.example.androidexperiment.base.BaseFragment
import com.example.androidexperiment.util.AppPreference
import kotlinx.android.synthetic.main.base_toolbar_layout.*

class LoginActivity : BaseActivity(){

    lateinit var loginFragment: BaseFragment<*>

    override fun initializeFragment() {
        initializeView()
        setTitle("Sign In")
        AppPreference.init(applicationContext)

        binding.layoutToolbar.btBack.visibility = View.GONE
        binding.layoutToolbar.btProfile.visibility = View.GONE

        loginFragment = LoginFragment()
        setCurrentFragment(loginFragment)
    }
}