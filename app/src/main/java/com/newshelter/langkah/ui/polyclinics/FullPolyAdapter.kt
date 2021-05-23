package com.newshelter.langkah.ui.polyclinics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.PolyclinicsEntity
import com.newshelter.langkah.databinding.ItemsPolyBinding

class FullPolyAdapter : RecyclerView.Adapter<FullPolyAdapter.FullPolyVh>() {

    private val listPolys = ArrayList<PolyclinicsEntity>()

    fun setPoly(p : List<PolyclinicsEntity>?){
        if (p == null) return
        this.listPolys.clear()
        this.listPolys.addAll(p)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FullPolyVh {
        val binding = ItemsPolyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FullPolyVh(binding)
    }

    override fun onBindViewHolder(holder: FullPolyVh, position: Int) {
        val poly = listPolys[position]
        holder.bind(poly)
    }

    override fun getItemCount(): Int  = listPolys.size

    class FullPolyVh (private val binding : ItemsPolyBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(poly : PolyclinicsEntity){
            with(binding){
                tvItemName.text = poly.polyName
            }
        }
    }
}