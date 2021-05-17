package com.newshelter.langkah

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.newshelter.langkah.databinding.FragmentHomeBinding


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

            val fm = fragmentManager
            val mHospitalFragment = HospitalFragment()
            fm?.beginTransaction()
                    ?.add(R.id.nearest_hospital_container, mHospitalFragment, HospitalFragment::class.java.simpleName)
                    ?.commit()

        }
    }

}