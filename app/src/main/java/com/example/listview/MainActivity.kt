package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.listview.R.id.listView

class MainActivity : AppCompatActivity() {
    private  var listItems = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val editText = findViewById<EditText>(R.id.editText)
            val text = editText.text.toString()
            if(text.isNotEmpty()) {
                listItems.add(text)
                adapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }
    }
}