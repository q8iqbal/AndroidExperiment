package com.example.androidexperiment.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidexperiment.base.BaseFragment
import com.example.androidexperiment.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<LoginContract.Presenter>(), LoginContract.View {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        attachPresenter(LoginPresenter(this))
        binding = FragmentLoginBinding.inflate(layoutInflater)

        binding.btLogin.setOnClickListener{
            setBtnLoginClick()
        }

        return binding.root
    }

    override fun redirectToProfile(intent: Intent) {
        startActivity(intent)
        getActivity()?.finish()
    }

    override fun attachPresenter(presenter: LoginContract.Presenter) {
        mPresenter = presenter
    }

    override fun detachPresenter() {
        mPresenter?.onDestroy()
        mPresenter = null
    }

    private fun setBtnLoginClick(){
        val email: String = binding.etEmail.text.toString()
        val password : String = binding.etPassword.text.toString()
        mPresenter!!.performLogin(email,password)
    }
}