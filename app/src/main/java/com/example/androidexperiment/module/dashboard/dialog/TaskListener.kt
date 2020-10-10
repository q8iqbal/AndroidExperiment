package com.example.androidexperiment.module.dashboard.dialog

interface TaskListener {
    interface Create{
        fun createTask(title : String, desc : String)
    }
}