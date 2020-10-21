package com.example.androidexperiment.ui.dashboard

import com.example.androidexperiment.model.Task
import java.util.*

class DashboardPresenter(private var mView : DashboardFragment?) : DashboardContract.Presenter{
    override fun createTask(title: String, desc: String) {
        val task = Task(title,desc, Date().toString())
        mView?.addTask(task)
    }

    override fun updateTask() {
        TODO("Not yet implemented")
    }

    override fun deleteTask() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        mView = null
    }
}