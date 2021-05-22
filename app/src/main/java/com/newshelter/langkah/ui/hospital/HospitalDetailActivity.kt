package com.newshelter.langkah.ui.hospital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.ActivityHospitalDetailBinding

class HospitalDetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding : ActivityHospitalDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mFragmentManager = supportFragmentManager
        val mFragmentHospitalDetail = HospitalDetailFragment()

        val mBundle = Bundle()

        val extras = intent.extras

        mBundle.putString(HospitalDetailFragment.EXTRA_HOSPITAL_ID, extras?.getString(EXTRA_ID) )

        mFragmentHospitalDetail.arguments = mBundle

        val fragment = mFragmentManager.findFragmentByTag(HospitalDetailFragment::class.java.simpleName)

        if (fragment !is HospitalDetailFragment){
            mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, mFragmentHospitalDetail, HospitalDetailFragment::class.java.simpleName)
                    .commit()
        }
    }
}