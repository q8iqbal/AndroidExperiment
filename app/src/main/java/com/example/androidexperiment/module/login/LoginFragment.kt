package com.example.androidexperiment.module.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.example.androidexperiment.R
import com.example.androidexperiment.base.BaseFragment

class LoginFragment : BaseFragment(), LoginContract.View {

    private var mPresenter : LoginContract.Presenter? = null
    private lateinit var mRootView : View
    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var btLogin : Button

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mRootView = inflater.inflate(R.layout.fragment_login, container, false)
        etEmail = mRootView.findViewById(R.id.et_email)
        etPassword = mRootView.findViewById(R.id.et_password)
        btLogin = mRootView.findViewById(R.id.bt_login)
        btLogin!!.setOnClickListener{
            setBtnLoginClick()
        }
        attachPresenter(LoginPresenter(this))
        return mRootView
    }

    override fun redirectToProfile(intent: Intent) {
        startActivity(intent)
        activity?.finish()
    }

    override fun attachPresenter(presenter: LoginContract.Presenter) {
        mPresenter = presenter
    }

    override fun detachPresenter() {
        mPresenter?.onDestroy()
        mPresenter = null
    }

    private fun setBtnLoginClick(){
        val email: String = etEmail.text.toString()
        val password : String = etPassword.text.toString()
        mPresenter!!.performLogin(email,password)
    }
}