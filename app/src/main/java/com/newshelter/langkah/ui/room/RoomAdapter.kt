package com.newshelter.langkah.ui.room

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.RoomEntity
import com.newshelter.langkah.databinding.ItemsRoomsBinding

class RoomAdapter : RecyclerView.Adapter<RoomAdapter.RoomAdapterVh>() {

    private val listRooms = ArrayList<RoomEntity>()

    private lateinit var hospitalId : String

    fun setRoom(rooms : List<RoomEntity>?, hospitalId : String){
        if (rooms == null) return
        this.listRooms.clear()
        this.listRooms.addAll(rooms)
        this.hospitalId = hospitalId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomAdapterVh {
        val binding = ItemsRoomsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomAdapterVh(binding)
    }

    override fun onBindViewHolder(holder: RoomAdapterVh, position: Int) {
        val room = listRooms[position]
        holder.bind(room, hospitalId)
    }

    override fun getItemCount(): Int = listRooms.size

    class RoomAdapterVh(private val binding : ItemsRoomsBinding) :  RecyclerView.ViewHolder(binding.root) {
        fun bind(room : RoomEntity, hospitalId: String){
            with(binding){
                tvItemType.text = room.roomType

                itemView.setOnClickListener {
                    val i = Intent(itemView.context, RoomDetailActivity::class.java)
                    i.putExtra(RoomDetailActivity.EXTRA_ROOM_ID, room.roomId)
                    i.putExtra(RoomDetailActivity.EXTRA_HOSPITAL_ID, hospitalId)
                    itemView.context.startActivity(i)
                }
            }
        }

    }

}