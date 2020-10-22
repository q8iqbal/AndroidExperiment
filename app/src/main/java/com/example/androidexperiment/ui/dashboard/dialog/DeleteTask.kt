package com.example.androidexperiment.ui.dashboard.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidexperiment.R
import com.example.androidexperiment.model.Task
import kotlinx.android.synthetic.main.dialog_delete_task.*
import kotlin.ClassCastException

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
        tv_Dialog_Title.text = "Hapus bambang"
        tv_Title.text = task.title
        tv_Desc.text = task.description

        bt_Ok.setOnClickListener {
            listener?.deleteTask(task)
            dismiss()
        }

        bt_Cancel.setOnClickListener {
            dismiss()
        }
    }
}