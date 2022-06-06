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
        if (binding.nameEditText.text.toString().isNotEmpty()) {
            val greetingWithName = "Elo ${binding.nameEditText.text}"

            binding.greetingTextView.text = greetingWithName
            binding.nameEditText.text.clear()
            countSave++
            binding.saveCountTextView.text = countSave.toString()
        }
    }
    private fun resetGreeting() {
        val defaultGreeting = resources.getString(R.string.hello_unknown)
        val currentGreeting = binding.greetingTextView.text
        if (currentGreeting != defaultGreeting ) {
            countReset++
            binding.resetCountTextView.text = countReset.toString()
        }
        binding.greetingTextView.text = defaultGreeting
    }
}