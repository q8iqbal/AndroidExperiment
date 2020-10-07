package com.example.androidexperiment.base

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment() : Fragment() {

    protected var activity : BaseActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.activity = context as BaseActivity
    }
}