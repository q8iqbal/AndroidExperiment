package com.example.androidexperiment.module.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.androidexperiment.R
import com.example.androidexperiment.base.BaseFragment

class ProfileFragment : BaseFragment(), ProfileContract.View{

    private var mPresenter : ProfileContract.Presenter? = null
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
        displayIntent()
        attachPresenter(ProfilePresenter(this))
        return mRootView
    }

    override fun displayIntent() {
        val intent = activity?.intent
        tvEmail.text = intent?.getStringExtra("email")
        tvPassword.text = intent?.getStringExtra("password")
    }

    override fun attachPresenter(presenter: ProfileContract.Presenter) {
        mPresenter = presenter
    }

    override fun detachPresenter() {
        mPresenter?.onDestroy()
        mPresenter = null
    }

}