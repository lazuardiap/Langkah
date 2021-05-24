package com.newshelter.langkah.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChangePasswordBinding

    companion object{
        const val EXTRA_USER_ID = "extra_user_id"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}