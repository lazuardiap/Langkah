package com.newshelter.langkah.data

data class UserEntity(
    var userId : String,
    var userEmail : String,
    var userFullName : String,
    var userPassword: String,
    var phoneNumber : String,
    var homeAddress : String,
    var userCurrLocation : String,
    var appointmentStatus: String,
    var userBirthdate : String
)
