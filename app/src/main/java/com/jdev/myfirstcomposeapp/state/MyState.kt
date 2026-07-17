package com.jdev.myfirstcomposeapp.state

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyState(modifier: Modifier) {
    var number by rememberSaveable { mutableIntStateOf(0) }
    Column {
        Text("Pulsame: $number", modifier.clickable { number += 1 })
        Text("Pulsame: ", modifier.clickable { number += 1 })

    }
}
/**
 * Para cambiar las vistas tenemos que utilizar los estados, compose no cambia como si fuera una variable
 * cambia todo su estado, pero cambia el estado de lo que se modifica lo demas no. En el ejemplo vemos que el
 * lo que está con mutableStateOf si cambia lo otro no .
 */


// Por el ciclo de vida de la app, cuando rotamos la pantalla desaparece todos los cambios hecho, porque el ciclo de vida
// muere y se vuelve a recrear, para que eso no pase utilizamos rememberSaveable(), se utiliza el by o = en
// var number by -> state property y como dije antes es igual utilizar by que =


/**
 *  STATE HOSTING
 */

@Composable
fun StateHostingExample(modifier: Modifier){
    var number by rememberSaveable { mutableIntStateOf(0) } // Una única fuente de la verdad, porque el estado se necesita el mismo para los dos y la pasamos por parámetro
    Column(modifier = modifier) {
        StateExample1(number){number += 1} // -> pasamos el state y la lambda por fuera, porque es el último parámetro es una lambda {number += 1}
        StateExample1(number){number += 1}
    }
}

@Composable
fun StateExample1(number: Int, onClick: () -> Unit) {
    Text("Pulsame: $number", modifier = Modifier.clickable{onClick()}) // Para ejecutar la lambda siempre con  parentisis es onClick()
}

@Composable
fun StateExample2(number: Int, onClick: () -> Unit) {
    Text("Pulsame: $number", modifier = Modifier.clickable{onClick()})
}

// Se trata de que toda la fuente de la verdad esté en el padre de todo,en este ejemplo en la función StateHostingExample()


/**
 *  Ejemplos Reales
 */


// Pastilla marcable como tomada.

@Composable
fun TarjetaPastillaMarcable(nombre: String, hora: String, modifier: Modifier){
    var tomada by remember{ mutableStateOf(false) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                if (tomada) Color(0xFFE8F5E9) else Color.White,
                RoundedCornerShape(12.dp)
            )
            .clickable{tomada = !tomada} // Alterna entre true y false
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(nombre,
                color = if(tomada) Color.Gray else Color.Black
                )
            Text(text = hora, color = Color(0xFF1565C0))
        }
        Text(
            text = if (tomada) "Tomada" else "Pendiente",
            color = if (tomada) Color(0xFF2E7D32) else Color(0xFFB71C1C)
        )
    }

}





