package com.newshelter.langkah.ui.hospital

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentHospitalBinding
import com.newshelter.langkah.utils.DataDummy

class HospitalFragment : Fragment() {

    private lateinit var binding : FragmentHospitalBinding
    private lateinit var hospitalViewModel: HospitalViewModel

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
            hospitalViewModel = HospitalViewModel()
//            hospitalViewModel.text.observe(viewLifecycleOwner, Observer {
//                binding.textDashboard.text = it
//            })

            val hospitals = DataDummy.generateDummyHospital()
            val hospitalAdapter = HospitalFullAdapter()

            hospitalAdapter.setFullHospital(hospitals)

            with(binding){
                Glide.with(requireActivity())
                        .load(R.drawable.hospital)
                        .into(hospitalImg)

                with(rvHospital){
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = hospitalAdapter
                    
                }
            }

        }
    }

}