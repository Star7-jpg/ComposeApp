package com.example.composeapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.ui.FactComposable
import com.example.composeapp.ui.FactsViewModel
import com.example.composeapp.ui.TextComponent
import com.example.composeapp.ui.TextWithShadow
import com.example.composeapp.ui.TopBar

@Composable
fun WelcomeScreen(username: String?, animalSelected: String?) {
    println("==============Inside+WelcomeScreen")
    println("==============$username and $animalSelected")
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar(value = "Bienvenido $username \uD83D\uDE0D")

            TextComponent(textValue = "¡Gracias por compartir su información!", textSize = 24.sp)
            
            Spacer(modifier = Modifier.size(60.dp))

            val finalText = if (animalSelected == "Cat") "Eres un amante de los gatos \uD83D\uDC36" else "Eres un amante de los perros \uD83D\uDC36"

            TextWithShadow(value = finalText)

            val factsViewModel : FactsViewModel = viewModel()

            FactComposable(
                value = factsViewModel.generateRandomsFacts(animalSelected!!)
            )

        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen("username", "animalSelected")
}