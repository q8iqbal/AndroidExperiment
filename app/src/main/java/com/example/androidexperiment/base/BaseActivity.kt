package com.example.androidexperiment.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidexperiment.R
import com.example.androidexperiment.ui.profile.ProfileActivity
import kotlinx.android.synthetic.main.base_toolbar_layout.*

abstract class BaseActivity : AppCompatActivity(){

    protected var currentFragment : BaseFragment? = null

    abstract fun initializeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
        initializeFragment()
    }

    protected fun initializeView(){
        setContentView(R.layout.base_activity)

        btBack.setOnClickListener { onBackPressed() }
        bt_Profile.setOnClickListener { redirect() }
    }

    protected fun setTitle(title : String){
        tvToolbarTitle.text = title
    }

    @JvmName("setCurrentFragment1")
    fun setCurrentFragment(fragment: BaseFragment){
        val fragmenManager = supportFragmentManager
        val fragmentTransaction = fragmenManager.beginTransaction()
        fragmentTransaction.add(R.id.flFragmentContainer, fragment)
        fragmentTransaction.commit()
        currentFragment = fragment
    }

    private fun redirect(){
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
}