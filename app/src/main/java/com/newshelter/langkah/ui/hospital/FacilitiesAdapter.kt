package com.newshelter.langkah.ui.hospital

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.databinding.ItemFacilitiesBinding

class FacilitiesAdapter :  RecyclerView.Adapter<FacilitiesAdapter.FacilitiesViewHolder>() {

    private val listFacilities = ArrayList<String>()

    fun setFacility(fac : List<String>?){
        if (fac == null) return
        this.listFacilities.clear()
        this.listFacilities.addAll(fac)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacilitiesViewHolder {
        val binding = ItemFacilitiesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FacilitiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FacilitiesViewHolder, position: Int) {
        val fac = listFacilities[position]
        holder.bind(fac)
    }

    override fun getItemCount(): Int = listFacilities.size

    class FacilitiesViewHolder(private val binding: ItemFacilitiesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(fac : String){
            binding.tvFacility.text = fac
        }

    }


}