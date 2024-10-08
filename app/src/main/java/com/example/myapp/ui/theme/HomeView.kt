package com.example.myapp.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeView() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF131E22),
            ) {
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home",
                        tint = Color(0xFFEECB0F),
                        modifier = Modifier.size(46.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { navController.navigate("profile") }) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "Profile",
                        tint = Color(0xFFEECB0F),
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { navController.navigate("likes") }) {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "favourites",
                        tint = Color(0xFFEECB0F),
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.ExitToApp,
                        contentDescription = "Logout",
                        tint = Color(0xFFEECB0F),
                        modifier = Modifier.size(32.dp)
                    )
                }
               Spacer(modifier = Modifier.weight(1f))
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen() }
            composable("likes") { FavouritesPage() }
            composable("profile") { ProfileScreen() }
        }
    }
}

