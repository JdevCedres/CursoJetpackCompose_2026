package com.jdev.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 *  Combinando layouts y Spacer
 */
@Composable
fun MyComplexLayout(modifier: Modifier) {
    Text("Tìtulo App",fontSize = 24.sp)
    Spacer(modifier = Modifier.height(24.dp)) //espacio extra antes del contenido
    Column(modifier = modifier ) {
        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Red)
        ) {}
        Spacer(Modifier.height(20.dp)) // Spacer con altura fija (dentro de una columna)
        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Blue)
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(125.dp)
                        .background(Color.Gray)
                )
                {}
                Spacer(Modifier.width(20.dp)) // Spacer con ancho fijo (dentro del Row)
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(185.dp)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                )
                {
                    Text("Hola")
                }
            }
        }
        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Yellow)
        ) {}
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) { Text("Ejemplo")}
    }
}

/**
 *  SPACER: espacio vacío controlado
 *
 *  Es un Composable que ocupa espacio vacío--no muestra nada visible, solo reserva una catidad de
 *  espacio entre elementos
 */

/**
 * Spacer que ocupa todo el espacio restante  (el más poderoso)
 * El uso más poderoso de Spacer es combinarlo con Modifier.weight(1f). Esto hace que el Spacer ocupe
 * todo el espacio sobrante, empujando lo que viene después hacia el extremo del contenedor.
 */
@Composable
fun ExampleSpacerWeight(modifier: Modifier){
    Column(modifier = modifier.fillMaxSize()) {
        Text("Mis pastillas", fontSize = 24.sp)
        Text("Paracetamol - 08:00")
        Text("Ibuprofeno - 12:00")
        // Este Spacer se va a "comer"todo el espacio que sobre
    }


}


