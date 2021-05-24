package com.newshelter.langkah.ui.queue

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.AppointmentEntity
import com.newshelter.langkah.databinding.ItemsUserQueueBinding
import com.newshelter.langkah.utils.DataDummy

class QueueUserAdapter : RecyclerView.Adapter<QueueUserAdapter.QueueUserVh>(){

    private val listQueue = ArrayList<AppointmentEntity>()

    fun setUserAppointment(queue : List<AppointmentEntity>?){
        if (queue == null) return
        this.listQueue.clear()
        this.listQueue.addAll(queue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueueUserVh {
        val binding = ItemsUserQueueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QueueUserVh(binding)
    }

    override fun onBindViewHolder(holder: QueueUserVh, position: Int) {
        val q = listQueue[position]
        holder.bind(q)
    }

    override fun getItemCount(): Int = listQueue.size

    class QueueUserVh (private val binding : ItemsUserQueueBinding) : RecyclerView.ViewHolder(binding.root){

        private lateinit var user : String

        private lateinit var doctor : String


        fun bind (queue : AppointmentEntity){

            val dummyUser = DataDummy.generateDummyUser()

            val dummyDoctor = DataDummy.generateDummyDoctors()

            for (user in dummyUser){
                if (user.userId == queue.userId){
                    this.user = user.userFullName
                }
            }

            for (doctor in dummyDoctor){
                if (doctor.doctorId == queue.doctorId){
                    this.doctor = doctor.doctorName
                }
            }

            with(binding){
                tvUserName.text = user
                tvDoctorName.text = doctor
                tvAppointmentDate.text = queue.appointmentDate
                tvAppointmentTime.text = queue.appointmentTime
            }
        }

    }
}