package com.newshelter.langkah.ui.doctors

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.DoctorsEntity
import com.newshelter.langkah.databinding.ItemsDoctorsBinding

class SmallDoctorAdapter : RecyclerView.Adapter<SmallDoctorAdapter.SmallDoctorVh>(){

    private val listDoctors = ArrayList<DoctorsEntity>()
    private val limit = 2

    fun setDoctor(doctors : List<DoctorsEntity>?){
        if (doctors == null) return
        this.listDoctors.clear()
        this.listDoctors.addAll(doctors)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallDoctorVh {
        val binding = ItemsDoctorsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SmallDoctorVh(binding)
    }

    override fun onBindViewHolder(holder: SmallDoctorVh, position: Int) {
        val doc = listDoctors[position]
        holder.bind(doc)
    }

    override fun getItemCount(): Int {
        if (listDoctors.size > limit){
            return limit
        }else {
            return listDoctors.size
        }
    }
    class SmallDoctorVh(private val binding: ItemsDoctorsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(doctor : DoctorsEntity){
            with(binding){
                tvItemName.text = doctor.doctorName
                tvItemSpecialist.text = doctor.doctorSpecialist

                itemView.setOnClickListener {
                    val i = Intent(itemView.context, DoctorDetailsActivity::class.java)
                    i.putExtra(DoctorDetailsActivity.EXTRA_ID, doctor.doctorId)
                    itemView.context.startActivity(i)
                }
            }
        }

    }

}