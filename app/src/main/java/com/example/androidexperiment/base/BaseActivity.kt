package com.example.androidexperiment.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidexperiment.R
import com.example.androidexperiment.databinding.BaseActivityBinding
import com.example.androidexperiment.ui.profile.ProfileActivity

abstract class BaseActivity : AppCompatActivity(){

    protected var currentFragment : BaseFragment<*>? = null
    protected lateinit var binding: BaseActivityBinding

    abstract fun initializeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
        initializeFragment()
    }

    protected fun initializeView(){
        binding = BaseActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.layoutToolbar.btProfile.setOnClickListener {
            this.redirect()
        }

        binding.layoutToolbar.btBack.setOnClickListener {
            onBackPressed()
        }
    }

    protected fun setTitle(title : String){
        binding.layoutToolbar.tvToolbarTitle.text = title
    }

    @JvmName("setCurrentFragment1")
    fun setCurrentFragment(fragment: BaseFragment<*>){
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