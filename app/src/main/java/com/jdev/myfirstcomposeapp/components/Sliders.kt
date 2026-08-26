package com.jdev.myfirstcomposeapp.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color


import androidx.compose.ui.unit.dp

// Slider común
@Composable
fun MySlider(modifier: Modifier = Modifier) {
    var myValue by remember { mutableFloatStateOf(0.5f) }
    Column(modifier = modifier.padding(horizontal = 30.dp)) {
        Slider(
            value = myValue,
            onValueChange = { myValue = it },
            enabled = true,
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                disabledThumbColor = Color.DarkGray,
                activeTrackColor = Color.Red,
                disabledActiveTrackColor = Color.DarkGray,
                activeTickColor = Color.Blue,
                disabledActiveTickColor = Color.DarkGray,
                inactiveTickColor = Color.Gray,
                inactiveTrackColor = Color.Blue,
                disabledInactiveTickColor = Color.Gray,
                disabledInactiveTrackColor = Color.DarkGray
            )
        )
        Text(myValue.toString())
    }
}

// Slider Avanzado

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySliderAdvance(modifier: Modifier = Modifier) {
    var example by remember { mutableStateOf(":(") }
    val state = remember {
        SliderState(
            value = 5f,
            valueRange = 0f..10f,
            steps = 9,
            onValueChangeFinished = {
                example = "FELIZ"
            } // cambia al soltar el ratón, normalmento salta dialogo
        )
    }
    val colors = SliderDefaults.colors(
        thumbColor = Color.Red,
        disabledThumbColor = Color.DarkGray,
        activeTrackColor = Color.Red,
        disabledActiveTrackColor = Color.DarkGray,
        activeTickColor = Color.Blue,
        disabledActiveTickColor = Color.DarkGray,
        inactiveTickColor = Color.Gray,
        inactiveTrackColor = Color.Blue,
        disabledInactiveTickColor = Color.Gray,
        disabledInactiveTrackColor = Color.DarkGray
    )

    Column(modifier = modifier.padding(horizontal = 32.dp)) {
        Slider(
            state,
            colors = colors,
            thumb = { Text("J") }) // el thumb es un composable puede hacer lo que quieras igual que track
        Text(example)
    }
}

// Slider con rangos

@SuppressLint("DefaultLocale")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {
    var state = remember {
        RangeSliderState(
            activeRangeStart = 3f,
            activeRangeEnd = 6f,
            valueRange = 0f..10f,
            steps = 8
        )
    }

    val colors = SliderDefaults.colors(
        thumbColor = Color.Red,
        disabledThumbColor = Color.DarkGray,
        activeTrackColor = Color.Red,
        disabledActiveTrackColor = Color.DarkGray,
        activeTickColor = Color.Blue,
        disabledActiveTickColor = Color.DarkGray,
        inactiveTickColor = Color.Gray,
        inactiveTrackColor = Color.Blue,
        disabledInactiveTickColor = Color.Gray,
        disabledInactiveTrackColor = Color.DarkGray
    )

    Column(modifier = modifier.padding(horizontal = 32.dp)) {
        RangeSlider(
            state, colors = colors,
            startThumb = {
                Box(
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(String.format("%.1f", it.activeRangeStart))
                }
            },
            endThumb = {
                Box(Modifier.size(50.dp).clip(CircleShape).background(Color.Yellow), contentAlignment = Alignment.Center){
                    Text(String.format("%.1f", it.activeRangeEnd))
                }
            }

        )
    }
}















