package com.newshelter.langkah.ui.hospital.modelroute

data class GeocodedWaypoint(
    val geocoder_status: String,
    val place_id: String,
    val types: List<String>
)