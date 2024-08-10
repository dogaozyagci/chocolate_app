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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@ExperimentalMaterial3Api
@Composable
fun LoginView() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF213021)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login!",
                fontSize = 24.sp,
                color = Color(0xFFEECB0F),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = { /* Kullanıcı adını yönet */ },
                label = { Text("Username", color = Color(0xFFEECB0F)) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "",
                onValueChange = { /* Şifreyi yönet */ },
                label = { Text("Password", color = Color(0xFFEECB0F)) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { /* Giriş işlemi */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEECB0F)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login",
                    color = Color(0xFF213021),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    )
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = { /* Şifre sıfırlama işlemi */ }) {
                Text("Forgot Password?", color = Color(0xFFEECB0F))
            }
            Spacer(modifier = Modifier.height(80.dp))
            TextButton(onClick = { /* Şifre sıfırlama işlemi */ }) {
                Text("Don't have an account?", color = Color(0xFFEECB0F))
            }
        }
    }
}


