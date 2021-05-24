package com.newshelter.langkah.data

data class AppointmentEntity(
    var appointmentId : String,
    var userId : String,
    var userAge : String,
    var hospitalId: String,
    var polyId: String,
    var doctorId: String,
    var appointmentDate : String,
    var appointmentTime : String
)
