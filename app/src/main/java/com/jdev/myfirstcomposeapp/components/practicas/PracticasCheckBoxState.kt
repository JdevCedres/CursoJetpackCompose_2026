package com.jdev.myfirstcomposeapp.components.practicas


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp


/**
 * Ejercicio — Lista de síntomas con data class
 *
 * Objetivo: Recrea el ejercicio 3 de la ficha de Switch/Checkbox (la lista de síntomas), pero esta vez usando el patrón profesional que acabas de ver, en vez del Set<String>.
 *
 * Pasos:
 *
 * Crea una data class llamada SintomaState con id: String, label: String, y checked: Boolean = false.
 * Crea un composable ListaSintomas que:
 * Guarde en remember { mutableStateOf(...) } una lista de 3 SintomaState (por ejemplo: "Dolor de cabeza", "Fiebre", "Mareo")
 * Recorra la lista con forEach
 * Por cada elemento, llame a un composable hijo SintomaCheckbox
 * Crea el composable hijo SintomaCheckbox que:
 * Reciba un SintomaState y un onCheckedChange: (SintomaState) -> Unit
 * Muestre un Row con Checkbox + Text, alineado verticalmente
 * Al pulsar, invoque onCheckedChange pasando el SintomaState actual
 * En ListaSintomas, cuando SintomaCheckbox dispare el evento, usa .map() + .copy(checked = !it.checked) para actualizar solo el elemento correspondiente, comparando por id.
 */
@Composable
fun SymptomList(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(
            listOf(
                SymptomState("head", "Dolor de cabeza"),
                SymptomState("fever", "Fiebre", true),
                SymptomState("dizzy", "Mareo")
            )
        )
    }
    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            SymptomCheckBox(symptomState = myState) {
                state = state.map {
                    if (it.id == myState.id) {
                        myState.copy(checked = !myState.checked)
                    } else {
                        it
                    }
                }
            }
        }
    }
}

@Composable
fun SymptomCheckBox(
    modifier: Modifier = Modifier,
    symptomState: SymptomState,
    onCheckedChange: (SymptomState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange(symptomState) }) {
        Checkbox(
            checked = symptomState.checked,
            onCheckedChange = { onCheckedChange(symptomState) },
            enabled = true,

            )
        Spacer(Modifier.width(10.dp))
        Text(symptomState.label)

    }
}

@Composable
fun SelectPill(modifier: Modifier = Modifier) {

    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var pill1 by remember { mutableStateOf(false) }
    var pill2 by remember { mutableStateOf(false) }
    var pill3 by remember { mutableStateOf(false) }
    LaunchedEffect(pill1, pill2, pill3) {
        parentState = when {
            pill1 && pill2 && pill3 -> ToggleableState.On
            !pill1 && !pill2 && !pill3 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate

        }
    }

    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,

            ) {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                pill1 = newState
                pill2 = pill1
                pill3 = pill2
            })
            Text("Selecionar todas")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(pill1, onCheckedChange = { pill1 = it })
            Text("Ibuprofeno")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(pill2, onCheckedChange = { pill2 = it })
            Text("Paracetamol")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(pill3, onCheckedChange = { pill3 = it })
            Text("Tramadol")
        }
    }
}

