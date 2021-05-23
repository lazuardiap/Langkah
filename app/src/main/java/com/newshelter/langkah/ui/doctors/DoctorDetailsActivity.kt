package com.newshelter.langkah.ui.doctors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.newshelter.langkah.R
import com.newshelter.langkah.data.ScheduleEntity
import com.newshelter.langkah.databinding.ActivityDoctorDetailsBinding
import com.newshelter.langkah.utils.DataDummy

class DoctorDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDoctorDetailsBinding

    companion object{
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras

        val dummy = DataDummy.generateDummyDoctors()

        val dummySch = DataDummy.generateDummySchedule()

        val doctorSch = ArrayList<ScheduleEntity>()

        val hospitalScheduleAdapter = DoctorHospitalScheduleAdapter()


        with(binding){
            for (doctor in dummy){
                if (doctor.doctorId == extras?.getString(EXTRA_ID)){
                    tvDoctorName.text = doctor.doctorName
                    tvDoctorSpecialist.text = doctor.doctorSpecialist
                    tvProfile.text = doctor.doctorProfile
                }
            }

            with(rvSchedule){
                for (sch in dummySch){
                    if (sch.doctorId == extras?.getString(EXTRA_ID)){
                        doctorSch.add(sch)
                    }

                    hospitalScheduleAdapter.setSchedule(doctorSch)
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = hospitalScheduleAdapter
                }
            }
        }

    }
}