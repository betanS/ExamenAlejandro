package com.example.examenalejandro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun OnBoardingScreen(onContinueClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var user by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var errortxt by rememberSaveable { mutableStateOf(" ") }

        Image(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .padding(23.dp),
            painter = painterResource(id = R.drawable.unfrutero),
            contentDescription = "logoFrutas"
        )
        TextField(
            value = user,
            onValueChange = { user = it },
            label = { Text(text = "Enter username", modifier = Modifier.padding(4.dp)) }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Text(text = errortxt,
            color = Color.Red)
        Button (onClick = { if(checkCredentials(user, password)){
            onContinueClicked()
        }else {
            errortxt = "Error en los datos"
        }
        } ) {
            Text("Login")
        }
    }
}

fun checkCredentials(user: String, password: String): Boolean {
    return (user == "usuario" && password == "123456")
}