package com.example.androidexperiment.module.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.androidexperiment.R
import com.example.androidexperiment.base.BaseFragment
import com.example.androidexperiment.base.BasePresenter
import com.example.androidexperiment.util.AppPreference

class ProfileFragment : BaseFragment() {

    private lateinit var mRootView : View
    private lateinit var tvEmail : TextView
    private lateinit var tvPassword : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mRootView = inflater.inflate(R.layout.fragment_profile, container, false)
        tvEmail = mRootView.findViewById(R.id.tv_name)
        tvPassword = mRootView.findViewById(R.id.tv_password)
        showData()
        return mRootView
    }

    private fun showData() {
        tvEmail.text = AppPreference.read(AppPreference.EMAIL, "")
        tvPassword.text = AppPreference.read(AppPreference.PASSWORD, "")
    }
}