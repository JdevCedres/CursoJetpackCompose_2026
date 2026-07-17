package com.jdev.myfirstcomposeapp.components



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview



// Prácticas Text

// Ejercicio 1 - Valoración de tamaño y peso
@Preview(showBackground = true)
@Composable
fun EscalaTipografia(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text("displaySmall", style = MaterialTheme.typography.displaySmall)
        Text("headlineMedium", style = MaterialTheme.typography.headlineMedium)
        Text("titleLarge", style = MaterialTheme.typography.titleLarge)
        Text("bodyLarge", style = MaterialTheme.typography.bodyLarge)
        Text("labelMedium", style = MaterialTheme.typography.labelMedium)
    }
}

// Ejercicio 2 - Texto con maxlines y overflow


@Composable
fun DescriptionPastilla(nombre: String, description: String, modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            nombre,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            description,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            color = Color.Gray
        )
    }

}

// Ejercicio 3 - TextDecoration con estado
/**
@Composable
fun ItemTarea(texto: String, completada: Boolean, modifier: Modifier) {
    var completada by remember { mutableStateOf(true) }
    Column(modifier = modifier) {
        Row() {
            if (completada) {
                Text(texto)
            } else {
                Text(texto, textDecoration = TextDecoration.LineThrough, color = Color.Gray)
            }
        }
        Button({completada = !completada}, modifier.fillMaxWidth()) {
            Text("Completar")
        }
    }

}
*/

// resultado mentor

// Versión STATELESS (recibe el estado desde fuera)
@Composable
fun ItemTarea(
    texto: String,
    completada: Boolean,
    onCompletadaChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = texto,
            textDecoration = if (completada) TextDecoration.LineThrough
            else TextDecoration.None,
            color = if (completada) Color.Gray else Color.Black
        )
        Button(
            onClick = { onCompletadaChange(!completada) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (completada) "Deshacer" else "Completar")
        }
    }
}

// Versión STATEFUL (gestiona su propio estado)
@Composable
fun ItemTareaStateful(texto: String, modifier: Modifier = Modifier) {
    var completada by remember { mutableStateOf(false) }
    ItemTarea(
        texto = texto,
        completada = completada,
        onCompletadaChange = { completada = it },
        modifier = modifier
    )
}




















