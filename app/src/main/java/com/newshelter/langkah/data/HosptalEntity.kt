package com.newshelter.langkah.data

data class HosptalEntity(
    var hospitalId : String,
    var hospitalName: String,
    var description: String,
    var address: String,
    var phoneNumber: String,
    var photo:String,
    var facilities: ArrayList<String>,
    var polyclinics: List<PolyclinicsEntity>,
    var doctors: List<DoctorsEntity>,
    var rooms: List<RoomEntity>,
    var latitude:Double,
    var longitude:Double,
)
