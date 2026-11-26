package com.example.productexplorer.catalog

import androidx.lifecycle.ViewModel
import com.example.productexplorer.ProductUi
import com.example.productexplorer.sampleCategories
import com.example.productexplorer.sampleProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductCatalogViewModel : ViewModel() {
    private val allProducts: List<ProductUi> = sampleProducts()
    private val allCategories: List<String> = sampleCategories()

    private val _uiState = MutableStateFlow(
        ProductCatalogUiState(
            products = allProducts,
            categories = allCategories
        )
    )

    val uiState: StateFlow<ProductCatalogUiState> = _uiState.asStateFlow()

    private fun filterProducts(state: ProductCatalogUiState): List<ProductUi> {
        return allProducts.filter { product ->
            val matchesSearch = product.title.contains(state.searchQuery, ignoreCase = true) ||
                    product.brand.contains(state.searchQuery, ignoreCase = true) ||
                    product.category.contains(state.searchQuery, ignoreCase = true)

            val matchesStock =
                !state.showOnlyInStock || product.stock > 0

            val matchesFavorite =
                !state.showOnlyFavorite || product.id in state.favoriteProductIds

            matchesSearch && matchesStock && matchesFavorite
        }
    }


    // Applique un changement de l'état, puis reconstruit la liste des produits
    // Chaque fonction en dessous nécessite de reconstruire la liste des produits
    private fun updateState(transform: (ProductCatalogUiState) -> ProductCatalogUiState) {
        _uiState.update { currentState ->
            val newState = transform(currentState)
            newState.copy(products = filterProducts(newState))
        }
    }

    fun onSearchQueryChange(newValue: String) {
        updateState { currentState -> currentState.copy(searchQuery = newValue) }
    }

    fun onToggleStockFilter() {
        updateState { currentState -> currentState.copy(showOnlyInStock = !currentState.showOnlyInStock) }
    }

    fun onToggleFavoriteOnlyFilter() {
        updateState { currentState -> currentState.copy(showOnlyFavorite = !currentState.showOnlyFavorite) }
    }

    fun onFavoriteClick(productId: Int) {
        updateState { currentState ->
            val newFavoriteIds =
                if (productId in currentState.favoriteProductIds) {
                    currentState.favoriteProductIds - productId
                } else {
                    currentState.favoriteProductIds + productId
                }
            currentState.copy(favoriteProductIds = newFavoriteIds)
        }
    }
}