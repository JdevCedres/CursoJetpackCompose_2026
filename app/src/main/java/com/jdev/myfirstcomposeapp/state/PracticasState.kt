package com.jdev.myfirstcomposeapp.state

import android.R
import androidx.compose.material3.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// Ejercicio 1.
/**
 *
 * Crea un Composable Interruptor() con un var encendido by remember { mutableStateOf(false) }
 * . Muestra un Box de 80x80dp cuyo color cambia entre verde y gris según el estado.
 * Debajo, un Button que alterne el estado al pulsar.
 * Pruébalo en la Preview.
 */
@Preview(showBackground = true)
@Composable
fun Interruptor(modifier: Modifier = Modifier) {
    var encendido by remember { mutableStateOf(false) }
    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(color = if (encendido) Color.Gray else Color.Green)
        )
        Spacer(Modifier.weight(1f))
        Button(onClick = { encendido = !encendido }, Modifier.fillMaxWidth()) {
            Text("Cambia color")
        }
    }


}

/**
 * Ejercicio 2 — Contador con límite
 * Crea Contador(maximo: Int) con un estado contador que empiece en 0. Dos botones: '+' que sume 1 (hasta el máximo) y
 * '-' que reste 1 (hasta 0). Muestra el número grande en pantalla y, cuando llegue al máximo, muestra el texto 'Completado'
 * en verde.
 */


@Composable
fun Contador(modifier: Modifier) {
    val max = 10
    var contador by remember { mutableIntStateOf(0) }
    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { if (contador < max) contador += 1 }) {
                Text("+ 1")
            }
            Button(onClick = { if (contador >= 1) contador -= 1 }) {
                Text("- 1")
            }
        }
        Spacer(modifier = Modifier.height(200.dp))

        Text(
            text = if (contador == max) "Completado" else contador.toString(),
            fontSize = 54.sp,
            color = if (contador == max) Color(0xFF2E7D32) else Color.Black
        )

    }

}








