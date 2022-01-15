package com.harr1424.totalrecall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.add("School")
        list.add("Work")

        val adapter = ListAdapter(list)
        list_view.adapter = adapter
        list_view.layoutManager = LinearLayoutManager(this)

        floatingActionButton.setOnClickListener{
             addListItem()
        }
    }

    // TODO: Save list state using SavedInstanceState
    // TODO: Delete task using long click
    private fun addListItem() {
        val dialogTitle = "Add a New Task"
        val positiveButtonTitle = "Add"
        val negativeButtonTitle = "Cancel"
        val builder = AlertDialog.Builder(this)
        val newItemEditText = EditText(this)
        newItemEditText.inputType = InputType.TYPE_CLASS_TEXT
        builder.setTitle(dialogTitle)
        builder.setView(newItemEditText)
        builder.setPositiveButton(positiveButtonTitle) {
            dialog, id -> list.add(newItemEditText.text.toString())
        }
        builder.setNegativeButton(negativeButtonTitle){
            dialog, id -> dialog.cancel()
        }
        builder.create().show()
    }
}