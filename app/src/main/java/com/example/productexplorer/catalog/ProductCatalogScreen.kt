package com.example.productexplorer.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productexplorer.ProductUi
import com.example.productexplorer.sampleCategories
import com.example.productexplorer.sampleProducts
import com.example.productexplorer.shared.CategoryRow
import com.example.productexplorer.shared.ProductListItem
import com.example.productexplorer.theme.ProductExplorerTheme


@Composable
fun ProductCatalogScreen(
    products: List<ProductUi>,
    categories: List<String>,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    showOnlyInStock: Boolean,
    onToggleStockFilter: () -> Unit,
    favoriteProductIds: List<Int>,
    onFavoriteClick: (Int) -> Unit,
    onProductClick: (ProductUi) -> Unit,
    modifier: Modifier = Modifier
) {


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
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    label = { Text(text = "Rechercher un produit") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            item {
                Button(
                    onClick = onToggleStockFilter
                ) {
                    val sentence =
                        if (showOnlyInStock) "Afficher tous les produits" else "Afficher uniquement les produits en stock"
                    Text(
                        text = sentence
                    )
                }
            }

            item {
                CategoryRow(categories = sampleCategories())
            }

            item {
                Text(
                    text = "${products.size} produit(s) affiché(s)",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            items(
                items = products,
                key = { product -> product.id }
            ) { product ->
                ProductListItem(
                    product = product,
                    onClick = { onProductClick(product) },
                    isFavorite = favoriteProductIds.contains(product.id),
                    onFavoriteClick = { onFavoriteClick(product.id) }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductCatalogScreenLightPreview() {
    ProductExplorerTheme(darkTheme = false) {
        ProductCatalogContainer(
            products = sampleProducts(),
            categories = sampleCategories(),
            onProductClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCatalogScreenDarkPreview() {
    ProductExplorerTheme(darkTheme = true) {
        ProductCatalogContainer(
            products = sampleProducts(),
            categories = sampleCategories(),
            onProductClick = {}
        )
    }
}