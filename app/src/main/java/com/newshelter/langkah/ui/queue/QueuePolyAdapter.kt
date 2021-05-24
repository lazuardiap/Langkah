package com.newshelter.langkah.ui.queue

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.AppointmentEntity
import com.newshelter.langkah.databinding.ItemsPolyQueueBinding
import com.newshelter.langkah.utils.DataDummy

class QueuePolyAdapter : RecyclerView.Adapter<QueuePolyAdapter.QueuePolyVh>() {

    private val listPolyId = ArrayList<String>()

    fun setPolyId(polyId : List<String>?){
        if (polyId == null) return
        this.listPolyId.clear()
        this.listPolyId.addAll(polyId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueuePolyVh {
        val binding = ItemsPolyQueueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QueuePolyVh(binding)
    }

    override fun onBindViewHolder(holder: QueuePolyVh, position: Int) {
        val polyId = listPolyId[position]
        holder.bind(polyId)
    }

    override fun getItemCount(): Int = listPolyId.size

    class QueuePolyVh (private val binding : ItemsPolyQueueBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(polyId: String){

            val dummyPoly = DataDummy.generateDummyPolyclinics()
            val dummyQueue = DataDummy.generateDummyAppointment()

            val queueList = ArrayList<AppointmentEntity>()

            with(binding){
                for (poly in dummyPoly){
                    if (poly.polyId == polyId){
                        tvPolyclinicsName.text = poly.polyName
                    }
                }

                for (queue in dummyQueue){
                    if (queue.polyId == polyId){
                        queueList.add(queue)
                    }
                }
            }
        }

    }
}