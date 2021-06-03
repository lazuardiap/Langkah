package com.newshelter.langkah.ui.home.modelhome

data class Result(
    val business_status: String,
    val icon: String,
    val name: String,
    val photos: List<Photo>,
    val place_id: String,
    val rating: Double,
    val reference: String,
    val scope: String,
    val types: List<String>,
    val user_ratings_total: Int,
    val vicinity: String,

)