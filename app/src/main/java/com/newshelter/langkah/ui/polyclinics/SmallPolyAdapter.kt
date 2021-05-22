package com.newshelter.langkah.ui.polyclinics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.PolyclinicsEntity
import com.newshelter.langkah.databinding.ItemsPolyBinding

class SmallPolyAdapter : RecyclerView.Adapter<SmallPolyAdapter.SmallPolyVh>() {

    private val listPolys = ArrayList<PolyclinicsEntity>()
    private val limit = 2

    fun setPoly(p : List<PolyclinicsEntity>?){
        if (p == null) return
        this.listPolys.clear()
        this.listPolys.addAll(p)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallPolyVh {
        val binding = ItemsPolyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SmallPolyVh(binding)
    }

    override fun onBindViewHolder(holder: SmallPolyVh, position: Int) {
        val poly = listPolys[position]
        holder.bind(poly)
    }

    override fun getItemCount(): Int {
        if (listPolys.size > limit){
            return limit
        } else {
            return listPolys.size
        }
    }

    class SmallPolyVh (private val binding : ItemsPolyBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(poly : PolyclinicsEntity){
            with(binding){
                tvItemName.text = poly.polyName
            }
        }

    }
}