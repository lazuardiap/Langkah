package com.newshelter.langkah.data

data class HosptalEntity(
    var hospitalId : String,
    var hospitalName: String,
    var description: String,
    var address: String,
    var phoneNumber: String,
    var facilities: ArrayList<String>,
    var polyclinics: ArrayList<PolyclinicsEntity>,
    var doctors: ArrayList<DoctorsEntity>,
    var rooms: ArrayList<RoomEntity>
)
