package com.newshelter.langkah.ui.consultation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.ActivityConsultationBinding

class ConsultationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityConsultationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fm = supportFragmentManager
        val mFragmentConsultation = ConsultationFragment()
        val fragment = fm.findFragmentByTag(ConsultationFragment::class.java.simpleName)

        if (fragment !is ConsultationFragment){
            fm.beginTransaction()
                .add(R.id.frame_container, mFragmentConsultation, ConsultationFragment::class.java.simpleName)
                .commit()
        }
    }
}