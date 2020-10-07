package com.example.androidexperiment.module.profile

import com.example.androidexperiment.base.BaseActivity

class ProfileActivity : BaseActivity(){
    lateinit var profileFragment : ProfileFragment
    override fun initializeFragment() {
        initializeView()
        profileFragment = ProfileFragment()
        setCurrentFragment(profileFragment)
    }
}