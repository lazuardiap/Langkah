package com.newshelter.langkah.ui.hospital.modelroute

data class Step(
    val distance: DistanceX,
    val duration: DurationX,
    val end_location: EndLocationX,
    val html_instructions: String,
    val maneuver: String,
    val polyline: Polyline,
    val start_location: StartLocationX,
    val travel_mode: String
)