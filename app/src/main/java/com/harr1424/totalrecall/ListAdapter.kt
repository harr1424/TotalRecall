package com.harr1424.totalrecall

import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*


class ListAdapter(private var list: MutableList<String>)
    : RecyclerView.Adapter<ListAdapter.ListViewHolder>(){

    inner class ListViewHolder(itemView : View)
        : RecyclerView.ViewHolder(itemView), View.OnLongClickListener {

        init {
            itemView.setOnLongClickListener(this)
        }

        override fun onLongClick(view: View?): Boolean {
            val dialogTitle = "Delete Task?"
            val positiveButtonTitle = "Yes"
            val negativeButtonTitle = "No"
            val builder = view?.let { AlertDialog.Builder(it.context) }
            val newItemEditText = EditText(view?.context)
            newItemEditText.inputType = InputType.TYPE_CLASS_TEXT
            if (builder != null) {
                builder.setTitle(dialogTitle)
            }
            if (builder != null) {
                builder.setPositiveButton(positiveButtonTitle) { dialog, id -> list.removeAt(itemView.tag as Int)
                    notifyDataSetChanged()
                }
            }
            if (builder != null) {
                builder.setNegativeButton(negativeButtonTitle){ dialog, id -> dialog.cancel()
                }
            }
            if (builder != null) {
                builder.create().show()
            }
            return true
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.apply {
            item_name.text = list[position]
            tag = position
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}