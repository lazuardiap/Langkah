package com.newshelter.langkah.ui.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newshelter.langkah.data.RoomEntity
import com.newshelter.langkah.databinding.ItemsRoomsBinding

class RoomAdapter : RecyclerView.Adapter<RoomAdapter.RoomAdapterVh>() {

    private val listRooms = ArrayList<RoomEntity>()

    fun setRoom(rooms : List<RoomEntity>?){
        if (rooms == null) return
        this.listRooms.clear()
        this.listRooms.addAll(rooms)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomAdapterVh {
        val binding = ItemsRoomsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomAdapterVh(binding)
    }

    override fun onBindViewHolder(holder: RoomAdapterVh, position: Int) {
        val room = listRooms[position]
        holder.bind(room)
    }

    override fun getItemCount(): Int = listRooms.size

    class RoomAdapterVh(private val binding : ItemsRoomsBinding) :  RecyclerView.ViewHolder(binding.root) {
        fun bind(room : RoomEntity){
            with(binding){
                tvItemType.text = room.roomType

                itemView.setOnClickListener {

                }
            }
        }

    }

}