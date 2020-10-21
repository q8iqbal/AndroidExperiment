package com.example.androidexperiment.ui.profile

import android.view.View
import com.example.androidexperiment.base.BaseActivity
import kotlinx.android.synthetic.main.base_toolbar_layout.*

class ProfileActivity : BaseActivity(){
    lateinit var profileFragment : ProfileFragment
    override fun initializeFragment() {
        initializeView()
        setTitle("Profile")
        bt_Profile.visibility = View.GONE
        profileFragment = ProfileFragment()
        setCurrentFragment(profileFragment)
    }
}