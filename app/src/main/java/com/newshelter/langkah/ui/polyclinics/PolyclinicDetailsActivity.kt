package com.newshelter.langkah.ui.polyclinics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.ActivityPolyclinicDetailsBinding
import com.newshelter.langkah.utils.DataDummy

class PolyclinicDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPolyclinicDetailsBinding

    companion object{
        const val EXTRA_ID = "extra_id"
        const val EXTRA_HOSPITAL_ID = "extra_hospital_id"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPolyclinicDetailsBinding.inflate(layoutInflater)


        setContentView(binding.root)

        val extras = intent.extras

        val dummy = DataDummy.generateDummyPolyclinics()

        val dummySch = DataDummy.generateDummyPolySchedule()

        val polyScheduleAdapter = polyScheduleAdapter()

        with(binding){
            for (poly in dummy){
                if (poly.polyId == extras?.getString(EXTRA_ID)){
                    tvPolyclinicsName.text = poly.polyName
                    tvDescription.text = poly.description
                }
            }

            with(rvSchedule){
                for (sch in dummySch){
                    if (sch.hospitalId == extras?.getString(EXTRA_HOSPITAL_ID) &&
                            sch.polyId == extras.getString(EXTRA_ID)){
                        polyScheduleAdapter.setSchedule(sch.dayHour)
                    }

                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = polyScheduleAdapter
                }
            }
        }
    }
}