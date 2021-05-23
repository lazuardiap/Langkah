package com.newshelter.langkah.ui.polyclinics

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.PolyclinicsEntity
import com.newshelter.langkah.databinding.ItemsPolyBinding

class SmallPolyAdapter : RecyclerView.Adapter<SmallPolyAdapter.SmallPolyVh>() {

    private val listPolys = ArrayList<PolyclinicsEntity>()
    private val limit = 2
    private lateinit var hospitalId : String

    fun setPoly(p : List<PolyclinicsEntity>?, hospitalId : String){
        if (p == null) return
        this.listPolys.clear()
        this.listPolys.addAll(p)
        this.hospitalId = hospitalId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallPolyVh {
        val binding = ItemsPolyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SmallPolyVh(binding)
    }

    override fun onBindViewHolder(holder: SmallPolyVh, position: Int) {
        val poly = listPolys[position]
        holder.bind(poly, hospitalId)
    }

    override fun getItemCount(): Int {
        if (listPolys.size > limit){
            return limit
        } else {
            return listPolys.size
        }
    }

    class SmallPolyVh (private val binding : ItemsPolyBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(poly : PolyclinicsEntity, hospitalId : String){
            with(binding){
                tvItemName.text = poly.polyName

                itemView.setOnClickListener {
                    val i = Intent(itemView.context, PolyclinicDetailsActivity::class.java)
                    i.putExtra(PolyclinicDetailsActivity.EXTRA_ID, poly.polyId)
                    i.putExtra(PolyclinicDetailsActivity.EXTRA_HOSPITAL_ID, hospitalId)
                    itemView.context.startActivity(i)
                }
            }
        }

    }
}