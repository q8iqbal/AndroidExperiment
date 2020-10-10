package com.example.androidexperiment.module.dashboard.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.androidexperiment.R
import kotlinx.android.synthetic.main.dialog_create_task.*

class CreateTask : DialogFragment(){

    val TAG = "new_dialog"
    private lateinit var listener : TaskListener.Create

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.dialog_create_task,container,false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_add_task_title.text = "Tambah Bambang"
        bt_create_task_ok.setOnClickListener {
            createTask()
        }

        bt_create_task_cancel.setOnClickListener {
            dismiss()
        }
    }

    fun addListener(fragment : TaskListener.Create){
        listener = fragment
    }

    fun createTask(){
        val title = inputLayoutTitle.editText?.text.toString()
        val desc = inputLayoutDescription.editText?.text.toString()
        listener.createTask(title, desc)
        dismiss()
    }
}