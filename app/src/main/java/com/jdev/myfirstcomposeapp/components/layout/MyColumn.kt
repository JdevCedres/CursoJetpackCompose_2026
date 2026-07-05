package com.jdev.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)

// sintaxis Básica
@Composable
fun MyColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), // Si es más alto que el espacio disponible, el scroll hay que activarlo
        verticalArrangement = Arrangement.Center, // Como se distribuyen los hijos en vertical
        horizontalAlignment = Alignment.CenterHorizontally // Como se alinean en horizontal
        // Modifier.weight -> ocupa el espacio restante son float por lo que se usa 1f...
    ) {
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Yellow))
        Text("Hola 3", modifier = Modifier.background(Color.Blue))
        Text("Hola 4", modifier = Modifier.background(Color.Cyan))
    }

}

/**
 *  COLUMN
 *
 *  Es un contendor que coloca sus elementos hijos "Uno debajo del otro, en vertical" -- prácticamente
 *  cualquier pantalla que tenga elementos apilados verticalmente usa un Column
 */


// Casos de uso reales
// Pantalla típica con cabecera, contenido y botón
@Preview
@Composable
fun PantallaPastillero(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Cabecera
        Text(text = "Mis pastillas", fontSize = 24.sp)

        // Contenido (ocupa todo el espacio disponible)
        Column(modifier = Modifier.weight(1f)) {
            Text("Paracetamol -- 08:00")
            Text("Ibuprofeno -- 14:00")
            Text("Omeprazol -- 20:00")
        }
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Añadir pastilla")
        }
    }
}

// Tarjeta de pastillas con datos organizados

@Composable
fun TarjetaPastilla(nombre: String, dosis: String, hora: String, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(nombre, fontSize = 18.sp)
        Text(dosis, color = Color.Gray)
        Text("Tomar a las $hora", color = Color(0xFF1565C0))
    }
}


