package com.jdev.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// Ejercicio 1- Column básico

@Preview(showBackground = true)
@Composable
fun ListaSimple() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Ibuprofeno")
        Text("Paracetamol")
        Text("Tramadol")
        Text("Aspirina")
    }
}

// Ejercicio 2 -- Alineación horizontal

@Composable
fun CabeceraCentrada() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("Pastillero", fontSize = 16.sp)
        Text("recordatorio diario", fontSize = 10.sp)
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray
        )
    }
}

// Ejercicio 3 -- Arrangement en acción


@Composable
fun ColumnTop() {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        Arrangement.Top
    ) {
        Text("Primero")
        Text("Segundo")
        Text("Tercero")
    }
}

@Composable
fun ColumnCenter() {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        Arrangement.Center
    ) {
        Text("Primero")
        Text("Segundo")
        Text("Tercero")
    }
}


@Composable
fun ColumnSpaceBetween() {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        Arrangement.SpaceBetween
    ) {
        Text("Primero")
        Text("Segundo")
        Text("Tercero")
    }
}

// Ejercicio 4 -- weight  para ocupar espacio restante

@Preview(showBackground = true)
@Composable
fun PantallaCompleta() {
    Column(modifier = Modifier.fillMaxSize()) {

        Text("Mis Pastillas")   // ocupa 1 línea
        Text("Ibuprofeno")      // ocupa 1 línea
        Text("Aspirina")        // ocupa 1 línea

        // Este Spacer invisible se "infla" y ocupa
        // todo el espacio que queda libre
        Spacer(modifier = Modifier.weight(1f))

        // El botón queda empujado hasta el fondo
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text("Añadir pastilla")
        }
    }


}
