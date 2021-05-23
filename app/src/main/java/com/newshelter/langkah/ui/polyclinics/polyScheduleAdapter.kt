package com.newshelter.langkah.ui.polyclinics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.PolyScheduleEntity
import com.newshelter.langkah.databinding.ItemsPolyScheduleBinding

class polyScheduleAdapter : RecyclerView.Adapter<polyScheduleAdapter.polyScheduleVh>() {

    private val listSchedule = ArrayList<String>()


    fun setSchedule(sch : List<String>?){
        if (sch == null) return
        this.listSchedule.clear()
        this.listSchedule.addAll(sch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): polyScheduleVh {
        val binding = ItemsPolyScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return polyScheduleVh(binding)
    }

    override fun onBindViewHolder(holder: polyScheduleVh, position: Int) {
        val sch = listSchedule[position]
        holder.bind(sch)
    }

    override fun getItemCount(): Int = listSchedule.size

    class polyScheduleVh(private val binding : ItemsPolyScheduleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sch : String){
            with(binding){
                tvSchedule.text = sch
            }
        }

    }
}