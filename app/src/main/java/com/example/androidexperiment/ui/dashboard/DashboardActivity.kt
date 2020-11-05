package com.example.androidexperiment.ui.dashboard

import com.example.androidexperiment.base.BaseActivity
import com.example.androidexperiment.base.BaseFragment

class DashboardActivity : BaseActivity(){

    lateinit var dashboardFragment : BaseFragment<*>

    override fun initializeFragment() {
        initializeView()
        setTitle("Hallo Bambang")
        dashboardFragment = DashboardFragment()
        setCurrentFragment(dashboardFragment)
    }
}