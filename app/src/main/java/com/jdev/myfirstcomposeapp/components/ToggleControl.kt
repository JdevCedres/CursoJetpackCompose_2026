package com.jdev.myfirstcomposeapp.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.jdev.myfirstcomposeapp.R

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var switchState by remember { mutableStateOf(true) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it },
            thumbContent = {
                Icon(
                    painter = painterResource(R.drawable.carita_feliz),
                    contentDescription = ""
                )
            }, // en el boton de switch cargamos un icono, podemos hacer lo que queramos y quepa.
            enabled = true,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Blue,
                disabledCheckedThumbColor = Color.Gray,
                disabledUncheckedThumbColor = Color.Black,
                // Icono
                checkedIconColor = Color.Yellow,
                uncheckedIconColor = Color.Red,
                disabledCheckedIconColor = Color.DarkGray,
                disabledUncheckedIconColor = Color.Magenta,
                // Track
                checkedTrackColor = Color.Red,
                uncheckedTrackColor = Color.Yellow,
                disabledCheckedTrackColor = Color.White,
                disabledUncheckedTrackColor = Color.Black,
                //Borde
                checkedBorderColor = Color.Yellow,
                uncheckedBorderColor = Color.Red,
                disabledCheckedBorderColor = Color.Black,
                disabledUncheckedBorderColor = Color.Black
            )

        )
    }
}

@Composable
fun MyCheckbox(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(true) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = it },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Yellow,
                checkmarkColor = Color.Green,
                disabledCheckedColor = Color.Gray,
                disabledUncheckedColor = Color.Black
            )
        )
    }
}