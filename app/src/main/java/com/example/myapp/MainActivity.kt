@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp.ui.theme.HomeView
import com.example.myapp.ui.theme.MainPageView
import com.example.myapp.ui.theme.LoginView
import com.example.myapp.ui.theme.MyAppTheme
import com.example.myapp.ui.theme.SignUpView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                MyApp()
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainPageView(navController) }
        composable("login") { LoginView(navController) }
        composable("signup") { SignUpView(navController) }
        composable("homeView") { HomeView() }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppTheme {
        MyApp()
    }
}

