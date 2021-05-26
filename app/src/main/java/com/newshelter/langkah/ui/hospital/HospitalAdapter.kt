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
import com.newshelter.langkah.ui.home.modelhome.Photo
import com.newshelter.langkah.ui.home.modelhome.Result

class HospitalAdapter :  RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>(){

    private val listHospital = ArrayList<Result>()
    private val limit = 3



    fun setHospital(hospital: List<Result>?){
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
        val photo = hospital.photos[position]

        holder.bind(hospital,photo)
    }

    override fun getItemCount(): Int {
        if (listHospital.size > limit){
            return limit
        }else{
            return listHospital.size
        }
    }

    class HospitalViewHolder(private val binding: ItemsHospitalBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(hospital: Result,photo: Photo){
            with(binding){
                tvItemName.text = hospital.name
                tvItemAddress.text = hospital.vicinity

                val getPhoto = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=100&maxheight=100&photoreference=${photo.photo_reference}&key=AIzaSyDLXDQiumBLhSh0OB5D7biGcQL7PbhSY-w"


                itemView.setOnClickListener {
                    val i = Intent(itemView.context, HospitalDetailActivity::class.java)
                    i.putExtra(HospitalDetailActivity.EXTRA_ID, hospital.place_id)
                    itemView.context.startActivity(i)
                }

            }
        }
    }

}
