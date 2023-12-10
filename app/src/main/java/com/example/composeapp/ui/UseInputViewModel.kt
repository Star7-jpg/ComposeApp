package com.example.composeapp.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composeapp.data.UserInputScreenState

class UseInputViewModel : ViewModel() {
    var uiState = mutableStateOf(UserInputScreenState())
}