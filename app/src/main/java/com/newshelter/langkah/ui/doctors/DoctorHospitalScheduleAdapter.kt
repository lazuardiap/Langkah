package com.newshelter.langkah.ui.doctors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.ScheduleEntity
import com.newshelter.langkah.databinding.ItemsHospitalScheduleBinding
import com.newshelter.langkah.utils.DataDummy

class DoctorHospitalScheduleAdapter : RecyclerView.Adapter<DoctorHospitalScheduleAdapter.DoctorHospitalVh>() {

    private val listSchedule = ArrayList<ScheduleEntity>()

    fun setSchedule(sch : List<ScheduleEntity>?){
        if (sch == null) return
        this.listSchedule.clear()
        this.listSchedule.addAll(sch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorHospitalVh {
        val binding = ItemsHospitalScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoctorHospitalVh(binding)
    }

    override fun onBindViewHolder(holder: DoctorHospitalVh, position: Int) {
        val sch = listSchedule[position]
        holder.bind(sch)
    }

    override fun getItemCount(): Int = listSchedule.size

    class DoctorHospitalVh (private val binding: ItemsHospitalScheduleBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(sch : ScheduleEntity){
            with(binding){

                val listHospital = DataDummy.generateDummyHospital()

                val dayHourAdapter = DoctorDayHourAdapter()

                for (hospital in listHospital){
                    if (hospital.hospitalId == sch.hospitalId){
                        tvHospitalName.text = hospital.hospitalName

                        with(rvDayHour){
                            dayHourAdapter.setDayHour(sch.dayHour)
                            layoutManager = LinearLayoutManager(context)
                            setHasFixedSize(true)
                            adapter = dayHourAdapter
                        }

                    }
                }
            }
        }

    }
}