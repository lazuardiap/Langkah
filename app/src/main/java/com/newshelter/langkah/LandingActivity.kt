package com.newshelter.langkah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.newshelter.langkah.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mFragmentManager = supportFragmentManager
        val mFragmentLanding = FragmentLanding()
        val fragment = mFragmentManager.findFragmentByTag(FragmentLanding::class.java.simpleName)

        if (fragment !is FragmentLanding){
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mFragmentLanding, FragmentLanding::class.java.simpleName)
                .commit()
        }

    }
}