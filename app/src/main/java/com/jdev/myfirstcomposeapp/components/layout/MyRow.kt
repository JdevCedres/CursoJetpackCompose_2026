package com.jdev.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyRow(modifier: Modifier) { // Row básico
    Row(modifier = modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceAround,) { // con horizontalArrangement
        Text("Hola1",modifier= Modifier.background(Color.Red).weight(1f))
        Text("Hola2",modifier= Modifier.background(Color.Blue).weight(1f))
        Text("Hola3",modifier= Modifier.background(Color.Cyan).weight(1f))
    }

    // Si nos hiciera falta scroll sería .horizontalScroll(rememberScrollState())
    // Row, es como column, todo lo que hicimos en column vale para row


}