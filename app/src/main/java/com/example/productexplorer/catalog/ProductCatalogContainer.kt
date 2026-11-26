package com.example.productexplorer.catalog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.productexplorer.ProductUi

@Composable
fun ProductCatalogContainer(
    products: List<ProductUi>,
    categories: List<String>,
    onProductClick: (ProductUi) -> Unit,
    modifier: Modifier = Modifier,
) {
    // Filtre : Barre de recherche
    var searchQuery by rememberSaveable() { mutableStateOf("") }
    // Filtre : Affiche les produits en stock
    var showOnlyInStock by rememberSaveable() { mutableStateOf(false) }
    // Liste des Ids des produits en favoris
    var favoriteProductIds by rememberSaveable() { mutableStateOf(listOf<Int>()) }

    // La liste des produits filtré selon les filtre de l'utilisateur
    val filteredProducts = remember(products, searchQuery, showOnlyInStock) {
        products.filter { product ->
            val matchesSearch = product.title.contains(searchQuery, ignoreCase = true) ||
                    product.brand.contains(searchQuery, ignoreCase = true) ||
                    product.category.contains(searchQuery, ignoreCase = true)

            val matchesStock = !showOnlyInStock || product.stock > 0

            matchesSearch && matchesStock
        }
    }

    // Fait évoluer la barre de recherche
    fun handleSearchQuery(newValue: String) {
        searchQuery = newValue
    }

    // Fait évoluer l'affichage des produits en stock uniquement
    fun handleToggleStockFilter() {
        showOnlyInStock = !showOnlyInStock
    }

    // Mettre ou retirer un produit aux favoris
    fun toggleFavorite(productId: Int) {
        favoriteProductIds = if (favoriteProductIds.contains(productId)) {
            favoriteProductIds - productId
        } else {
            favoriteProductIds + productId
        }
    }


    ProductCatalogScreen(
        products = filteredProducts,
        categories = categories,
        searchQuery = searchQuery,
        onSearchQueryChange = { newValue -> handleSearchQuery(newValue) },
        showOnlyInStock = showOnlyInStock,
        onToggleStockFilter = { handleToggleStockFilter() },
        favoriteProductIds = favoriteProductIds,
        onFavoriteClick = { productId -> toggleFavorite(productId) },
        onProductClick = onProductClick,
    )
}