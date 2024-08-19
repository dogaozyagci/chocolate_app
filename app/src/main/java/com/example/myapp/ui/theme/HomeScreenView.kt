package com.example.myapp.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter


data class Product(
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val imageUrl: String = "",
    val isLiked: Boolean = false,
)

@Composable
fun HomeScreen() {
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    val coroutineScope = rememberCoroutineScope()

    suspend fun fetchProducts(): List<Product> {
        return try {
            val result = Firebase.firestore.collection("products").get().await()
            result.map { document ->
                Product(
                    name = document.getString("Başlık") ?: "",
                    description = document.getString("İçerik") ?: "",
                    price = document.getDouble("Ücret") ?: 0.0,
                    imageUrl = document.getString("image") ?: "",
                    isLiked = document.getBoolean("isLiked") ?: false,
                )
            }
        } catch (e: Exception) {
            Log.e("ProductListScreen", "Error fetching products", e)
            emptyList()
        }
    }


    LaunchedEffect(Unit) {
        coroutineScope.launch {
            products = fetchProducts()
            isLoading = false
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF1B2B30)

        ) {

        }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp))
                {
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.wallpaper),
                            contentDescription = "Background Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "  Menü ",
                                color = Color(0xFFEECB0F),
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                            )
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Filled.ShoppingCart,
                                    contentDescription = "ShoppingBox",
                                    tint = Color(0xFFEECB0F)
                                )
                            }

                        }
                    }

                    items(products) { product ->
                        ProductRow(product = product)
                }


            }
        }
    }
}




@Composable
fun ProductRow(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF635404),
                        Color(0x8F315159),
                        Color(0x8F28444B),
                        Color(0xB5121D1C),
                    )
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(12.dp)
    ) {

        Image(
            painter = rememberImagePainter(data = product.imageUrl),
            contentDescription = product.name,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))


        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(
                text = product.name,
                color = Color(0xFFEECB0F),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = product.description,
                color = Color(0xFFEECB0F)
            )

        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(
                text = "Ücret: ${product.price}₺",
                color = Color(0xFFEECB0F)
            )
            Row {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Like",
                        tint = Color(0xFFEECB0F)
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "Shopping",
                        tint = Color(0xFFEECB0F)
                    )
                }
            }
        }
    }
}











