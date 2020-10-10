package com.example.androidexperiment.module.dashboard

import com.example.androidexperiment.base.BasePresenter
import com.example.androidexperiment.base.BaseView
import com.example.androidexperiment.model.Task

interface DashboardContract{
    interface Presenter : BasePresenter{
        fun createTask(title: String, desc: String)
    }

    interface View : BaseView<Presenter>{
        fun addTask(task: Task)
    }
}