package com.example.myapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.myapp.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen() {
    val auth = FirebaseAuth.getInstance()
    val currentUser = auth.currentUser
    val email = currentUser?.email ?: "Email bulunamadı"


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF1B2B30)
        // 0xFF315154 logo renk
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxWidth().background(
                    //Color(0x8F315159)
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF635404),
                            Color(0x8F315159),
                            Color(0x8F315159),
                            Color(0xFF1B2B30),
                        )
                    )

                ), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top)
            {
                Spacer(modifier = Modifier.height(32.dp))
                Row {
                    Spacer(modifier = Modifier
                        .height(8.dp)
                        .width(26.dp))
                    Image(
                        painter = painterResource(id = R.drawable.seyyahcikolaatlogo),
                        contentDescription = "Profile Icon",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "Merhaba",
                            color = Color(0xFFEECB0F),
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif
                        )
                        Spacer(modifier = Modifier.height(3.dp).width(5.dp))
                        Text(
                            text = "$email",
                            color = Color(0xFFEECB0F),
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(5f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "༺ Geçmiş Siparişlerim ༻",
                        color = Color(0xFFEECB0F),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif
                    )
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
                }
            }
        }
    }
}









