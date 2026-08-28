package com.jdev.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.jdev.myfirstcomposeapp.R

// ExposedDropDownMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selection by remember { mutableStateOf("") }
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }) {
        TextField(
            value = selection,
            onValueChange = {},
            readOnly = true,
            label = { Text("Idioma") },
            modifier = Modifier
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryEditable)
                .fillMaxWidth(),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded) // flechita hacia abajo y arriba.
            }
        )
        DropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(text = { Text("Opción 1") }, onClick = {
                selection = "Opción 1"
                expanded = false
            })
            DropdownMenuItem(text = { Text("Opción 2") }, onClick = {

                selection = "Opción 2"
                expanded = false
            })
            DropdownMenuItem(text = { Text("Opción 3") }, onClick = {
                selection = "Opción 3"
                expanded = false
            })
            DropdownMenuItem(text = { Text("Opción 4") }, onClick = {
                selection = "Opción 4"
                expanded = false
            })
        }
    }
}

    // DropdownMenu
    @Composable
    fun MyDropDownMenu(modifier: Modifier = Modifier) {
        var expanded by remember { mutableStateOf(false) }
        Box(modifier = modifier) {  // aquí va estar anclado el DropdownMenu, tiene que estar anclado a una vista
            Button(onClick = { expanded = true }) {
                Text("Ver opciones")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
                offset = DpOffset(20.dp, 16.dp),
                properties = PopupProperties(
                    focusable = true,
                    dismissOnClickOutside = true,
                    dismissOnBackPress = true,
                    clippingEnabled = false
                )
            ) { // onDismissRequest lo que va a realizar cuando tocas fueras del Menu o en botón de retroceso
                DropdownMenuItem(text = { Text("Opción 1") }, onClick = { expanded = false })
                DropdownMenuItem(text = { Text("Opción 2") }, onClick = { expanded = false })
                DropdownMenuItem(text = { Text("Opción 3") }, onClick = { expanded = false })
                DropdownMenuItem(text = { Text("Opción 4") }, onClick = { expanded = false })
            }
        }
    }


    // DropdownMenuItem
    @Composable
    fun MyDropDownItem(modifier: Modifier = Modifier) {
        Column(modifier = modifier) {
            DropdownMenuItem(
                modifier = Modifier.fillMaxWidth(),
                text = {
                    Text("Ejemplo 1")
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_info),
                        contentDescription = ""
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.carita_feliz),
                        contentDescription = ""
                    )
                },
                enabled = true,
                contentPadding = PaddingValues(16.dp),
                colors = MenuDefaults.itemColors(
                    textColor = Color.Gray,
                    leadingIconColor = Color.Red,
                    trailingIconColor = Color.Green,
                    disabledTextColor = Color.DarkGray,
                    disabledLeadingIconColor = Color.DarkGray,
                    disabledTrailingIconColor = Color.DarkGray
                ),
                onClick = {})
        }
    }



//EJEMPLO COMPLETO "SELECTOR DE UNIDADES DE DOSIS"


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectorDosis(modifier: Modifier = Modifier) {
    val unidades = listOf("mg", "ml","comprimidos")
    var expandido by remember { mutableStateOf(false) }
    var unidadSeleccionada by remember { mutableStateOf(unidades.first()) }
    var cantidad by remember { mutableStateOf("") }

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = cantidad,
            onValueChange = {cantidad = it},
            label = {Text("Cantidad")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        ExposedDropdownMenuBox(
            expanded = expandido,
            onExpandedChange = {expandido =  it},
            modifier = Modifier.weight(1f)
        ) {
            TextField(
                value = unidadSeleccionada,
                onValueChange = {},
                readOnly = true,
                label = {Text("Unidad")},
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandido)
                },
                modifier = Modifier
                    .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryEditable)
                    .fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expandido,
                onDismissRequest = {expandido = false}
            ) {
                unidades.forEach { unidad ->
                    DropdownMenuItem(
                        text = {Text(unidad)},
                        onClick = {
                            unidadSeleccionada = unidad
                            expandido = false
                        }
                    )
                }
            }
        }
    }


}