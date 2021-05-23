package com.newshelter.langkah.ui.doctors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.DoctorsEntity
import com.newshelter.langkah.databinding.ItemsDoctorsBinding

class FullDoctorAdapter : RecyclerView.Adapter<FullDoctorAdapter.FullDoctorVh>() {

    private val listDoctors = ArrayList<DoctorsEntity>()

    fun setDoctor(doctors : List<DoctorsEntity>?){
        if (doctors == null) return
        this.listDoctors.clear()
        this.listDoctors.addAll(doctors)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FullDoctorVh {
        val binding = ItemsDoctorsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FullDoctorVh(binding)
    }

    override fun onBindViewHolder(holder: FullDoctorVh, position: Int) {
        val doc = listDoctors[position]
        holder.bind(doc)
    }

    override fun getItemCount(): Int = listDoctors.size

    class FullDoctorVh(private val binding : ItemsDoctorsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(doctor : DoctorsEntity){
            with(binding){
                tvItemName.text = doctor.doctorName
                tvItemSpecialist.text = doctor.doctorSpecialist

            }
        }

    }


}