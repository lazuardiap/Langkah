package com.newshelter.langkah.ui.hospital.modelroute

data class RouteResponses(
    val geocoded_waypoints: List<GeocodedWaypoint>,
    val routes: List<Route>,
    val status: String
)