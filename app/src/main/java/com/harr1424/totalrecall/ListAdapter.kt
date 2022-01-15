package com.harr1424.totalrecall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*


class ListAdapter(private var list: List<String>)
    : RecyclerView.Adapter<ListAdapter.ListViewHolder>(){

    inner class ListViewHolder(itemView : View)
        : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.apply {
            item_name.text = list[position]
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }
}