package com.jdev.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
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


@Composable
fun MyPracticeTextField(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        Buscar(value = value) { value = it }
        OutlineTextFieldConIcono(value = value) { value = it }
    }

}

// Ejercicio 1 - Tu primer TextField
@Composable
fun Buscar(value: String, onValueChange: (String) -> Unit) {
    val hayError = value.isEmpty()
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Buscar Pastilla") },
        isError = hayError,
        supportingText = {
            if (hayError) {
                Text("El nombre no puede estar vacío", color = MaterialTheme.colorScheme.error)
            } else {
                Text("Buscando...", color = Color.Gray)
            }
        }
    )
}

// Ejercicio 2 - OutlineTextField con icono de borrar
@Composable
fun OutlineTextFieldConIcono(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Mensaje") },
        modifier = Modifier,
        trailingIcon = {
            if (value.isNotEmpty()) {
                Icon(
                    Icons.Default.Clear,
                    contentDescription = "Borrar",
                    modifier = Modifier.clickable { onValueChange("") })
            }
        }
    )
}