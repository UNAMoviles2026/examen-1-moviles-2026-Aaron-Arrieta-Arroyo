package com.moviles.examenmoviles.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moviles.examenmoviles.ui.components.BottomNavBar
import com.moviles.examenmoviles.ui.screens.SpaceDetailScreen
import com.moviles.examenmoviles.ui.screens.SpaceListScreen
import com.moviles.examenmoviles.viewmodel.CoworkingViewModel

/**
 * Entry point of the UI: wires together the [Scaffold], the bottom
 * navigation bar and the [NavHost] that hosts every screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: CoworkingViewModel = viewModel()
    val spaces by viewModel.spaces.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Coworking Spaces") })
        },
        bottomBar = {
            BottomNavBar(
                selectedItemId = "home",
                onItemSelected = {
                    navController.popBackStack(
                        route = AppDestinations.SpaceList.route,
                        inclusive = false
                    )
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppDestinations.SpaceList.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = AppDestinations.SpaceList.route) {
                SpaceListScreen(
                    spaces = spaces,
                    onSpaceClick = { space ->
                        navController.navigate(
                            AppDestinations.SpaceDetail.createRoute(space.id)
                        )
                    }
                )
            }

            composable(
                route = AppDestinations.SpaceDetail.route,
                arguments = listOf(
                    navArgument(AppDestinations.SPACE_ID_ARG) { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val spaceId = backStackEntry.arguments
                    ?.getInt(AppDestinations.SPACE_ID_ARG)
                    ?: return@composable
                val space = remember(spaceId) { viewModel.getSpaceById(spaceId) }

                if (space == null) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Space not found")
                    }
                } else {
                    SpaceDetailScreen(
                        space = space,
                        onReserveClick = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}
