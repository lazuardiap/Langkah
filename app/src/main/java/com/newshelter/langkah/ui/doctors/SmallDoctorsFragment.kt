package com.newshelter.langkah.ui.doctors

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.newshelter.langkah.R
import com.newshelter.langkah.data.DoctorsEntity
import com.newshelter.langkah.databinding.FragmentSmallDoctorsBinding
import com.newshelter.langkah.utils.DataDummy


class SmallDoctorsFragment : Fragment() {

    private lateinit var binding : FragmentSmallDoctorsBinding

    companion object{
        const val EXTRA_ID = "extra_id"
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentSmallDoctorsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val smallDoctorAdapter = SmallDoctorAdapter()

        val dummy = DataDummy.generateDummyHospital()

        val dummyDocs = DataDummy.generateDummyDoctors()

        if(arguments != null){
            val id = arguments?.getString(EXTRA_ID)

            for (hospital in dummy){
                if (hospital.hospitalId == id){
                    smallDoctorAdapter.setDoctor(hospital.doctors)
                }
            }
        }

//        smallDoctorAdapter.setDoctor(dummyDocs)

        with(binding.rvDoctors){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = smallDoctorAdapter
        }
    }



}