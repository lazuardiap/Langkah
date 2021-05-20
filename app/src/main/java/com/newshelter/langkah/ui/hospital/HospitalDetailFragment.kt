package com.newshelter.langkah.ui.hospital

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentHospitalDetailBinding


class HospitalDetailFragment : Fragment() {

    companion object{
        const val EXTRA_HOSPITAL_ID = "extra_hospital_id"
    }

    private lateinit var binding : FragmentHospitalDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentHospitalDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}