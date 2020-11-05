package com.example.androidexperiment.ui.profile

import android.view.View
import com.example.androidexperiment.base.BaseActivity
import com.example.androidexperiment.base.BaseFragment
import kotlinx.android.synthetic.main.base_toolbar_layout.*

class ProfileActivity : BaseActivity(){
    lateinit var profileFragment : BaseFragment<*>
    override fun initializeFragment() {
        initializeView()
        setTitle("Profile")
        bt_profile.visibility = View.GONE
        profileFragment = ProfileFragment()
        setCurrentFragment(profileFragment)
    }
}