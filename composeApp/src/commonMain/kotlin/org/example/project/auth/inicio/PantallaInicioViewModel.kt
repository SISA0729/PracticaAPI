package org.example.project.auth.inicio

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PantallaInicioViewModel: ViewModel() {
    var uiState by mutableStateOf(PantallaInicioState())
        private set

    fun updateUsuario(input: String) {
        uiState = uiState.copy(username = input)
    }
    fun updateCorreo(input: String) {
        uiState = uiState.copy(correo = input)
    }
    fun updateContrasena(input: String) {
        uiState = uiState.copy(password = input)
    }
}

data class PantallaInicioState(
    var username: String = "",
    var correo: String = "",
    var password: String = "",
)