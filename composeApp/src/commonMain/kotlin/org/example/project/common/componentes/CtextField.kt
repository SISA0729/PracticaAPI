package org.example.project.common.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import org.example.project.estilos.Gray
import org.jetbrains.compose.resources.painterResource
import sisaalpha.composeapp.generated.resources.Res
import sisaalpha.composeapp.generated.resources.mostraricono
import sisaalpha.composeapp.generated.resources.ocultaricono

@Composable
fun CtextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassswordTextField: Boolean = false,
    placeholderText: String = ""

) {

    var PasswordVisible by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = { newText -> onValueChange(newText) },
        modifier = modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.body2,

        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType),

        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = if (isSystemInDarkTheme()){
                MaterialTheme.colors.surface
            }else{
                Gray
            },
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),

        trailingIcon = if (isPassswordTextField) {
            {
                PasswordEyeIcon(
                    isPasswordVisible = PasswordVisible,
                    onPasswordVisibilityToggle = {
                        PasswordVisible = !PasswordVisible
                    }
                )
            }
        }else{
            null
        },

        visualTransformation = if (isPassswordTextField && !PasswordVisible) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },

        shape = MaterialTheme.shapes.medium,

        placeholder = {
            Text(
                text = placeholderText,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
            )
        }

    )

}


@Composable
fun PasswordEyeIcon(
    isPasswordVisible: Boolean,
    onPasswordVisibilityToggle: () -> Unit
) {
    IconButton(onClick = onPasswordVisibilityToggle) {
        if (isPasswordVisible) {
            Image(painter = painterResource(Res.drawable.mostraricono), contentDescription = null)
        } else {
            Image(painter = painterResource(Res.drawable.ocultaricono), contentDescription = null)
        }
    }
}

