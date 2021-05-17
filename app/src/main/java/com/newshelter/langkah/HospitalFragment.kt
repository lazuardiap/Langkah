package com.newshelter.langkah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentHospitalBinding
import com.newshelter.langkah.utils.DataDummy

class HospitalFragment : Fragment() {

    private lateinit var binding : FragmentHospitalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHospitalBinding.inflate(layoutInflater, container, false)
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