package com.example.composeapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.R
import com.example.composeapp.data.UserDataUiEvents
import com.example.composeapp.ui.AnimalCard
import com.example.composeapp.ui.ButtonComponent
import com.example.composeapp.ui.TextComponent
import com.example.composeapp.ui.TextFieldComponent
import com.example.composeapp.ui.TopBar
import com.example.composeapp.ui.UseInputViewModel

@Composable
fun UserInputScreen(
    userInputViewModel: UseInputViewModel,
    showWelcomeScreen: (valuesPair: Pair<String, String>) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar("¡Hola a todos! \uD83D\uDE0A")

            TextComponent(
                textValue = "¡Aprendamos acerca de ti!" ,
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "¡Esta app mostrará una página detallada basada en lo que tú elijas!",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))
            
            TextComponent(textValue = "Nombre", textSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "¿Qué te gusta?", textSize = 18.sp)

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                AnimalCard(image = R.drawable.cat, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Cat")
                AnimalCard(image = R.drawable.dog, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Dog")
            }
            
            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()) {
                ButtonComponent(
                    goToDetailsScreen = {
                        println("=============ComingHere")
                        println("=============${ userInputViewModel.uiState.value.nameEntered } and ${ userInputViewModel.uiState.value.animalSelected }")
                        showWelcomeScreen(
                            Pair(
                                userInputViewModel.uiState.value.nameEntered,
                                userInputViewModel.uiState.value.animalSelected
                            )
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    //UserInputScreen(UseInputViewModel())
}