package com.moviles.examenmoviles.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Basic button used to trigger a space reservation. The caller
 * provides the action through [onClick] so no business logic lives
 * inside the composable.
 */
@Composable
fun ReserveButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    text: String = "Reserve",
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(text = text)
    }
}
