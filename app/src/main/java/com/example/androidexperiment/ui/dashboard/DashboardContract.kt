package com.example.androidexperiment.ui.dashboard

import com.example.androidexperiment.base.BasePresenter
import com.example.androidexperiment.base.BaseView
import com.example.androidexperiment.model.Task
import java.util.*

interface DashboardContract {
    interface Presenter : BasePresenter{
        fun createTask(title: String, desc: String): Task
    }

    interface View : BaseView<Presenter>{

    }
}