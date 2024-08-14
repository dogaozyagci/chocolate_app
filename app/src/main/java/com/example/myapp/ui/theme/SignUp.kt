package com.example.myapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpView(navController: NavHostController) {
    val auth = FirebaseAuth.getInstance()
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF1B2B30)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Kayıt Ol!",
                fontSize = 44.sp,
                color = Color(0xFFEECB0F),
                modifier = Modifier.padding(bottom = 32.dp),
                fontFamily = FontFamily.Cursive
            )
            OutlinedTextField(
                value = username,
                onValueChange = { newValue -> username = newValue },
                label = { Text("Kullanıcı Adı", color = Color(0xFFEECB0F), fontFamily = FontFamily.Serif) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFEECB0F),
                    unfocusedBorderColor = Color(0xFFEECB0F),)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { newValue -> email = newValue },
                label = { Text("E-mail", color = Color(0xFFEECB0F), fontFamily = FontFamily.Serif) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFEECB0F),
                    unfocusedBorderColor = Color(0xFFEECB0F),)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { newValue -> password = newValue },
                label = { Text("Şifre", color = Color(0xFFEECB0F), fontFamily = FontFamily.Serif) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFEECB0F),
                    unfocusedBorderColor = Color(0xFFEECB0F),)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { newValue -> confirmPassword = newValue },
                label = { Text("Şifre", color = Color(0xFFEECB0F), fontFamily = FontFamily.Serif) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFEECB0F),
                    unfocusedBorderColor = Color(0xFFEECB0F),)
            )
            Spacer(modifier = Modifier.height(26.dp))
            Button(
                onClick = {
                    if (password == confirmPassword) {
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    navController.navigate("login") {
                                        popUpTo("signup") { inclusive = true }
                                    }
                                } else { }
                            }
                    } else { }
                          },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEECB0F)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Kayıt Ol",
                    color = Color(0xFF1B2B30),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Serif
                )
            }
            Spacer(modifier = Modifier.height(80.dp))
            TextButton(onClick = { navController.navigate("login") }) {
                Text("Zaten hesabın var mı? Giriş Yap.", color = Color(0xFFEECB0F), fontFamily = FontFamily.Serif)
            }
        }
    }
}