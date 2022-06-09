package com.example.bscapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory (
    private val resetCounter: Int,
    private val saveCounter: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(resetCounter, saveCounter) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}