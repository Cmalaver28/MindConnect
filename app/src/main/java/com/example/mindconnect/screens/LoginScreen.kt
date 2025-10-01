package com.example.mindconnect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindconnect.R
import androidx.compose.foundation.text.ClickableText


@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "MindConnect",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )

        Image(
            painter = painterResource(id = R.drawable.head_flowers), // tu imagen en drawable
            contentDescription = "Mind illustration",
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        )

        Button(
            onClick = { onLoginClick() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)), // verde
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Iniciar sesión", color = Color.White, fontSize = 16.sp)
        }

        ClickableText(
            text = AnnotatedString("Olvidó su clave"),
            onClick = { onForgotPasswordClick() },
            style = LocalTextStyle.current.copy(
                color = Color.Gray,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        )

        OutlinedButton(
            onClick = { onRegisterClick() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Registrarse", color = Color(0xFF2196F3), fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginClick = {},
        onRegisterClick = {},
        onForgotPasswordClick = {}
    )
}
