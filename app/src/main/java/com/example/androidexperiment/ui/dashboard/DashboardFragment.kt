package com.example.androidexperiment.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexperiment.R
import com.example.androidexperiment.base.BaseFragment
import com.example.androidexperiment.model.Task
import com.example.androidexperiment.ui.dashboard.dialog.CreateTask
import com.example.androidexperiment.ui.dashboard.dialog.TaskListener
import com.example.androidexperiment.ui.dashboard.dialog.UpdateTask
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DashboardFragment : BaseFragment(), DashboardContract.View , TaskListener.Create, TaskListener.Update, TaskListener.Delete{

    private var mPresenter : DashboardContract.Presenter? = null
    private lateinit var mView : View
    private lateinit var mAdapter: DashboardAdapter
    private lateinit var rvTaksList : RecyclerView
    private lateinit var fabAddTask : FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mView = inflater.inflate(R.layout.fragment_dashboard,container,false)
        mAdapter = DashboardAdapter(arrayListOf(), activity as Context)
        mPresenter = DashboardPresenter(this)
        rvTaksList = mView.findViewById<RecyclerView>(R.id.rv_task_list)
        fabAddTask = mView.findViewById<FloatingActionButton>(R.id.fab_add_task)
        fabAddTask.setOnClickListener{
            showTaskDialog()
        }

        rvTaksList.adapter = mAdapter
        rvTaksList.layoutManager = LinearLayoutManager(getActivity())

        return mView
    }

    override fun addTask(task: Task) {
        mAdapter.addTask(task)
    }

    override fun attachPresenter(presenter: DashboardContract.Presenter) {
        mPresenter = presenter
    }

    override fun detachPresenter() {
        mPresenter?.onDestroy()
        mPresenter = null
    }

    private fun showTaskDialog() {
        val dialog = CreateTask()
//        dialog.addListener(this)
        dialog.show(requireActivity().supportFragmentManager , dialog.TAG)

    }

    private fun showUpdateDialog(){
        val dialog = UpdateTask()
//        dialog.ad
    }

    private fun showDeleteDialog(){
        val dialog = DeleteTask()
    }

    override fun createTask(title: String, desc: String) {
        mPresenter?.createTask(title,desc)
    }

    override fun updateTask() {
        mPresenter?.updateTask()
    }

    override fun DeleteTask() {
        mPresenter?.deleteTask()
    }
}