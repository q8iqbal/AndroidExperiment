package com.example.androidexperiment.ui.dashboard.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidexperiment.R
import com.example.androidexperiment.base.BaseDialog
import com.example.androidexperiment.model.Task
import kotlinx.android.synthetic.main.dialog_create_task.*

class UpdateTask(var task : Task) : BaseDialog<TaskListener.Update>(){

    val TAG = "update_dialog"

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
        tv_title.text = "Update Bambang"

        bt_cancel.setOnClickListener {
            dismiss()
        }

        bt_ok.setOnClickListener {
            listener?.updateTask(task , et_task_title.text.toString() , et_task_title.text.toString() )
            dismiss()
        }
    }
}