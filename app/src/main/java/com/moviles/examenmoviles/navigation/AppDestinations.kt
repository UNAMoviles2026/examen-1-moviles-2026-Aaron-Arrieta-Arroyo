package com.moviles.examenmoviles.navigation

/**
 * Centralized definition of every navigable destination in the app.
 * Using a sealed hierarchy avoids stringly-typed routes scattered
 * around the code base.
 */
sealed class AppDestinations(val route: String) {

    data object SpaceList : AppDestinations(route = "space_list")

    data object SpaceDetail : AppDestinations(route = "space_detail/{$SPACE_ID_ARG}") {
        /** Builds a concrete route replacing the path argument with [spaceId]. */
        fun createRoute(spaceId: Int): String = "space_detail/$spaceId"
    }

    companion object {
        const val SPACE_ID_ARG = "spaceId"
    }
}
