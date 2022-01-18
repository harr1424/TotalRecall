package com.harr1424.totalrecall

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.InputType
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    var list = mutableListOf<String>()
    lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "OnCreate() called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Restore list from shared preferences
        prefs = this.getPreferences(Context.MODE_PRIVATE)
        list = prefs.getStringSet("TASK_LIST", null)?.toMutableList() ?: mutableListOf<String>()

        val adapter = ListAdapter(list)
        list_view.adapter = adapter
        list_view.layoutManager = LinearLayoutManager(this)

        floatingActionButton.setOnClickListener{
             addListItem()
        }
    }

    // Save the list to shared preferences
    // TODO not persistent
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        Log.d(TAG, "onSavedInstanceState() called")
        super.onSaveInstanceState(outState, outPersistentState)
        val set = HashSet<String>()
        set.addAll(list)
        val editor = prefs.edit()
        editor.putStringSet("TASK_LIST", set)
        editor.commit()
    }


    // TODO: Delete task using long click


    private fun addListItem() {
        Log.d(TAG, "addListItem() called")
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

    override fun onStart() {
        Log.d(TAG, "onStart() called")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume() called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause() called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStopo() called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart() called")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy() called")
        super.onDestroy()
    }
}