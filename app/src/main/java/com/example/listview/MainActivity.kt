package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SearchView
import com.example.listview.R.id.lView
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bengkel = arrayOf("honda, sidoarjo", "honda, surabaya", "yamaha, sidoarjo", "yamaha, surabaya", "mitsubishi, sidoarjo", "mitsubishi, surabaya", "ford, surabaya", "mustang, surabaya", "nasa, surabaya", "tesla, surabaya")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            bengkel)


        binding.lView.adapter = adapter

        binding.sView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.sView.clearFocus()
                if (bengkel.contains(query)){

                    adapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })

    }
}

//I dont know what am i doing
//help
