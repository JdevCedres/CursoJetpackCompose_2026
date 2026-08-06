package com.jdev.myfirstcomposeapp.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.contentReceiver
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.jdev.myfirstcomposeapp.R
import com.jdev.myfirstcomposeapp.components.state.CheckBoxState

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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { state = !state }) {
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
            Spacer(Modifier.width(10.dp))
            Text("Acepto las condiciones")
        }
    }

}

@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(
            listOf(
                CheckBoxState(id = "terms", "Aceptar los términos y condiciones"),
                CheckBoxState("newsletter", "Recibir las newsletter", true),
                CheckBoxState("updates", "Recibir actualizaciones")
            )
        )
    }
    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            CheckBoxWithText(checkBoxState = myState) {
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
fun CheckBoxWithText(
    modifier: Modifier = Modifier,
    checkBoxState: CheckBoxState,
    onCheckedChange: (CheckBoxState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange(checkBoxState) }) {
        Checkbox(
            checked = checkBoxState.checked,
            onCheckedChange = { onCheckedChange(checkBoxState) },
            enabled = true,

            )
        Spacer(Modifier.width(10.dp))
        Text(checkBoxState.label)

    }
}

@Composable
fun TriStateCheckBox(modifier: Modifier = Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }
    LaunchedEffect(child1, child2) {
        parentState = when {
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                child1 = newState
                child2 = child1
            })
            Text("Seleccionar todo ")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child1, onCheckedChange = { child1 = it })
            Text("Ejemplo 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child2, onCheckedChange = { child2 = it })
            Text("Ejemplo 2")
        }
    }
}

// RadioButton

@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(false) }
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = state,
            onClick = { state = !state },
            enabled = false,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Blue,
                disabledSelectedColor = Color.Black,
                disabledUnselectedColor = Color.DarkGray
            )
        )
        Text("Ejemplo 1")
    }

}


// RadioButton más avanzado

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    var selectedName by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        RadioButtonComponent("Ibuprofeno", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent("Paracetamol", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent("Tramadol", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent("Aspirina", selectedName = selectedName) { selectedName = it }
    }
}


@Composable
fun RadioButtonComponent(name: String, selectedName: String, onItemSelected: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onItemSelected(name) }
    )
    {
        RadioButton(selected = name == selectedName, onClick = { onItemSelected(name) })
        Text(name)
    }

}

// Ejemplo otra manera de hacerlo:

enum class Medicamentos { IBUPROFENO, PARACETAMOL, TRAMADOL, ASPIRINA }

@Composable
fun MedicationList(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(Medicamentos.TRAMADOL) }
    Column(modifier = modifier.fillMaxSize().selectableGroup()) {
        Medicamentos.entries.forEach { medicamento ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (medicamento == selected),
                        onClick = { selected = medicamento },
                        role = Role.RadioButton
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (medicamento == selected),
                    onClick = null
                )
                Text(medicamento.name)
            }
        }

    }

}



