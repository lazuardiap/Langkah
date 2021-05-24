package com.newshelter.langkah.ui.queue

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.R
import com.newshelter.langkah.data.AppointmentEntity
import com.newshelter.langkah.databinding.ItemsPolyQueueBinding
import com.newshelter.langkah.utils.DataDummy

class QueuePolyAdapter : RecyclerView.Adapter<QueuePolyAdapter.QueuePolyVh>() {

    private val listPolyId = ArrayList<String>()

    private var ctx : Context? = null

    fun setPolyId(polyId : List<String>?, ctx : Context?){
        if (polyId == null) return
        this.listPolyId.clear()
        this.listPolyId.addAll(polyId)
        this.ctx = ctx
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueuePolyVh {
        val binding = ItemsPolyQueueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QueuePolyVh(binding)
    }

    override fun onBindViewHolder(holder: QueuePolyVh, position: Int) {
        val polyId = listPolyId[position]
        holder.bind(polyId, ctx)
    }

    override fun getItemCount(): Int = listPolyId.size

    class QueuePolyVh (private val binding : ItemsPolyQueueBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(polyId: String, ctx: Context?){

            val dummyPoly = DataDummy.generateDummyPolyclinics()
            val dummyQueue = DataDummy.generateDummyAppointment()

            val queueList = ArrayList<AppointmentEntity>()

            val queueUserAdapter = QueueUserAdapter()

            with(binding){
                for (poly in dummyPoly){
                    if (poly.polyId == polyId){
                        tvPolyclinicsName.text = poly.polyName
                    }
                }

                for (queue in dummyQueue){
                    if (queue.polyId == polyId){
                        queueList.add(queue)
                        val text = ctx?.getString(R.string.total_appointment, queueList.size)
                        tvTotalQueue.text = text

                        with(rvUserQueue){
                            queueUserAdapter.setUserAppointment(queueList)
                            layoutManager = LinearLayoutManager(context)
                            setHasFixedSize(true)
                            adapter = queueUserAdapter
                        }
                    } else{
                        val text = ctx?.getString(R.string.total_appointment, 0)
                        tvTotalQueue.text = text
                    }
                }
            }
        }

    }
}