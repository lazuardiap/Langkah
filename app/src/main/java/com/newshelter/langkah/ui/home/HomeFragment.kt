package com.newshelter.langkah.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentHomeBinding
import com.newshelter.langkah.ui.hospital.HospitalAdapter
import com.newshelter.langkah.ui.hospital.HospitalDetailFragment
import com.newshelter.langkah.utils.DataDummy


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){

            val hospitals = DataDummy.generateDummyHospital()

            val hospitalAdapter = HospitalAdapter()

            hospitalAdapter.setHospital(hospitals)

            with(binding.rvHospital){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = hospitalAdapter
            }


        }

    }


}