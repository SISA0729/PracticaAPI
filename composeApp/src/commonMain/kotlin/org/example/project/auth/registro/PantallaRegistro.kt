package org.example.project.auth.registro

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.project.common.componentes.CtextField
import org.example.project.estilos.BotonHeight

@Composable
fun PantallaRegistro(
    navController: NavController,
    modifier: Modifier = Modifier,
    uiState: PantallaRegistroState,
    onUsernameChange: (String) -> Unit,
    onCorreoChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                color = if (isSystemInDarkTheme()){
                    MaterialTheme.colors.background
                }else{
                    MaterialTheme.colors.surface
                }
            )
            .padding(
                start = 18.dp,
                end = 18.dp,
                top = 100.dp,
                bottom = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Crear cuenta",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E88E5),
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(bottom = 10.dp)
        )


        CtextField(
            value = uiState.username,
            onValueChange = onUsernameChange,
            keyboardType = KeyboardType.Text,
            placeholderText = "Usuario"

        )

        CtextField(
            value = uiState.correo,
            onValueChange = onCorreoChange,
            keyboardType = KeyboardType.Email,
            placeholderText = "Correo"
        )

        CtextField(
            value = uiState.password,
            onValueChange = onPasswordChange,
            keyboardType = KeyboardType.Password,
            isPassswordTextField = true,
            placeholderText = "Contraseña"
        )


        Button(
            onClick = {

            },
            modifier = modifier
                .fillMaxWidth()
                .height(BotonHeight),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
            ),
            shape = MaterialTheme.shapes.medium
        ){
            Text(text = "Registrarse")
        }

        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "¿Ya tienes una cuenta?",
                    color = if (isSystemInDarkTheme()) Color.White else MaterialTheme.colors.onSurface,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.width(5.dp))

                ClickableText(
                    text = AnnotatedString(
                        "Inciar Sesión",
                        spanStyle = SpanStyle(
                            color = Color.Blue,
                            textDecoration = TextDecoration.None
                        )
                    ),
                    onClick = {
                        navController.navigate("inicio")
                    }
                )
            }
        }
    }
}
