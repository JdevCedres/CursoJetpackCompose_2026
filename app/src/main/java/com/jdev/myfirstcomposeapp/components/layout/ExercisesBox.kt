package com.jdev.myfirstcomposeapp.components.layout


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// Ejercicio 1 -- Box básico con fondo

@Composable
fun CajaAzul() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color(0xFFE3F2FD))
    ) {
        Text(
            text = "Pastillero",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

// Ejercicio 2 -- Tres textos en posiciones distintas

@Composable
fun EsquinasBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(
            text = "Esquina superior izq",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        )
        Text(
            text = "Centro",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
        )
        Text(
            text = "esquina inferior der",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )
    }
}

// Ejercicio 3 -- Imagen simulada con texto superpuesto


@Composable
fun ExampleBannerPastillas() {
    Column() {
        BannerPastilla("Ibuprofeno", Color.Green)
        BannerPastilla("Tramadol", Color.Red)
        BannerPastilla("Paracetamol", Color.Cyan)
    }
}

@Composable
fun BannerPastilla(nombre: String, color: Color) {
    Box(
        modifier = Modifier
            .size(width = 300.dp, 150.dp)
            .background(color)

    ) {
        Text(
            text = nombre,
            color = Color.White,
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.BottomEnd)

        )
    }

}

// Ejercicio 4 --Badge encima de un contador

@Preview
@Composable
fun ExampleContadorPastillas() {
    ContadorPastillas(4)
}


@Composable
fun ContadorPastillas(cantidad: Int ) {
    Box(modifier = Modifier.size(60.dp)) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.Center)
                .background(Color.Gray, CircleShape)

        )

        if (cantidad > 0) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(Color.Red, CircleShape),
                contentAlignment = Alignment.TopEnd
            ) {
                Text("$cantidad",
                    color = Color.White,
                    modifier = Modifier.align (Alignment.Center))
            }
        }
    }

}