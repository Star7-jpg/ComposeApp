package com.example.composeapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.data.UserDataUiEvents
import com.example.composeapp.ui.TextComponent
import com.example.composeapp.ui.TextFieldComponent
import com.example.composeapp.ui.TopBar
import com.example.composeapp.ui.UseInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UseInputViewModel) {
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
                textValue = "¡Esta app mostrará una página detallada basada en una entrada proveída por ti!",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UseInputViewModel())
}