package com.jdev.myfirstcomposeapp.components

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
import androidx.compose.material3.rememberRangeSliderState
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySliderAdvance(modifier: Modifier = Modifier) {
    var example by remember { mutableStateOf(":(") }
    var state = remember {
        SliderState(
            value = 5f,
            valueRange = 0f..10f,
            steps = 9,
            onValueChangeFinished = { example = "FELIZZZ..." }

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

    Column(modifier = modifier.padding(32.dp)) {
        Slider(state, colors = colors, thumb = { state ->
            Text(state.value.toString())
        })
        Text(example)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {
    var state = remember {
        RangeSliderState(
            activeRangeStart = 3f,
            activeRangeEnd = 6f,
            valueRange = 0f..10f,
            steps = 9,
            onValueChangeFinished = {}

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
            state = state,
            colors = colors,
            startThumb = {
                Box(
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.Yellow), contentAlignment = Alignment.Center
                ) {
                    Text(it.activeRangeStart.toString())
                }
            },
           endThumb =  {   Box(
               Modifier
                   .size(50.dp)
                   .clip(CircleShape)
                   .background(Color.Green), contentAlignment = Alignment.Center
           ) {
               Text(it.activeRangeEnd.toString())
           }}
        )
    }
}





