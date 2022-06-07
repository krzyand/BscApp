package com.example.bscapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.bscapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var countReset: Int = 0
    private var countSave: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.greetingTextView.text = resources.getString(R.string.hello_unknown)

        binding.saveButton.setOnClickListener {
            showGreeting()
        }
        binding.resetButton.setOnClickListener {
            resetGreeting()
        }
    }
    private fun showGreeting() {
        binding.apply {
            if (nameEditText.text.toString().isNotEmpty()) {
                val greetingWithName = "Elo ${nameEditText.text}"

                greetingTextView.text = greetingWithName
                nameEditText.text.clear()
                countSave++
                saveCountTextView.text = countSave.toString()
            }
        }
    }
    private fun resetGreeting() {
        val defaultGreeting = resources.getString(R.string.hello_unknown)
        val currentGreeting = binding.greetingTextView.text
        binding.apply {
            if (currentGreeting != defaultGreeting ) {
                countReset++
                resetCountTextView.text = countReset.toString()
            }
            greetingTextView.text = defaultGreeting
        }

    }
}