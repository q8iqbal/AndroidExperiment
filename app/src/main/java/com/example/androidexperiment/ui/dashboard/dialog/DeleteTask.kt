package com.example.androidexperiment.ui.dashboard.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidexperiment.R
import com.example.androidexperiment.base.BaseDialog
import com.example.androidexperiment.model.Task
import kotlinx.android.synthetic.main.dialog_delete_task.*

class DeleteTask(var task : Task) : BaseDialog<TaskListener.Delete>() {
    val TAG = "delete_dialog"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.dialog_delete_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_dialog_title.text = "Hapus bambang"
        tv_title.text = task.title
        tv_desc.text = task.description

        bt_ok.setOnClickListener {
            listener?.deleteTask(task)
            dismiss()
        }

        bt_cancel.setOnClickListener {
            dismiss()
        }
    }
}