package com.example.androidexperiment.module.dashboard

import com.example.androidexperiment.base.BaseActivity

class DashboardActivity : BaseActivity(){

    lateinit var dashboardFragment : DashboardFragment

    override fun initializeFragment() {
        initializeView()
        setTitle("Hallo Bambang")
        dashboardFragment = DashboardFragment()
        setCurrentFragment(dashboardFragment)
    }
}