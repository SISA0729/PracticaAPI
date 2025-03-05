package org.example.project.aplicacion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.jetbrains.compose.resources.painterResource
import sisaalpha.composeapp.generated.resources.Res
import sisaalpha.composeapp.generated.resources.atlasinventory

@Composable
fun Empezar(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = if (isSystemInDarkTheme()){
                    MaterialTheme.colors.background
                }else{
                    MaterialTheme.colors.surface
                }
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(contentAlignment = Alignment.Center) {
            Circulo()
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Entra en tu inventario",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E80F8))
        )
        Text(
            text = "Multiples opciones para tu negocio",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Light, color = Color.Gray)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Administra tus tareas pendientes de inventario ",color = if (isSystemInDarkTheme()) Color.White else MaterialTheme.colors.onSurface)
        Text("Recibe alertas de stock y actualizaciones",color = if (isSystemInDarkTheme()) Color.White else MaterialTheme.colors.onSurface)
        Text("Colabora de manera efectiva con tu equipo",color = if (isSystemInDarkTheme()) Color.White else MaterialTheme.colors.onSurface)
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                navController.navigate("inicio")

            },
            colors = ButtonDefaults.buttonColors(Color(0xFF1E80F8)),
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text(text = "Empezar", color = Color.White)
        }
    }
}

@Composable
fun Circulo() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color(0xFF673AB7), shape = CircleShape),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(Res.drawable.atlasinventory),
            contentDescription = "Shoe",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        LabelTag("NEW APP", Color(0xFFFFC107))
    }
}

@Composable
fun LabelTag(text: String, color: Color) {
    Box(
        modifier = Modifier
            .background(color, shape = CircleShape)
            .padding(8.dp)
    ) {
        BasicText(text = text, style = TextStyle(color = Color.Black, fontSize = 12.sp))
    }
}
