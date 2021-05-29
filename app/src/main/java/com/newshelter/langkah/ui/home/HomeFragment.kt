package com.newshelter.langkah.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.*
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
    private lateinit var locationRequest: LocationRequest
    private var hospitalAdapter = HospitalAdapter()
    companion object{
       const val PERMISSION_ID = 1010
    }

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

            binding.helloText.text = "hello, ${auth.currentUser?.displayName}"


           // val hospitals = DataDummy.generateDummyHospital()

           // val hospitalAdapter = HospitalAdapter()

            //hospitalAdapter.setHospital(hospitals)
            requestPermission()
            getLastLocation()
            with(binding.rvHospital) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = hospitalAdapter
            }

           // with(binding.rvHospital) {
           //     layoutManager = LinearLayoutManager(context)
           //     setHasFixedSize(true)
          //      adapter = hospitalAdapter
         //  }
            binding.btnRefresh.setOnClickListener {
                requestPermission()
                getLastLocation()
            }
        }
    }

    private fun getCityName(lat: Double, long: Double):String{
        val geoCoder = Geocoder(activity, Locale.getDefault())
        val address = geoCoder.getFromLocation(lat,long,3)
        val cityName = address[0].locality.toString()
        val countryName = address[0].countryName.toString()
        return "$cityName, $countryName"
    }

    private fun requestPermission(){
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_ID
        )
    }

    private fun isLocationEnabled():Boolean{
        val locationManager:LocationManager = activity?.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun checkPermission():Boolean{
        if(
            ActivityCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        ){
            return true
        }
        return false
    }

    private fun getLastLocation(){
        if(checkPermission()){
            if(isLocationEnabled()){
                fusedLocationProviderClient.lastLocation.addOnCompleteListener {task->
                    val location:Location? = task.result
                    if(location == null){
                        newLocationData()
                    }else{
                        binding.tvCurrentPlace.text = getCityName(location.latitude,location.longitude)
                    }
                }
            }else{
                Toast.makeText(context,"Please Turn on Your device Location",Toast.LENGTH_SHORT).show()
            }
        }else{
            requestPermission()
        }
    }

    private fun newLocationData(){
        locationRequest =  LocationRequest.create()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 0
        locationRequest.fastestInterval = 0
        locationRequest.numUpdates = 1
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        checkPermission()
        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,locationCallback, Looper.myLooper()!!
        )
    }


    private val locationCallback = object : LocationCallback(){
        override fun onLocationResult(locationResult: LocationResult) {
            val lastLocation: Location = locationResult.lastLocation
            Log.d("Debug:","your last last location: "+ lastLocation.longitude.toString())
            val latLong = "${lastLocation.latitude},${lastLocation.longitude}"
            homeViewModel.getListMaps(requireContext(),latLong)
            homeViewModel.getHospital().observe(viewLifecycleOwner,{healthy ->
                if(healthy != null){
                    hospitalAdapter.setHospital(healthy[0].results)
                    requestPermission()
                    getLastLocation()
                }
            })
        }
    }

}


