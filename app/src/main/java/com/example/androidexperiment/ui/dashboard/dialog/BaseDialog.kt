package com.example.androidexperiment.ui.dashboard.dialog

import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

open class BaseDialog<T> : DialogFragment() {

    protected var listener : T? = null

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            it.window?.setLayout(width, height)
        }
    }

    fun addListener(fragment : T){
        listener = fragment
    }
}