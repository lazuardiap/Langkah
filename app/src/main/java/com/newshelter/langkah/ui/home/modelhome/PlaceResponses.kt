package com.newshelter.langkah.ui.home.modelhome

data class PlaceResponses(
    val html_attributions: List<Any>,
    val next_page_token: String,
    val results: List<Result>,
    val status: String
)