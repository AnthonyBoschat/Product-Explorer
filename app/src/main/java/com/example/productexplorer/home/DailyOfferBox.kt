package com.example.productexplorer.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import com.example.productexplorer.shared.AppCard

@Composable
fun DailyOfferBox(
    modifier: Modifier = Modifier
){
    Box(modifier = modifier.fillMaxWidth()){
        AppCard(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Offre du jour",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Jusqu’à -20 % sur une sélection de produits",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Surface(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = (-16).dp, y = (-8).dp),
            shape = MaterialTheme.shapes.small,
            color = MaterialTheme.colorScheme.tertiary
        ) {
            Text(
                text = "Nouveau",
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                style = MaterialTheme.typography.labelMedium,

            )
        }
    }

}