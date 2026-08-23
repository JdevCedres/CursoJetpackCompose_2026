package com.jdev.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MySlider(modifier: Modifier = Modifier) {
    var myValue by remember { mutableFloatStateOf(0f) }
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