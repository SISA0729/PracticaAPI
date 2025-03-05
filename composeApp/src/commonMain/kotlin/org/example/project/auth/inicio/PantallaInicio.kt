package org.example.project.auth.inicio

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
import org.jetbrains.compose.resources.painterResource
import sisaalpha.composeapp.generated.resources.Res
import sisaalpha.composeapp.generated.resources.facebook
import sisaalpha.composeapp.generated.resources.gmail
import sisaalpha.composeapp.generated.resources.twitter

@Composable
fun PantallaInicio(
    navController: NavController,
    modifier: Modifier = Modifier,
    uiState: PantallaInicioState,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                color = if (isSystemInDarkTheme()) {
                    MaterialTheme.colors.background
                } else {
                    MaterialTheme.colors.surface
                }
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "ATLAS INVENTORY",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E88E5),
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        CtextField(
            value = uiState.username,
            onValueChange = onUsernameChange,
            keyboardType = KeyboardType.Text,
            placeholderText = "Usuario"
        )
        Spacer(modifier = Modifier.height(16.dp))
        CtextField(
            value = uiState.password,
            onValueChange = onPasswordChange,
            keyboardType = KeyboardType.Password,
            isPassswordTextField = true,
            placeholderText = "Contraseña"
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate("api")
            },
            modifier = modifier
                .fillMaxWidth()
                .height(BotonHeight),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Iniciar Sesión")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "¿No tienes una cuenta?",
                    color = if (isSystemInDarkTheme()) Color.White else MaterialTheme.colors.onSurface,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.width(4.dp))

                ClickableText(
                    text = AnnotatedString(
                        "Regístrate",
                        spanStyle = SpanStyle(
                            color = Color.Blue,
                            textDecoration = TextDecoration.None
                        )
                    ),
                    onClick = {
                        navController.navigate("registro")
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SocialLoginButton(painterResource(Res.drawable.gmail), onClick = {  })
            SocialLoginButton(painterResource(Res.drawable.facebook), onClick = {  })
            SocialLoginButton(painterResource(Res.drawable.twitter), onClick = { })
        }
    }
}

@Composable
fun SocialLoginButton(icon: Painter, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(56.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}
