package com.moviles.examenmoviles.data.mock

import com.moviles.examenmoviles.data.model.CoworkingSpace

/**
 * Static in-memory data source used as a stand-in for a real
 * backend during this proof of concept.
 */
object MockData {

    val coworkingSpaces: List<CoworkingSpace> = listOf(
        CoworkingSpace(
            id = 1,
            name = "Downtown Hub",
            description = "A modern coworking space in the heart of the city with high speed internet and meeting rooms.",
            location = "San Jose",
            capacity = 40,
            pricePerHour = 8.50,
            isAvailable = true,
            imageUrl = ""
        ),
        CoworkingSpace(
            id = 2,
            name = "Green Garden Workspace",
            description = "Eco-friendly coworking environment surrounded by plants and natural light.",
            location = "Heredia",
            capacity = 25,
            pricePerHour = 6.00,
            isAvailable = true,
            imageUrl = ""
        ),
        CoworkingSpace(
            id = 3,
            name = "Tech Loft",
            description = "Tech-oriented loft with ergonomic desks and dedicated podcast booths.",
            location = "Alajuela",
            capacity = 60,
            pricePerHour = 12.00,
            isAvailable = false,
            imageUrl = ""
        ),
        CoworkingSpace(
            id = 4,
            name = "Seaside Studio",
            description = "Coastal studio with silent pods and outdoor terraces.",
            location = "Puntarenas",
            capacity = 18,
            pricePerHour = 9.75,
            isAvailable = true,
            imageUrl = ""
        ),
        CoworkingSpace(
            id = 5,
            name = "Mountain Retreat Office",
            description = "Mountain retreat with private cabins and fiber internet.",
            location = "Cartago",
            capacity = 30,
            pricePerHour = 7.25,
            isAvailable = true,
            imageUrl = ""
        )
    )
}
