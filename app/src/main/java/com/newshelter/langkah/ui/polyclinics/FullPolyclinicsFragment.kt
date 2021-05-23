package com.newshelter.langkah.ui.polyclinics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentFullPolyclinicsBinding
import com.newshelter.langkah.utils.DataDummy


class FullPolyclinicsFragment : Fragment() {

    private lateinit var binding : FragmentFullPolyclinicsBinding

    companion object{
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFullPolyclinicsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val fullPolyAdapter = FullPolyAdapter()
        val dummy = DataDummy.generateDummyHospital()

        if (arguments != null){
            val id = arguments?.getString(SmallPolyclinicsFragment.EXTRA_ID)

            for (hospital in dummy){
                if (hospital.hospitalId == id){
                    fullPolyAdapter.setPoly(hospital.polyclinics, hospital.hospitalId)
                }
            }
        }

        with(binding.rvPoly){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = fullPolyAdapter
        }

        binding.btnBack.setOnClickListener{
            val mFragmentManager = parentFragmentManager
            mFragmentManager.popBackStack()
        }

        Glide.with(requireActivity())
            .load(R.drawable.polyclinics)
            .into(binding.polysImg)
    }

}