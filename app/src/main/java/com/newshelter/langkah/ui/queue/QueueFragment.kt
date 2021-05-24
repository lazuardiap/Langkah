package com.newshelter.langkah.ui.queue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentQueueBinding
import com.newshelter.langkah.ui.doctors.FullDoctorFragment
import com.newshelter.langkah.utils.DataDummy


class QueueFragment : Fragment() {

    private lateinit var binding : FragmentQueueBinding

    companion object{
        const val EXTRA_HOSPITAL_ID = "extra_hospital_id"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentQueueBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val queuePolyAdapter = QueuePolyAdapter()

        val dummy = DataDummy.generateDummyHospital()

        val polyIdList = ArrayList<String>()

        if (arguments != null){
            val id = arguments?.getString(EXTRA_HOSPITAL_ID)

            for (hospital in dummy){
                if(hospital.hospitalId == id){
                    for (poly in hospital.polyclinics){
                        polyIdList.add(poly.polyId)
                    }

                    queuePolyAdapter.setPolyId(polyIdList)
                }
            }
        }

        with(binding){

            with(rvPoly){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = queuePolyAdapter
            }
        }
    }


}