package com.example.androidexperiment.module.dashboard

import com.example.androidexperiment.model.Task
import java.time.LocalDateTime
import java.util.*

class DashboardPresenter(private var mView : DashboardFragment?) : DashboardContract.Presenter{
    override fun createTask(title: String, desc: String) {
        val task = Task(title,desc, Date().toString())
        mView?.addTask(task)
    }

    override fun onDestroy() {
        mView = null
    }
}