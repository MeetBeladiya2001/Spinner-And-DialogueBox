package com.example.crudapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.crudapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = listOf<String>("Banana","Mango","Apple","Grasp","Gwawa")
        val ArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,list)
        ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        this.binding.spinner.adapter = ArrayAdapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity,"You Have Selected $selectedItem",Toast.LENGTH_SHORT).show()
                Toast.makeText(this@MainActivity,"You Have Selected $selectedItem",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.button.setOnClickListener {
            dialogue()
        }
    }

    // create dialogue box
    private fun dialogue () {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Dialogue Box")
            .setMessage("Do You Want To Close This DialogueBox")
            .setPositiveButton("Yes") {dialogue, which ->
                dialogue.dismiss()
            }
            .setNegativeButton("No") {dialogue, which ->
                dialogue()
                Toast.makeText(this,"Please Close This DialogueBox",Toast.LENGTH_SHORT).show()
            }
        val createDialogue = builder.create()
        createDialogue.show()
    }
}