package org.example.project


import org.example.project.estilos.AtlasAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import org.example.project.navigation.NavegacionApp

@Composable
@Preview
fun App() {
    AtlasAppTheme {
        NavegacionApp()
    }
}
