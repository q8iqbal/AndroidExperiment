package com.example.androidexperiment.ui.dashboard.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidexperiment.R
import kotlinx.android.synthetic.main.dialog_create_task.*

class UpdateTask : BaseDialog<TaskListener.Update>(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.dialog_create_task , container, false )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_add_task_title.text = "Update Bambang"

        bt_create_task_cancel.setOnClickListener {
            dismiss()
        }

        bt_create_task_ok.setOnClickListener {
            updateTask()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as TaskListener.Update
        } catch (error: ClassCastException) {
            throw ClassCastException(error.message)
        }
    }

    private fun updateTask() {

    }
}