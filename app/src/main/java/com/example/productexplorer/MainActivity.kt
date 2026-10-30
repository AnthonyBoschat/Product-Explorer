package com.example.productexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productexplorer.ui.theme.ProductExplorerTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.OutlinedTextField

data class ProductUi(
    val title: String,
    val brand: String,
    val category: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val warrantyInformation: String,
    val shippingInformation: String
)

fun sampleProduct(): ProductUi{
    return ProductUi(
        title = "Smartphone Toto X",
        brand = "TotoTech",
        category = "Smartphones",
        description = "Un smartphone léger avec un écran lumineux, une bonne autonomie et un design moderne.",
        price = 699.99,
        discountPercentage = 12.5,
        rating = 4.6,
        stock = 34,
        warrantyInformation = "Garantie constructeur : 2 ans",
        shippingInformation = "Livraison estimée : 3 à 5 jours ouvrés"
    )
}


fun sampleProductOutOfStock(): ProductUi {
    return ProductUi(
        title = "Casque Audio Pulse",
        brand = "SoundPeak",
        category = "Audio",
        description = "Un casque confortable conçu pour écouter de la musique, " +
                "suivre des cours en ligne et travailler dans de bonnes conditions.",
        price = 129.99,
        discountPercentage = 8.0,
        rating = 4.2,
        stock = 0,
        warrantyInformation = "Garantie constructeur : 1 an",
        shippingInformation = "Produit temporairement indisponible"
    )
}



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductExplorerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductDetailScreen(
                        modifier = Modifier.padding(innerPadding),
                        product = sampleProduct(),
                        onAddToCartClick = {}
                    )
                }
            }
        }
    }
}


@Composable
fun ProductDetailScreen(
    modifier: Modifier = Modifier,
    product: ProductUi,
    onAddToCartClick: () -> Unit
){
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ){
        ProductImage(
            productTitle = product.title,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )
        ProductHeader(
            title = product.title,
            brand = product.brand,
            category = product.category,
        )
        ProductPriceCard(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            price = product.price,
            discountPercentage = product.discountPercentage
        )
        ProductAvailabilityCard(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            stock = product.stock,
            shippingInformation = product.shippingInformation,
        )
        ProductRating(
            rating = product.rating,
            modifier = Modifier.padding(top = 16.dp)
        )
        ProductDescription(
            modifier = Modifier.padding(top = 16.dp),
            description = product.description
        )
        ProductWarrantyField(
            warrantyInformation = product.warrantyInformation,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        )
        AddToCartButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        )
    }
}


@Composable
fun ProductAvailabilityCard(
    modifier: Modifier = Modifier,
    stock: Int,
    shippingInformation: String,
){
    val stockLabel : String = if(stock > 1) "unités" else "unité"
    Card(modifier = modifier){
        Column(modifier = Modifier.padding(16.dp)){
            Text(
                text = "Disponibilité",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Stock : $stock $stockLabel",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "$shippingInformation",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Composable
fun ProductImage(
    modifier: Modifier = Modifier,
    productTitle: String,
){
    Image(
        modifier = modifier,
        painter = painterResource(id = android.R.drawable.ic_menu_gallery),
        contentDescription = "Image du produit $productTitle",
    )
}

@Composable
fun ProductHeader(
    modifier:Modifier = Modifier,
    title: String,
    brand: String,
    category: String
){
    Column(modifier = modifier){
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
        Text(text = brand, style = MaterialTheme.typography.titleMedium)
        Text(text = category, style = MaterialTheme.typography.bodyMedium)
    }
}


@Composable
fun ProductPriceCard(
    modifier: Modifier = Modifier,
    price: Double,
    discountPercentage: Double,
){
    Card(modifier = modifier){
        Column(modifier = Modifier.padding(16.dp)){
            Text(
                text = "$price €",
                style= MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "Remise : $discountPercentage %",
                style= MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun ProductRating(
    rating: Double,
    modifier: Modifier = Modifier
){
    Row(modifier = modifier){
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Note du produit"
        )
        Text(
            text = "$rating / 5",
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}


@Composable
fun ProductDescription(
    modifier: Modifier = Modifier,
    description : String
){
    Column(modifier = modifier){
        Text(
            text = "Description",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}


@Composable
fun ProductWarrantyField(
    warrantyInformation: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = warrantyInformation,
        onValueChange = {},
        readOnly = true,
        label = {
            Text(text = "Garantie")
        },
        modifier = modifier
    )
}

@Composable
fun AddToCartButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,
        modifier = modifier
    ){
        Text(text = "Ajouter au panier")
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview(){
    ProductExplorerTheme{
        ProductDetailScreen(
            product = sampleProduct(),
            onAddToCartClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductOutOfStockDetailScreenPreview(){
    ProductExplorerTheme{
        ProductDetailScreen(
            product = sampleProductOutOfStock(),
            onAddToCartClick = {}
        )
    }
}


