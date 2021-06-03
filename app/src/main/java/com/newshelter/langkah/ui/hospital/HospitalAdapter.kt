package com.newshelter.langkah.ui.hospital

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.newshelter.langkah.BuildConfig
import com.newshelter.langkah.data.HosptalEntity
import com.newshelter.langkah.databinding.ItemsHospitalBinding

class HospitalAdapter :  RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>(){

    private val listHospital = ArrayList<HosptalEntity>()
    private val limit = 3



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

    override fun getItemCount(): Int {
        if (listHospital.size > limit){
            return limit
        }else{
            return listHospital.size
        }
    }

    inner class HospitalViewHolder(private val binding: ItemsHospitalBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(hospital: HosptalEntity) {
            with(binding) {
                tvItemName.text = hospital.hospitalName
                tvItemAddress.text = hospital.address
                val imageUrl ="https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=${hospital.photo}&key=${BuildConfig.KEY}"

                with(binding){
                    Glide.with(itemView.context)
                        .load(imageUrl)
                        .apply(RequestOptions().override(100,100))
                        .into(imgPoster)

                    itemView.setOnClickListener {
                        val i = Intent(itemView.context, HospitalDetailActivity::class.java)
                        i.putExtra(HospitalDetailActivity.EXTRA_ID, hospital.hospitalId)
                        itemView.context.startActivity(i)
                    }

                }
            }
        }
    }
}
