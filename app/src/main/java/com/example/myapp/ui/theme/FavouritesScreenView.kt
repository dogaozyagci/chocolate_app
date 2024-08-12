package com.example.myapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun FavouritesPage() {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.wallpaper),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF1B2B30)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.seyyahcikolaata),
                    contentDescription = "Background Image",
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = "༺ Favorilerim ༻",
                    color = Color(0xFFEECB0F),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif
                )
                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
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
                                RoundedCornerShape(8.dp)
                            )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cikouc),
                            contentDescription = "Image Description",
                            modifier = Modifier
                                .size(150.dp)
                                .padding(12.dp)
                                .clip(RoundedCornerShape(18.dp))
                        )
                        Column(
                            modifier = Modifier
                                .padding(12.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = "Yeşil Kutu",
                                color = Color(0xFFEECB0F),
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Karışık ",
                                color = Color(0xFFEECB0F),

                                )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(
                            modifier = Modifier
                                .padding(12.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = "00/00/24",
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFEECB0F),

                                )
                            Text(
                                text = "Ücret: x ",
                                color = Color(0xFFEECB0F),
                            )
                            Spacer(modifier = Modifier.height(18.dp))
                            Row {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = "Like",
                                        tint = Color(0xFFEECB0F)
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.ShoppingCart,
                                        contentDescription = "Shopping",
                                        tint = Color(0xFFEECB0F)
                                    )
                                }
                            }

                        }
                        Spacer(modifier = Modifier.width(18.dp))

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
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
                                RoundedCornerShape(8.dp)
                            )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cikoiki),
                            contentDescription = "Image Description",
                            modifier = Modifier
                                .size(150.dp)
                                .padding(12.dp)
                                .clip(RoundedCornerShape(18.dp))
                        )
                        Column(
                            modifier = Modifier
                                .padding(12.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = "Kahve Kutu",
                                color = Color(0xFFEECB0F),
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Kahveli ",
                                color = Color(0xFFEECB0F),

                                )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(
                            modifier = Modifier
                                .padding(12.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = "00/00/24",
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFEECB0F),

                                )
                            Text(
                                text = "Ücret: x ",
                                color = Color(0xFFEECB0F),
                            )
                            Spacer(modifier = Modifier.height(18.dp))
                            Row {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = "Like",
                                        tint = Color(0xFFEECB0F)
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.ShoppingCart,
                                        contentDescription = "Shopping",
                                        tint = Color(0xFFEECB0F)
                                    )
                                }
                            }

                        }
                        Spacer(modifier = Modifier.width(18.dp))

                    }
                }

            }

        }
    }

}