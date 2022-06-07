package com.example.bscapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.bscapp.databinding.ActivityMainBinding
import com.example.bscapp.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.greetingTextView.text = resources.getString(R.string.hello_unknown)
        binding.saveCountTextView.text = viewModel.getCountSave().toString()
        binding.resetCountTextView.text = viewModel.getCountReset().toString()

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
                saveCountTextView.text = viewModel.getUpdatedSave().toString()
            }
        }
    }
    private fun resetGreeting() {
        val defaultGreeting = resources.getString(R.string.hello_unknown)
        val currentGreeting = binding.greetingTextView.text
        binding.apply {
            if (currentGreeting != defaultGreeting ) {
                resetCountTextView.text = viewModel.getUpdatedReset().toString()
            }
            greetingTextView.text = defaultGreeting
        }

    }
}