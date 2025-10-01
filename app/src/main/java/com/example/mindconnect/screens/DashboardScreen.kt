package com.example.mindconnect.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle

@Composable
fun DashboardScreen() {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Fondo blanco
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(16.dp)
        ) {
            // Campo de texto para Email
            EmailInputField(email) { email = it }

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto para Contraseña
            PasswordInputField(password) { password = it }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de Ingresar
            Button(
                onClick = { /* Handle login action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)), // Verde
                shape = MaterialTheme.shapes.small // Esquinas redondeadas
            ) {
                Text("Ingresar", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Texto "Olvido su clave"
            Text(
                text = "Olvido su clave",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Blue,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }

        // Botón de Registrarse al fondo
        Button(
            onClick = { /* Handle register action */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter)
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)), // Mismo verde
            shape = MaterialTheme.shapes.small // Esquinas redondeadas
        ) {
            Text("Registrarse", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun EmailInputField(value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {
    Column {
        Text("Email", color = Color.Gray, style = TextStyle(fontWeight = FontWeight.Bold))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .border(1.dp, Color.Gray) // Borde gris
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    innerTextField()
                }
            }
        )
    }
}

@Composable
fun PasswordInputField(value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {
    Column {
        Text("Contraseña", color = Color.Gray, style = TextStyle(fontWeight = FontWeight.Bold))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .border(1.dp, Color.Gray) // Borde gris
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    innerTextField()
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    MaterialTheme {
        DashboardScreen()
    }
}



