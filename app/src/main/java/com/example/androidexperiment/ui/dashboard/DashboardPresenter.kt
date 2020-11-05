package com.example.androidexperiment.ui.dashboard

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.androidexperiment.model.Task
import java.time.LocalDateTime


class DashboardPresenter(private var mView : DashboardFragment?): DashboardContract.Presenter {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun createTask(title: String, desc: String): Task {
        val task = Task(title,desc, LocalDateTime.now().toString())
        return task
    }

    override fun onDestroy() {
        mView = null
    }
}