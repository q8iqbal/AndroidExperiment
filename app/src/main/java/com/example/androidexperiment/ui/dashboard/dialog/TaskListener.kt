package com.example.androidexperiment.ui.dashboard.dialog

import com.example.androidexperiment.model.Task
import com.google.android.material.textfield.TextInputEditText

interface TaskListener {
    interface Create{
        fun createTask(title : String, desc : String)
    }

    interface Update{
        fun updateTask(
            task: Task,
            title: String,
            desc: String
        )
    }

    interface  Delete{
        fun deleteTask(task : Task)
    }
}