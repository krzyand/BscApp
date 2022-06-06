package com.example.bscapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //  private lateinit var editTextName2: EditText
    private lateinit var greeting: TextView
    private lateinit var editName: EditText
    private lateinit var countResetTV: TextView
    private lateinit var countSaveTV: TextView

    private var countReset: Int = 0
    private var countSave: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greeting = findViewById<TextView>(R.id.greetingTextView)
        greeting.text = resources.getString(R.string.hello_unknown)
        editName = findViewById<EditText>(R.id.nameEditText)

        countResetTV = findViewById<TextView>(R.id.resetCountTextView)
        countSaveTV = findViewById<TextView>(R.id.saveCountTextView)

        val saveButton = findViewById<Button>(R.id.saveButton)
        val resetButton = findViewById<Button>(R.id.resetButton)


        saveButton.setOnClickListener {
            showGreeting()
        }
        resetButton.setOnClickListener {
            resetGreeting()
        }
    }
    private fun showGreeting() {
        if (editName.text.toString().isNotEmpty()) {
            val greetingWithName = "Elo ${editName.text}"

            greeting.text = greetingWithName
            editName.text.clear()
            countSave++
            countSaveTV.text = countSave.toString()
        }
    }
    private fun resetGreeting() {
        val defaultGreeting = resources.getString(R.string.hello_unknown)
        val currentGreeting = greeting.text
        if (currentGreeting != defaultGreeting ) {
            countReset++
            countResetTV.text = countReset.toString()
        }
        greeting.text = defaultGreeting
    }
}