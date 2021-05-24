package com.newshelter.langkah.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentMadeStatusBinding
import com.newshelter.langkah.utils.DataDummy


class MadeStatusFragment : Fragment() {

    private lateinit var binding : FragmentMadeStatusBinding

    companion object{
        const val EXTRA_USER_ID = "extra_id"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMadeStatusBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (arguments != null){

            val userId = arguments?.getString(EXTRA_USER_ID)

            val dummyHospitals = DataDummy.generateDummyHospital()

            val dummyDoctors = DataDummy.generateDummyDoctors()

            val dummyAppointment = DataDummy.generateDummyAppointment()

            with(binding){
                for (appointment in dummyAppointment){
                    if (appointment.userId == userId){

                        tvAppointmentDate.text = appointment.appointmentDate
                        tvAppointmentTime.text = appointment.appointmentTime

                        for (doctors in dummyDoctors){
                            if (doctors.doctorId == appointment.doctorId){

                                tvDoctorName.text = doctors.doctorName
                                tvItemSpecialist.text = doctors.doctorSpecialist

                            }
                        }

                        for (hospital in dummyHospitals){
                            if(hospital.hospitalId == appointment.hospitalId){

                                tvHospitalName.text = hospital.hospitalName
                                tvItemAddress.text = hospital.address

                            }
                        }

                    }
                }
            }

        }
    }


}