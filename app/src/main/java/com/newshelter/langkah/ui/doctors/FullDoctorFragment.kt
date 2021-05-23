package com.newshelter.langkah.ui.doctors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentFullDoctorBinding
import com.newshelter.langkah.utils.DataDummy


class FullDoctorFragment : Fragment() {

    private lateinit var binding : FragmentFullDoctorBinding

    companion object{
        const val EXTRA_ID = "extra_id"
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentFullDoctorBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val fullDoctorAdapter = FullDoctorAdapter()

        val dummy = DataDummy.generateDummyHospital()

        if (arguments != null){
            val id = arguments?.getString(EXTRA_ID)

            for (hospital in dummy){
                if (hospital.hospitalId == id)
                    fullDoctorAdapter.setDoctor(hospital.doctors)
                binding.tvHospitalName.text = hospital.hospitalName
            }
        }

        with(binding){
            Glide.with(requireActivity())
                .load(R.drawable.doctors)
                .into(doctorsImg)



            btnBack.setOnClickListener{
                val mFragmentManager = parentFragmentManager
                mFragmentManager.popBackStack()
            }

            with(rvDoctors){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = fullDoctorAdapter
            }
        }
    }

}