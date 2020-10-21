package com.example.androidexperiment.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexperiment.R
import com.example.androidexperiment.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class DashboardAdapter(
    private var items : ArrayList<Task>,
    private val context : Context,
) : RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>(){

    class DashboardViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.tv_task_tittle
        val tvDescription: TextView = view.tv_task_desc
        val tvCreatedAt: TextView = view.tvCreatedAt
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return DashboardViewHolder(LayoutInflater.from(context).inflate(R.layout.item_task,parent,false))
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {

        holder.tvTitle.text = items[position].title
        //holder.tvCreatedAt.text = items[position].createdAt
        holder.tvDescription.text = items[position].description
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

}