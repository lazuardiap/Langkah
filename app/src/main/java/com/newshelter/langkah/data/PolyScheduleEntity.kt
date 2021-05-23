package com.newshelter.langkah.data

data class PolyScheduleEntity (
    var polySchId : String,
    var hospitalId : String,
    var polyId : String,
    var dayHour : ArrayList<String>
    )