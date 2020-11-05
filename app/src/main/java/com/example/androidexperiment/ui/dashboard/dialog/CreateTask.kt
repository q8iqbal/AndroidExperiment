package com.example.androidexperiment.ui.dashboard.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidexperiment.R
import com.example.androidexperiment.base.BaseDialog
import kotlinx.android.synthetic.main.dialog_create_task.*

class CreateTask : BaseDialog<TaskListener.Create>() {

    val TAG = "new_dialog"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_create_task,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_title.text = "Tambah Bambang"

        bt_ok.setOnClickListener {
            createTask()
        }

        bt_cancel.setOnClickListener {
            dismiss()
        }
    }

    fun createTask(){
        val title = inputLayoutTitle.editText?.text.toString()
        val desc = inputLayoutDescription.editText?.text.toString()
        listener?.createTask(title, desc)
        dismiss()
    }
}