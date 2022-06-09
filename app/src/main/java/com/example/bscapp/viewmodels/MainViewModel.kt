package com.example.bscapp.viewmodels

import androidx.lifecycle.ViewModel

class MainViewModel(resetCounter: Int, saveCounter: Int) : ViewModel() {

    private var resetCounter = 0
    private var saveCounter = 0

    init {
        this.resetCounter = resetCounter
        this.saveCounter =  saveCounter
    }

    fun setSaveCounter() = ++saveCounter
    fun setResetCounter() = ++resetCounter

    fun getResetCounter(): Int {
        return resetCounter
    }
    fun getSaveCounter(): Int {
        return saveCounter
    }
}