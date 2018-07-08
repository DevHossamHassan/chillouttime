package com.letsgotoperfection.chillouttime.models

data class Results(
        val results: List<Movie>,
        val page: Int,
        val total_results: Int,
        val dates: Dates,
        val total_pages: Int
)