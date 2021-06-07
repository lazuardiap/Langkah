package com.newshelter.langkah.ui.consultation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.newshelter.langkah.utils.DataDummy

class ConsultationViewModel : ViewModel(){

    private var questions = ArrayList<String>()

    fun getQuestions() : List<String>{

        return DataDummy.generateDummyQuestions()
    }


}