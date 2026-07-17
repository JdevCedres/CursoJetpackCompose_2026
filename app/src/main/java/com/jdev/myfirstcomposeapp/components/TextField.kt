package com.jdev.myfirstcomposeapp.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@Composable
fun MyTextFieldParent(modifier: Modifier = Modifier) {
    var user by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        MyTextField(user = user) { user = it }
        MySecondTextField(value = value) { value = it }
        MyAdvanceTextField(value = value) { value = it }
        MyPasswordTextField(value = value) { value = it }
        Spacer(Modifier.height(20.dp))
        MyOutlinedTextField(value = value) { value = it }
        LeadingIconAndTrailingIcon(value = value) { value = it }
        SupportingTextIsError()

    }
}

@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {

    TextField(
        user,
        onValueChange = { onUserChange(it) },
        readOnly = user.isEmpty() // -> bloquea y no deja escribir si no está lleno en este caso
    )
}

@Composable
fun MySecondTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value,
        onValueChange = { onValueChange(it) },
        placeholder = { // -> es un composable puedes hacer lo que quieras
            Text("Usuario")
        },
        label = { Text("Jose") }) //-> es un label se por encima de placeholder, si fuera solo ocuparía todo el espacio
}


@Composable
fun MyAdvanceTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value, onValueChange = {
        if (it.contains("e")) {
            onValueChange(it.replace("e", ""))
        } else {
            onValueChange(it)
        }

    })
}

@Composable
fun MyPasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var passwordHidden: Boolean by remember { mutableStateOf(true) }
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text("Introduce tu contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(
                text = if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = Modifier.clickable { passwordHidden = !passwordHidden })
        }
    )
}

@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(value = value, onValueChange = { onValueChange(it) })

    //  BasicTextField(value = value, onValueChange = {onValueChange(it)})
}

// Leading Icon y Trailing

@Composable
fun LeadingIconAndTrailingIcon(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text("Buscar") },
        // LeadingIcon: icono a la IZQUIERDA del campo
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Buscar")
        },
        // TrailingIcon: icono a la DERECHA del campo (útil para borrar o mostrar contraseña)
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Clear, contentDescription = "Borrar")
                }
            }
        }
    )
}


// SupportingText e isError

@Composable
fun SupportingTextIsError() {
    var nombre by remember { mutableStateOf("") }
    val hayError = nombre.isEmpty()

    OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") },
        // isError: pone el borde del label en rojo
        isError = hayError,
        // SupportingText: texto pequeño debajo del campo
        // útil para mensajes de error o ayuda
        supportingText = {
            if (hayError){
                Text("El nombre no puede estar vacío", color = MaterialTheme.colorScheme.error)
            }else {
                Text("${nombre.length}/50 caracteres", color = Color.Gray)
            }
        }
    )
}










