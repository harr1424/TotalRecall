package com.harr1424.totalrecall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list = mutableListOf<String>(
            "School", "Work", "Research", "App Dev"
        )

        val adapter = ListAdapter(list)
        list_view.adapter = adapter
        list_view.layoutManager = LinearLayoutManager(this)

        floatingActionButton.setOnClickListener{
             addListItem()
        }
    }

    // TODO: Add new item to list
    // TODO: Save list state somehow
    // TODO: Delete task using long click
    private fun addListItem() {
        val dialogTitle = "Add a New Task"
        val positiveButtonTitle = "Add"
        val builder = AlertDialog.Builder(this)
        val newItemEditText = EditText(this)
        newItemEditText.inputType = InputType.TYPE_CLASS_TEXT
        builder.setTitle(dialogTitle)
        builder.setView(newItemEditText)
        builder.setPositiveButton(positiveButtonTitle) {
            dialog, _ -> dialog.dismiss()
        }
        builder.create().show()
    }
}