package com.newshelter.langkah.ui.hospital

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.android.PolyUtil
import com.newshelter.langkah.databinding.ActivityLocationBinding
import com.newshelter.langkah.ui.hospital.modelroute.Route
import com.newshelter.langkah.utils.DataDummy
import kotlinx.android.synthetic.main.activity_location.*

class LocationActivity : AppCompatActivity(),OnMapReadyCallback {

    companion object{
        const val EXTRA_HOSPITAL_ID = "extra_hospital_id"
    }
    private lateinit var binding: ActivityLocationBinding
    private lateinit var map: GoogleMap
    private lateinit var viewModel: HospitalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
       viewModel = ViewModelProvider(this).get(HospitalViewModel::class.java)

        val mapFragment = maps_view as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    private fun drawPolyline(route: Route) {
        val shape = route.overview_polyline.points
        val polyline = PolylineOptions()
            .addAll(PolyUtil.decode(shape))
            .width(8f)
            .color(Color.RED)
        map.addPolyline(polyline)
    }

    private fun gotoLocation(){
        val hospitalDummy = DataDummy.generateDummyHospital()
        val nowLocate = LatLng(-6.194031, 106.832587)
        val extras = intent.extras
        for (hospital in hospitalDummy){
            if (hospital.hospitalId == extras?.getString(EXTRA_HOSPITAL_ID)) {
                val goalLocate = LatLng(hospital.lat,hospital.long)

                val markerNowLoc = MarkerOptions()
                    .position(nowLocate)
                    .title("current location")

                val markerGoalLoc = MarkerOptions()
                    .position(goalLocate)
                    .title(hospital.hospitalName)

                map.addMarker(markerNowLoc)
                map.addMarker(markerGoalLoc)
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(nowLocate,15f))


                viewModel.getDirection(
                    "${nowLocate.latitude},${nowLocate.longitude}",
                    "${hospital.lat},${hospital.long}"
                    )

                viewModel.getLiveDirection().observe(this,{route ->
                    for(way in route){
                        drawPolyline(way)
                    }
                })
            }
        }
    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0
        gotoLocation()
    }
}