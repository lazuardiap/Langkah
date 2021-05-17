package com.newshelter.langkah

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.HosptalEntity
import com.newshelter.langkah.databinding.ItemsHospitalBinding

class HospitalAdapter : RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {

    private val listHospital = ArrayList<HosptalEntity>()

    fun setHospital(hospital: List<HosptalEntity>){
        if (hospital == null) return
        this.listHospital.clear()
        this.listHospital.addAll(hospital)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val binding = ItemsHospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HospitalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        val hospital = listHospital[position]
        holder.bind(hospital)
    }

    override fun getItemCount(): Int = listHospital.size

    class HospitalViewHolder(private val binding: ItemsHospitalBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(hospital: HosptalEntity){
            with(binding){
                tvItemName.text = hospital.hospitalName
                tvItemAddress.text = hospital.address
            }
        }
    }
}