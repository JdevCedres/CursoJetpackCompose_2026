package com.jdev.myfirstcomposeapp.components.practicas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

// Ejercicio 1 - Tu primer indicador indeterminado

@Composable
fun PrimerIndicador(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

// Ejercicio 2 - Indicador determinado con valor fijo

@Composable
fun IndicadorDeterminado(modifier: Modifier = Modifier) {
    val progreso by remember { mutableFloatStateOf(0.75f) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(progress = { progreso })
    }
}

// Ejercicio 3 - Mostrar/ocultar según estado

@Composable
fun MostarOcultar(modifier: Modifier = Modifier) {
    var showProgress by remember { mutableStateOf(false) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showProgress) {
            CircularProgressIndicator()
        }


        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            showProgress = !showProgress
        }) {
            Text(if (showProgress) "Ocultar indicador" else "Ver indicador")
        }
    }
}

// Ejercicio 4 - Colores Personalizados

@Composable
fun ColoresPersonalizados(modifier: Modifier = Modifier) {
    val progreso by remember { mutableFloatStateOf(0.5f) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            progress = { progreso },
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

// Ejercicio 5 - Progreso calculado con coerceIn
@Composable
fun ProgresoPasos(
    pasosCompletados: Int,
    pasosTotales: Int,
    modifier: Modifier = Modifier
) {
    val progreso = (pasosCompletados.toFloat() / pasosTotales).coerceIn(0f, 1f)

    LinearProgressIndicator(
        progress = { progreso },
        modifier = modifier.fillMaxWidth()
    )
}

// Ejercicio 6 - Botón deshabilitado

@Composable
fun Formulario(modifier: Modifier = Modifier) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var cargar by remember { mutableStateOf(false) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = user,
            onValueChange = { user = it },
            label = { Text("Usuario") },
            placeholder = { Text("nombre") },
            maxLines = 1
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            placeholder = { Text("password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { cargar = true }, enabled = !cargar) {
            Text(if (cargar) "Cargando..." else "Cargar")

        }
    }
}
// Ejercicio 7 - Circular con tamaño y grosor personalizado.

@Composable
fun CircularPersonal(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(modifier = modifier.size(80.dp), strokeWidth = 8.dp)
    }
}











