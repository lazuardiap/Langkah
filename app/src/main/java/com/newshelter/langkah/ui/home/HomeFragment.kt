package com.newshelter.langkah.ui.home

import android.content.Intent
import android.location.Geocoder
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.auth.FirebaseAuth
import com.newshelter.langkah.databinding.FragmentHomeBinding
import com.newshelter.langkah.ui.hospital.HospitalAdapter
import com.newshelter.langkah.utils.DataDummy
import java.util.*


class HomeFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding : FragmentHomeBinding
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        auth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext())

        if (activity != null) {

            val hospitals = DataDummy.generateDummyHospital()
            val hospitalAdapter = HospitalAdapter()

            binding.helloText.text = "hello, ${auth.currentUser?.displayName}"
            binding.tvCurrentPlace.text = getCityName(-6.194031, 106.832587)

            binding.btnRefresh.setOnClickListener {
                when (it.callOnClick()){
                    true -> TODO()
                    false -> TODO()
                }
            }




            binding.btnCall.setOnClickListener {
                val telephone = hospitals[0].phoneNumber
                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", telephone, null))
                startActivity(intent)
            }

   //         homeViewModel.getListMaps(requireContext())
     //       homeViewModel.getLiveResult().observe(viewLifecycleOwner,{obsr ->
         ///       hospitalAdapter.setHospital(obsr)

//                Log.d(context.toString(),obsr[0].toString())
            //    Log.d(obsr[0].photos[0].photo_reference,"cekk")
      //          hospitalAdapter.notifyDataSetChanged()
      //      })
       //     with(binding.rvHospital){

        //        layoutManager = LinearLayoutManager(context)
         //       setHasFixedSize(true)
        //        adapter = hospitalAdapter
         //   }




           hospitalAdapter.setHospital(hospitals)

            with(binding.rvHospital) {
            layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = hospitalAdapter
            }
        }
    }
    private fun getCityName(lat: Double, long: Double):String{
        //-6.194031, 106.832587
        val geoCoder = Geocoder(activity, Locale.getDefault())
        val address = geoCoder.getFromLocation(lat,long,3)
        val cityName = address[0].locality.toString()
        val countryName = address[0].countryName.toString()
        return "$cityName, $countryName"
    }
}


