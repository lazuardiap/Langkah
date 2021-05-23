package com.newshelter.langkah.ui.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.newshelter.langkah.R
import com.newshelter.langkah.databinding.FragmentRoomsBinding
import com.newshelter.langkah.utils.DataDummy


class RoomsFragment : Fragment() {

    private lateinit var binding : FragmentRoomsBinding

    companion object{
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRoomsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val roomAdapter = RoomAdapter()

        val dummy = DataDummy.generateDummyHospital()

        if (arguments != null){
            val id = arguments?.getString(EXTRA_ID)

            for (hospital in dummy){
                if (hospital.hospitalId == id){
                    roomAdapter.setRoom(hospital.rooms)
                    binding.tvHospitalName.text = hospital.hospitalName
                }
            }
        }

        with(binding){

            btnBack.setOnClickListener{
                val mFragmentManager = parentFragmentManager
                mFragmentManager.popBackStack()
            }

            with(rvRooms){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = roomAdapter
            }
        }
    }

}