package com.example.productexplorer.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val CARD_SHADOW_ELEVATION = 3.dp
private val CARD_TONAL_ELEVATION  = 4.dp
private val CARD_CONTENT_PADDING  = 16.dp

/** Common card look for every content block of the app. */
@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(containerColor),
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(defaultElevation = CARD_SHADOW_ELEVATION)
    ) {
        Surface(
            color = containerColor,
            contentColor = contentColor,
            tonalElevation = CARD_TONAL_ELEVATION
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(CARD_CONTENT_PADDING),
                content = content
            )
        }
    }
}
