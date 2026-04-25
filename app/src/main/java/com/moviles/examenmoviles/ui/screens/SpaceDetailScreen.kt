package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.R
import com.moviles.examenmoviles.data.model.CoworkingSpace
import com.moviles.examenmoviles.ui.components.ReserveButton
import com.moviles.examenmoviles.ui.components.SpaceInfoRow

/**
 * Screen that shows every available attribute for a given coworking
 * [space]. No business logic is kept inside the composable: both
 * back navigation and reservation attempts are delegated to
 * callbacks.
 */
@Composable
fun SpaceDetailScreen(
    space: CoworkingSpace,
    onReserveClick: (CoworkingSpace) -> Unit,
    contentPadding: PaddingValues = PaddingValues(),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(contentPadding)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = space.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = space.name,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = space.description)

        Spacer(modifier = Modifier.height(16.dp))

        SpaceInfoRow(label = "Location", value = space.location)
        SpaceInfoRow(label = "Capacity", value = "${space.capacity} people")
        SpaceInfoRow(
            label = "Price per hour",
            value = "$${"%.2f".format(space.pricePerHour)}"
        )
        SpaceInfoRow(
            label = "Status",
            value = if (space.isAvailable) "Available" else "Unavailable"
        )

        Spacer(modifier = Modifier.height(24.dp))

        ReserveButton(
            onClick = { onReserveClick(space) },
            enabled = space.isAvailable,
            text = if (space.isAvailable) "Reserve" else "Not available"
        )
    }
}
