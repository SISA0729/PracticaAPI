package org.example.project.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.auth.inicio.PantallaInicio
import org.example.project.auth.inicio.PantallaInicioState
import org.example.project.auth.registro.PantallaRegistro
import org.example.project.auth.registro.PantallaRegistroState
import androidx.compose.animation.*
import org.example.project.aplicacion.Empezar
import org.example.project.aplicacion.PantallaAPI


@Composable
fun NavegacionApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "empezar") {
        composable("empezar",
            enterTransition = {
                scaleIn(initialScale = 0.8f) + fadeIn()
            },
            exitTransition = {
                scaleOut(targetScale = 1.2f) + fadeOut()
            }
        ) {
            Empezar(
                navController = navController
            )
        }
        composable("inicio",
            enterTransition = {
                scaleIn(initialScale = 0.8f) + fadeIn()
            },
            exitTransition = {
                scaleOut(targetScale = 1.2f) + fadeOut()
            }
        ) {
            PantallaInicio(
                navController = navController,
                uiState = PantallaInicioState(),
                onUsernameChange = {},
                onPasswordChange = {}
            )
        }
        composable("registro",
            enterTransition = {
                scaleIn(initialScale = 0.8f) + fadeIn()
            },
            exitTransition = {
                scaleOut(targetScale = 1.2f) + fadeOut()
            }

            ) {
            PantallaRegistro(
                uiState = PantallaRegistroState(),
                navController = navController,
                onUsernameChange = { },
                onCorreoChange = {  },
                onPasswordChange = { }
            )
        }
        composable("api",
            enterTransition = {
                scaleIn(initialScale = 0.8f) + fadeIn()
            },
            exitTransition = {
                scaleOut(targetScale = 1.2f) + fadeOut()
            }

        ) {
            PantallaAPI(
                navController = navController,
            )
        }
    }
}