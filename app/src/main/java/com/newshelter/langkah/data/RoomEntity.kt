package com.newshelter.langkah.data

data class RoomEntity(
    var roomId: String,
    var roomType: String,
    var pricePerDay : String,
    var downPayment: String,
    var servicesPrice : String,
    var preInspectionPrice : String
)
