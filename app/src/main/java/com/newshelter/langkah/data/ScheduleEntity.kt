package com.newshelter.langkah.data

data class ScheduleEntity(
    var schId : String,
    var hospitalId : String,
    var doctorId : String,
    var dayHour : ArrayList<String>
)
