package com.newshelter.langkah

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.HosptalEntity
import com.newshelter.langkah.databinding.ItemsHospitalBinding

class HospitalAdapter : RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {

    private val listHospital = ArrayList<HosptalEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalAdapter.HospitalViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HospitalAdapter.HospitalViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class HospitalViewHolder(private val binding: ItemsHospitalBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}