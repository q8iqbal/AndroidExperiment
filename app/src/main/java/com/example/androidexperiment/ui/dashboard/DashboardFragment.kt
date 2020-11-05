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
import com.example.androidexperiment.ui.dashboard.dialog.DeleteTask
import com.example.androidexperiment.ui.dashboard.dialog.TaskListener
import com.example.androidexperiment.ui.dashboard.dialog.UpdateTask
import com.example.androidexperiment.util.DashboardAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class DashboardFragment : BaseFragment<DashboardContract.Presenter>() , TaskListener.Create, TaskListener.Update, TaskListener.Delete, DashboardContract.View{

    private lateinit var mAdapter: DashboardAdapter
    private lateinit var rvTaksList : RecyclerView
    private lateinit var fabAddTask : FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val mView = inflater.inflate(R.layout.fragment_dashboard,container,false)
        attachPresenter(DashboardPresenter(this))
        mAdapter = DashboardAdapter(arrayListOf(), getActivity() as Context, this)
        rvTaksList = mView.findViewById<RecyclerView>(R.id.rv_task_list)
        fabAddTask = mView.findViewById<FloatingActionButton>(R.id.fab_add_task)
        fabAddTask.setOnClickListener{
            showTaskDialog()
        }

        rvTaksList.adapter = mAdapter
        rvTaksList.layoutManager = LinearLayoutManager(getActivity())

        return mView
    }

    private fun showTaskDialog() {
        val dialog = CreateTask()
        dialog.addListener(this)
        dialog.show(requireActivity().supportFragmentManager , dialog.TAG)

    }

    fun showUpdateDialog(task: Task) {
        val dialog = UpdateTask(task)
        dialog.addListener(this)
        dialog.show(requireActivity().supportFragmentManager, dialog.TAG)
    }

    fun showDeleteDialog(task: Task) {
        val dialog = DeleteTask(task)
        dialog.addListener(this)
        dialog.show(requireActivity().supportFragmentManager, dialog.TAG)
    }

    //comunicate with presenter
    //plz jangan buat model object ndek sini
    //tehee
    override fun createTask(title: String, desc: String) {
        val task = mPresenter?.createTask(title,desc)
        if (task != null) {
            mAdapter.addTask(task)
        }
    }

    override fun updateTask(
        task: Task,
        title: String,
        desc: String
    ) {
        val newTask = mPresenter?.createTask(title,desc)
        if (newTask != null) {
            mAdapter.updateTask(task , newTask)
        }
    }

    override fun deleteTask(task : Task) {
        mAdapter.deleteTask(task)
    }

    //override preseter contract
    override fun attachPresenter(presenter: DashboardContract.Presenter) {
        mPresenter = presenter
    }

    override fun detachPresenter() {
        mPresenter?.onDestroy()
        mPresenter = null
    }
}