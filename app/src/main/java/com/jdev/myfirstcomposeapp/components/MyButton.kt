package com.jdev.myfirstcomposeapp.components


import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        Button(onClick = {Log.i("jdev", "Botón pulsado")},
            enabled = false, // Activado o desactivado
            shape = RoundedCornerShape(30), // redondear las esquinas si pongo 10 es porecentaje 10.dp son puntos
            border = BorderStroke(2.dp, Color.Red), // Borde siempre hay que ponerle el ancho y el color
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red, // Color del contenido
                containerColor = Color.White, // Color de contenedor
                disabledContentColor = Color.Yellow, // Es lo mismo que content color pero cuando está deshabilitado
                disabledContainerColor = Color.Cyan // igual contenedor color deshabilitado
            )

            ) {
            Text("Pulsame")
        }
        OutlinedButton(
            {},
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Blue,
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.DarkGray
            )
            ) {
            Text("OutlinedButton")
        }
        TextButton(onClick = {}) {
            Text("TextButton")
            // Tiene los mismos modificadores y atributos, todos los composables

        }
        ElevatedButton(onClick = {}, elevation = ButtonDefaults.elevatedButtonElevation()) {
            Text("elevatedButton")
            // Tiene los mismos modificadores y atributos, todos los composables
            // Podemos modificar todos sus parámetros
        }
        FilledTonalButton(onClick = {}) {
            // En realidad es un button normal no tiene mucho sentido, la diferencia está en el color que tiene
        }
    }
}