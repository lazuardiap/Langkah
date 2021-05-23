package com.newshelter.langkah.ui.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.ActivityRoomDetailBinding
import com.newshelter.langkah.utils.DataDummy

class RoomDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRoomDetailBinding

    companion object{
        const val EXTRA_HOSPITAL_ID = "extra_hospital_id"
        const val EXTRA_ROOM_ID = "extra_room_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRoomDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val extras = intent.extras

        val dummyHospital = DataDummy.generateDummyHospital()

        val dummyRoom = DataDummy.generateDummyRoom()

        if (extras != null){
            with(binding){

                for (room in dummyRoom){
                    if (room.roomId == extras.getString(EXTRA_ROOM_ID)){
                        tvRoomType.text = room.roomType
                        tvPricePerDay.text = room.pricePerDay
                        tvDp.text = room.downPayment
                        tvServicesPrice.text = room.servicesPrice
                        tvPreinspectPrice.text = room.preInspectionPrice
                    }
                }

                for (hospital in dummyHospital){
                    if (hospital.hospitalId == extras.getString(EXTRA_HOSPITAL_ID)){
                        tvHospitalName.text = hospital.hospitalName
                    }
                }
            }
        }
    }
}