package com.example.androidexperiment.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import com.example.androidexperiment.R

abstract class BaseActivity : FragmentActivity() {

    protected var currentFragment : BaseFragment? = null
    protected var tvToolbarTitle: TextView? = null
    protected var flFragmentContainer: FrameLayout? = null
    protected var btBack: ImageButton? = null
    protected var vMenuBarShadow: View? = null
    protected var rlActivityFragmentHolder: RelativeLayout? = null

    abstract fun initializeFragment();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
        initializeFragment()
    }

    fun initializeView(){
        setContentView(R.layout.base_activity)
        tvToolbarTitle = findViewById(R.id.tvToolbarTitle) as TextView
        flFragmentContainer = findViewById(R.id.flFragmentContainer) as FrameLayout
        btBack = findViewById(R.id.btBack) as ImageButton
        vMenuBarShadow = findViewById(R.id.vMenuBarShadow)
        rlActivityFragmentHolder = findViewById(R.id.rlActivityFragmentHolder) as RelativeLayout
        btBack!!.setOnClickListener { onBackPressed() }
    }

    @JvmName("setCurrentFragment1")
    fun setCurrentFragment(fragment: BaseFragment){
        val fragmenManager = supportFragmentManager
        val fragmentTransaction = fragmenManager.beginTransaction()
        fragmentTransaction.add(R.id.flFragmentContainer, fragment)
        fragmentTransaction.commit()
        currentFragment = fragment
    }
}