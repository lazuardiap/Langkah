package com.newshelter.langkah.ui.doctors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.databinding.ItemsDayhourScheduleBinding

class DoctorDayHourAdapter : RecyclerView.Adapter<DoctorDayHourAdapter.DayHourVh>() {

    private val listDH = ArrayList<String>()

    fun setDayHour(dh : ArrayList<String>?){
        if (dh == null) return
        this.listDH.clear()
        this.listDH.addAll(dh)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayHourVh {
        val binding = ItemsDayhourScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayHourVh(binding)
    }

    override fun onBindViewHolder(holder: DayHourVh, position: Int) {
        val dh = listDH[position]
        holder.bind(dh)
    }

    override fun getItemCount(): Int = listDH.size

    class DayHourVh (private val binding : ItemsDayhourScheduleBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(dh : String){
            binding.tvDayHour.text = dh
        }

    }
}