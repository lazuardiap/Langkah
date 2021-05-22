package com.newshelter.langkah.ui.hospital

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.LandingActivity
import com.newshelter.langkah.data.HosptalEntity
import com.newshelter.langkah.databinding.ItemsHospitalBinding

class HospitalAdapter :  RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>(){

    private val listHospital = ArrayList<HosptalEntity>()
    private val limit = 3



    fun setHospital(hospital: List<HosptalEntity>?){
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

    override fun getItemCount(): Int {
        if (listHospital.size > limit){
            return limit
        }else{
            return listHospital.size
        }
    }

    class HospitalViewHolder(private val binding: ItemsHospitalBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(hospital: HosptalEntity){
            with(binding){
                tvItemName.text = hospital.hospitalName
                tvItemAddress.text = hospital.address

                itemView.setOnClickListener {
                    val i = Intent(itemView.context, HospitalDetailActivity::class.java)
                    i.putExtra(HospitalDetailActivity.EXTRA_ID, hospital.hospitalId)
                    itemView.context.startActivity(i)
                }
            }
        }
    }

}
