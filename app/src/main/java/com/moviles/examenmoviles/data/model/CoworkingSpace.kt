package com.moviles.examenmoviles.data.model

/**
 * Domain model representing a coworking space that can be browsed
 * and reserved by the end user.
 *
 * The model is intentionally plain (no framework-specific types)
 * so it can be reused across the UI, the ViewModel and future
 * data sources (REST API, local database, etc.).
 */
data class CoworkingSpace(
    val id: Int,
    val name: String,
    val description: String,
    val location: String,
    val capacity: Int,
    val pricePerHour: Double,
    val isAvailable: Boolean,
    val imageUrl: String
)
