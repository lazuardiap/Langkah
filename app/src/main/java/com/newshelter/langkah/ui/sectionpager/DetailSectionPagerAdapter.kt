package com.newshelter.langkah.ui.sectionpager

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.newshelter.langkah.R
import com.newshelter.langkah.data.DoctorsEntity
import com.newshelter.langkah.data.PolyclinicsEntity
import com.newshelter.langkah.ui.doctors.SmallDoctorsFragment
import com.newshelter.langkah.ui.polyclinics.SmallPolyclinicsFragment

class DetailSectionPagerAdapter (private val ctx : Context?, activity : AppCompatActivity)
    :  FragmentStateAdapter(activity){

    private lateinit var id : String
    private lateinit var docs : List<DoctorsEntity>
    private lateinit var polys : List<PolyclinicsEntity>
    private lateinit var fragment : Fragment


    fun setData(id : String, doctors : List<DoctorsEntity>, polyclinics: List<PolyclinicsEntity>){
        this.id = id
        docs = doctors
        polys = polyclinics
    }

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        when(position){
            0 -> {
                fragment = SmallDoctorsFragment()
                val bundle = Bundle()
                bundle.putString(SmallDoctorsFragment.EXTRA_ID, id)
                fragment.arguments = bundle
            }
            1 -> {
                fragment = SmallPolyclinicsFragment()
                val bundle = Bundle()
                bundle.putString(SmallPolyclinicsFragment.EXTRA_ID, id)
                fragment.arguments = bundle
            }
        }
        return fragment
    }



}