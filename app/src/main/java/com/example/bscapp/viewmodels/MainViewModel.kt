package com.example.bscapp.viewmodels

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var countReset: Int = 0
    private var countSave: Int = 0

    fun getUpdatedSave(): Int {
        return ++countSave
    }
    fun getUpdatedReset(): Int {
        return ++countReset
    }

    fun getCountReset(): Int {
        return countReset
    }
    fun getCountSave(): Int {
        return countSave
    }
}