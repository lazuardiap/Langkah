package com.newshelter.langkah.ui.polyclinics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentSmallPolyclinicsBinding
import com.newshelter.langkah.utils.DataDummy


class SmallPolyclinicsFragment : Fragment() {

    private lateinit var binding : FragmentSmallPolyclinicsBinding

    companion object{
        const val EXTRA_ID = "extra_id"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSmallPolyclinicsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val smallPolyAdapter = SmallPolyAdapter()
        val dummy = DataDummy.generateDummyHospital()

        if(arguments != null){
            val id = arguments?.getString(EXTRA_ID)

            for (hospital in dummy){
                if (hospital.hospitalId == id){
                    smallPolyAdapter.setPoly(hospital.polyclinics)
                }
            }
        }

        with(binding.rvPoly){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = smallPolyAdapter
        }
    }


}