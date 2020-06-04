package com.example.myapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _text = MutableLiveData<String>()

    val text = Transformations.map(_text) {
        it
    }

    fun loadTextContent() {
        _text.value = "Texto teste"
    }
}