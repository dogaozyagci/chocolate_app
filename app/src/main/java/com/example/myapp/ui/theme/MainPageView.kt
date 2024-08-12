package com.example.myapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavHostController
import com.example.myapp.R

@Composable
fun MainPageView(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF1B2B30)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize().background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF635404),
                            Color(0x8F315159),
                            Color(0x8F28444B),
                            Color(0xB5192928),
                            )
                    )
                )
        )
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.adobetock_512216219_eview),
                contentDescription = "Profile Icon",
                modifier = Modifier
                    .size(130.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(90.dp))
            Text(text = "Hos Geldiniz!",
                fontSize = 64.sp,
                color = Color(0xFFEECB0F),
                fontFamily = FontFamily.Cursive
            )
            Text(text = "Seyyah Çikolata",
                fontSize = 34.sp,
                color = Color(0xFFEECB0F),
                fontFamily = FontFamily.Cursive
            )
            Spacer(modifier = Modifier.height(48.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(
                    onClick = { navController.navigate("login") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier.border(1.dp, Color(0xFFEECB0F), ButtonDefaults.outlinedShape)
                )
                {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "User Icon",
                        tint = Color(0xFFEECB0F)
                    )
                }
                Button(onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier.border(1.dp, Color(0xFFEECB0F), ButtonDefaults.outlinedShape)
                )
                { Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Company Icon",
                    tint = Color(0xFFEECB0F)
                ) }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Tarihe tatlı bir yolculuk",
                fontSize = 18.sp,
                color = Color(0xFFEECB0F),
                fontFamily = FontFamily.Cursive
            )
        }
    }
}

