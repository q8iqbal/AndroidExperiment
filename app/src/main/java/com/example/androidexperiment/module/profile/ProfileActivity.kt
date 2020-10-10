package com.example.androidexperiment.module.profile

import android.view.View
import com.example.androidexperiment.base.BaseActivity

class ProfileActivity : BaseActivity(){
    lateinit var profileFragment : ProfileFragment
    override fun initializeFragment() {
        initializeView()
        setTitle("Profile")
        btProfile?.visibility = View.GONE
        profileFragment = ProfileFragment()
        setCurrentFragment(profileFragment)
    }
}