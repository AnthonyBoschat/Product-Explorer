package com.example.productexplorer.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.productexplorer.shared.ProductListItem
import com.example.productexplorer.ProductUi
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.example.productexplorer.shared.CategoryRow
import com.example.productexplorer.sampleCategories
import com.example.productexplorer.sampleProducts
import com.example.productexplorer.theme.ProductExplorerTheme


@Composable
fun ProductCatalogScreen(
    modifier: Modifier = Modifier,
    products: List<ProductUi>,
    onProductClick: (ProductUi) -> Unit
){
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Catalogue produits",
                    style = MaterialTheme.typography.headlineMedium,
                )
            }
            item {
                Text(
                    text = "Explorez une sélection de produits disponibles localement.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            item {
                CategoryRow(categories = sampleCategories())
            }

            items(
                items = products,
                key = { product -> product.id }
            ){
                product ->
                    ProductListItem(
                        product = product,
                        onClick = { onProductClick(product)},
                    )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ProductCatalogScreenLightPreview(){
    ProductExplorerTheme(darkTheme = false){
        ProductCatalogScreen(
            products = sampleProducts(),
            onProductClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCatalogScreenDarkPreview(){
    ProductExplorerTheme(darkTheme = true){
        ProductCatalogScreen(
            products = sampleProducts(),
            onProductClick = {}
        )
    }
}