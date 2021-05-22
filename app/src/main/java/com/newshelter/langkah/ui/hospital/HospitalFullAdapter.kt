package com.newshelter.langkah.ui.hospital

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.HosptalEntity
import com.newshelter.langkah.databinding.ItemsHospitalBinding

class HospitalFullAdapter : RecyclerView.Adapter<HospitalFullAdapter.HospitalFullViewHolder>() {

    private val listHospital = ArrayList<HosptalEntity>()

    fun setFullHospital(hospital : List<HosptalEntity>?){
        if (hospital == null) return
        this.listHospital.clear()
        this.listHospital.addAll(hospital)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalFullViewHolder {
        val binding = ItemsHospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HospitalFullViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HospitalFullViewHolder, position: Int) {
        val hospital = listHospital[position]
        holder.bind(hospital)
    }

    override fun getItemCount(): Int = listHospital.size


    class HospitalFullViewHolder (private val binding: ItemsHospitalBinding): RecyclerView.ViewHolder(binding.root) {

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