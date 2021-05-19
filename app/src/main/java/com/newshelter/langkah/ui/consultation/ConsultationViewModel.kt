package com.newshelter.langkah.ui.consultation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConsultationViewModel : ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Consultation"
    }
    val text: LiveData<String> = _text
}