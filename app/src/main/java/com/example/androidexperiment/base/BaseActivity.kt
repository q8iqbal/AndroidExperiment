package com.example.androidexperiment.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.androidexperiment.R
import com.example.androidexperiment.module.profile.ProfileActivity

abstract class BaseActivity : AppCompatActivity(){

    protected var currentFragment : BaseFragment? = null
    protected var tvToolbarTitle: TextView? = null
    protected var flFragmentContainer: FrameLayout? = null
    protected var btBack: ImageButton? = null
    protected var btProfile: ImageButton? = null
    protected var vMenuBarShadow: View? = null
    protected var rlActivityFragmentHolder: ConstraintLayout? = null

    abstract fun initializeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
        initializeFragment()
    }

    protected fun initializeView(){
        setContentView(R.layout.base_activity)

        vMenuBarShadow = findViewById(R.id.vMenuBarShadow)
        tvToolbarTitle = findViewById<TextView>(R.id.tvToolbarTitle)
        flFragmentContainer = findViewById<FrameLayout>(R.id.flFragmentContainer)
        rlActivityFragmentHolder = findViewById<ConstraintLayout>(R.id.clActivityFragmentHolder)
        btBack = findViewById<ImageButton>(R.id.btBack)
        btProfile = findViewById<ImageButton>(R.id.bt_Profile)
        btBack?.setOnClickListener { onBackPressed() }
        btProfile?.setOnClickListener { redirect() }
    }

    protected fun setTitle(title : String){
        tvToolbarTitle?.text = title
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