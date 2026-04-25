package com.moviles.examenmoviles.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Item displayed inside the bottom navigation bar.
 */
data class BottomNavItem(
    val id: String,
    val label: String,
    val icon: ImageVector
)

private val bottomNavItems: List<BottomNavItem> = listOf(
    BottomNavItem("home", "Home", Icons.Filled.Home),
    BottomNavItem("calendar", "Calendar", Icons.Filled.CalendarMonth),
    BottomNavItem("profile", "Profile", Icons.Filled.Person)
)

/**
 * Simple Material 3 bottom navigation bar shared by every primary
 * screen of the application.
 */
@Composable
fun BottomNavBar(
    selectedItemId: String = "home",
    onItemSelected: (BottomNavItem) -> Unit = {}
) {
    NavigationBar {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = item.id == selectedItemId,
                onClick = { onItemSelected(item) },
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(text = item.label) }
            )
        }
    }
}
