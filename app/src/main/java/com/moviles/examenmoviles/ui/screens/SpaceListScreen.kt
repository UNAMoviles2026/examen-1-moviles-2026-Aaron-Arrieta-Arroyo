package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviles.examenmoviles.data.model.CoworkingSpace
import com.moviles.examenmoviles.ui.components.SpaceCard

/**
 * Screen that shows every coworking space using a [LazyColumn].
 * This composable is stateless: data and callbacks are supplied
 * by the caller so business logic stays outside of it.
 */
@Composable
fun SpaceListScreen(
    spaces: List<CoworkingSpace>,
    onSpaceClick: (CoworkingSpace) -> Unit,
    contentPadding: PaddingValues = PaddingValues(),
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = contentPadding
    ) {
        items(items = spaces, key = { it.id }) { space ->
            SpaceCard(
                space = space,
                onClick = { onSpaceClick(space) }
            )
        }
    }
}
