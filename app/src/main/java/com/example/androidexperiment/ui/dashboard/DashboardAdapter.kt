package com.example.androidexperiment.ui.dashboard

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexperiment.R
import com.example.androidexperiment.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class DashboardAdapter(
    private var items : ArrayList<Task>,
    private val context : Context,
    private val listener: DashboardFragment
) : RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>(){

    class DashboardViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.tv_task_tittle
        val tvDescription: TextView = view.tv_task_desc
        val tvCreatedAt: TextView = view.tvCreatedAt
        val cvItemTask : CardView = view.cv_item_task
        val btDelete : ImageButton = view.bt_task_del
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return DashboardViewHolder(LayoutInflater.from(context).inflate(R.layout.item_task,parent,false))
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {

        holder.tvTitle.text = items[position].title
        //holder.tvCreatedAt.text = items[position].createdAt
        holder.tvDescription.text = items[position].description
        holder.cvItemTask.setOnClickListener{
            listener.showUpdateDialog(items[position])
        }
        holder.btDelete.setOnClickListener {
            listener.showDeleteDialog(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addTask(task : Task){
        items.add(0,task)

        if(itemCount <= 10){
            notifyDataSetChanged()
        }else{
            notifyItemInserted(0)
            notifyItemRangeChanged(0,itemCount)
        }
    }

    fun deleteTask(task : Task){
        val index = items.indexOf(task)

        items.removeAt(index)
        notifyItemRemoved(index)
        notifyItemRangeChanged(index, itemCount)
    }

    fun updateTask(task : Task, newTask : Task){
        val index = items.indexOf(task)
        items[index] = newTask
        notifyItemChanged(index)
    }

}