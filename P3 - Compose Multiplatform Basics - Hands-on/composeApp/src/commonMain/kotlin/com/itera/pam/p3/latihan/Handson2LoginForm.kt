package com.itera.pam.p3.latihan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

// Hands-on 2: Login Form
// Tugas: Buat form login dengan username, password, dan tombol login.

@Composable
fun LoginForm(onLogin: (String, String) -> Unit) {

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Judul
        Text(
            text = "Login"
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Input username
        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
            },
            label = {
                Text("Username")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // Input password
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Tombol login
        Button(
            onClick = {
                onLogin(username, password)
            }
        ) {
            Text("Login")
        }
    }
}

@Composable
fun Handson2Screen() {
    LoginForm(
        onLogin = { username, password ->
            println("Username: $username")
            println("Password: $password")
        }
    )
}
