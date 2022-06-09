package com.example.bscapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.bscapp.databinding.ActivityMainBinding
import com.example.bscapp.viewmodels.MainViewModel
import com.example.bscapp.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainViewModelFactory(100, 100)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.greetingTextView.text = resources.getString(R.string.hello_unknown)
        binding.saveCountTextView.text = viewModel.getSaveCounter().toString()
        binding.resetCountTextView.text = viewModel.getResetCounter().toString()

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
                viewModel.setSaveCounter()
                saveCountTextView.text = viewModel.getSaveCounter().toString()
            }
        }
    }
    private fun resetGreeting() {
        val defaultGreeting = resources.getString(R.string.hello_unknown)
        val currentGreeting = binding.greetingTextView.text
        binding.apply {
            if (currentGreeting != defaultGreeting ) {
                viewModel.setResetCounter()
                resetCountTextView.text = viewModel.getResetCounter().toString()
            }
            greetingTextView.text = defaultGreeting
        }

    }
}