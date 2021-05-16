package com.newshelter.langkah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentHospitalBinding

class HospitalFragment : Fragment() {

    private lateinit var binding : FragmentHospitalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHospitalBinding.inflate(layoutInflater)
        return binding.root
    }

}