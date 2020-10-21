package com.example.androidexperiment.ui.dashboard.dialog

interface TaskListener {
    interface Create{
        fun createTask(title : String, desc : String)
    }

    interface Update{
        fun updateTask()
    }

    interface  Delete{
        fun DeleteTask()
    }
}