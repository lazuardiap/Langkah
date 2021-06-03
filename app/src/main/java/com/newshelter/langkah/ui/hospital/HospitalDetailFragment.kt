package com.newshelter.langkah.ui.hospital

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.tabs.TabLayoutMediator
import com.newshelter.langkah.BuildConfig
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentHospitalDetailBinding
import com.newshelter.langkah.ui.appointment.AppointmentActivity
import com.newshelter.langkah.ui.doctors.SmallDoctorsFragment
import com.newshelter.langkah.ui.polyclinics.SmallPolyclinicsFragment
import com.newshelter.langkah.ui.queue.QueueFragment
import com.newshelter.langkah.ui.room.RoomsFragment
import com.newshelter.langkah.ui.sectionpager.DetailSectionPagerAdapter
import com.newshelter.langkah.utils.DataDummy


class HospitalDetailFragment : Fragment() {

    companion object{
        const val EXTRA_HOSPITAL_ID = "extra_hospital_id"

        @StringRes
        private val TAB_TITLES = intArrayOf( R.string.doctor_section,R.string.poly_section)
    }


    private lateinit var binding : FragmentHospitalDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentHospitalDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (arguments != null){
            val hospitalId = arguments?.getString(EXTRA_HOSPITAL_ID)

            val hospitals = DataDummy.generateDummyHospital()

            for (hospital in hospitals){
                if (hospital.hospitalId == hospitalId){

                    with(binding){
                        tvHospitalName.text = hospital.hospitalName
                        tvDescription.text = hospital.description
                        tvAddress.text = hospital.address
                        val imageUrl ="https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=${hospital.photo}&key=${BuildConfig.KEY}"


                            Glide.with(this@HospitalDetailFragment)
                                .load(imageUrl)
                                .apply(RequestOptions())
                                .into(binding.ivHospital)


                        binding.btnCall.setOnClickListener {
                            val telephone = hospital.phoneNumber
                            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", telephone, null))
                            startActivity(intent)
                        }

                        val facAdapter = FacilitiesAdapter()
                        facAdapter.setFacility(hospital.facilities)

                        with(rvFacilities){
                            layoutManager = LinearLayoutManager(context)
                            setHasFixedSize(true)
                            adapter = facAdapter
                        }

                        val sectionAdapter = DetailSectionPagerAdapter(this@HospitalDetailFragment.context, activity as AppCompatActivity)

                        sectionAdapter.setData(hospital.hospitalId, hospital.doctors, hospital.polyclinics)

                        viewPager.adapter = sectionAdapter

                        TabLayoutMediator(tabs, viewPager){ tab, position ->
                            tab.text = resources.getString(TAB_TITLES[position])
                        }.attach()

                        btnRoom.setOnClickListener{
                            val fm = parentFragmentManager

                            val mRoomFragment = RoomsFragment()

                            val bundle = Bundle()

                            bundle.putString(RoomsFragment.EXTRA_ID, hospital.hospitalId)

                            mRoomFragment.arguments = bundle

                            fm.beginTransaction().apply {
                                replace(R.id.frame_container, mRoomFragment, RoomsFragment::class.java.simpleName)
                                addToBackStack(null)
                                commit()
                            }
                        }

                        btnMakeAppointment.setOnClickListener{
                            val i = Intent(context, AppointmentActivity::class.java)
                            i.putExtra(AppointmentActivity.EXTRA_HOSPITAL_ID, hospital.hospitalId)
                            startActivity(i)
                        }

                        btnLocate.setOnClickListener {
                            val i = Intent(context, LocationActivity::class.java)
                            i.putExtra(LocationActivity.EXTRA_HOSPITAL_ID, hospital.hospitalId)
                            startActivity(i)
                        }

                        btnSeeQueue.setOnClickListener {
                            val fm = parentFragmentManager

                            val mQueueFragment = QueueFragment()

                            val bundle = Bundle()

                            bundle.putString(QueueFragment.EXTRA_HOSPITAL_ID, hospital.hospitalId)

                            mQueueFragment.arguments = bundle

                            fm.beginTransaction().apply {
                                replace(R.id.frame_container, mQueueFragment, QueueFragment::class.java.simpleName)
                                addToBackStack(null)
                                commit()
                            }
                        }

                    }

                }
            }
        }
    }


}