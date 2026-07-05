package com.jdev.myfirstcomposeapp.components.layout

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Red)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center
        ) {
            Text("Hola, Hola, Hola, Hola, Hola")
        }
    }
}

@Composable
fun MyBox1(){
    Box(modifier = Modifier
        .size(200.dp)
        .background(Color(0xFFE3F2FD)),
        contentAlignment = Alignment.Center // Todos los hijos se centran
    ){
        Text("Hola")
        Text("Mundo") // También centrado, encima del anterior
    }
}

/**
 *  Todos los valores de Alignment disponible
 *  Alignment.TopStart -> arriba a la izquierda
 *  Alignment.TopCenter -> arriba al centro
 *  Alignment.TopEnd -> arriba a la derecha
 *  Alignment.CenterStart -> centro izquierda
 *  Alignment.Center -> centro (el más usado)
 *  Alignment.CenterEnd -> centro derecha
 *  Alignment.BottomStart -> abajo a la izquierda
 *  Alignment.BottomCenter -> abajo al centro
 *  Alignment.BottomEnd -> // abajo a la derecha
 */


// Modifier.align(): Alinear CADA hijo individualmente
//Cuando quieres que cada elemento hijo esté en un lugar distinto, usas Modifier.align() en cada hijo
//por separado. Esto sobreescribe el contentAlignment del Box solo para ese elemento específico

@Composable
fun MyBox2(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ){
        Text(
            text = "Arriba a la izquierda",
            modifier = Modifier.align (Alignment.TopStart)
        )
        Text(
            text = "Centro",
            modifier = Modifier.align (Alignment.Center)
        )
        Text(
            text = "Abajo derecha",
            modifier = Modifier.align (Alignment.BottomEnd)
            /**
             * IMPORTANTE: Modifier.align() SOLO funciona dentro de un Box. No puedes usarlo dentro
             * de un Column o un Row -- para esos layouts hay otros operadores
             */
        )
    }
}

/**
 *  BOX con tamaño: fillMaxSize vs size fijo
 *
 *  Por defecto, Box ocupa el tamaño mínimo necesario para contener a sus hijos. Para que ocupe más espacio
 *  necesitas decírselo con un Modifier
 */



@Composable
fun MyBox3(){
    // Box que ocupa toda la pantalla
    Box(modifier = Modifier.fillMaxSize())
    // Box que ocupa todo el ancho pero solo el alto necesario
    Box(modifier = Modifier.fillMaxWidth())
    // Box de tamaño fijo
    Box(modifier = Modifier.width(300.dp).height(150.dp))
}

// Casos de uso reales: cuándo usar Box

// Imagen con texto superpuesto
@Composable
fun ImagenConEtiqueta(){
    Box(
        modifier = Modifier.size(200.dp)
    ){
        // Capa 1 (debajo): la imagen de fondo
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1565C0)) // Simula una imagen
        )
        // Capa 2 (encima): el texto sobre la imagen
        Text(
            text = "Paracetamol",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(12.dp)
        )
    }
}

// Badge (indicador) encima de un icono

@Composable
fun IconoConBadge(cantidadPastillas: Int){
    Box(modifier = Modifier.size(48.dp)){
        // Capa 1 (debajo): el icono
        Box(
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.Center)
                .background(Color.Gray, CircleShape)
        )
        // Capa 2 (encima): el badge con la cantidad
        if (cantidadPastillas > 0){
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.TopEnd)
                    .background(Color.Red, CircleShape),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "$cantidadPastillas",
                    color = Color.White,
                    fontSize = 10.sp
                )
            }
        }
    }
}


