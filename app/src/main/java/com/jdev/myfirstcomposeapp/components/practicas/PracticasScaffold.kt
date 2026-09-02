package com.jdev.myfirstcomposeapp.components.practicas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onVisibilityChangedNode

// Ejercicio 1 - TopAppBar
// Ejercicio 2 - navigationIcon clicable
// Ejercicio 3 - Dos actions
// Ejercicio 4 - Colores personalizados
// Ejercicio 6 - CenterAlignedTopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticasScaffold(modifier: Modifier = Modifier) {
    var contador by remember { mutableIntStateOf(0) }
    Scaffold(modifier = modifier.fillMaxSize(), topBar = {
        CenterAlignedTopAppBar(
            title = { Text("Inicio") }, navigationIcon = {
                IconButton(onClick = { contador += 1 }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                }
            }, actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Search, contentDescription = "Buscar")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Settings, contentDescription = "Ajustes")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
    })
    { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text("Contador $contador")
        }

    }
}

// Ejercicio 5 - TopAppBar reutilizable con parámetros
// Ejercicio 7 - Icono deshabilitado condicionalmente
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiBarra(
    titulo: String,
    onMenuClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(titulo) }, navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(Icons.Default.Menu, contentDescription = "Menú")
            }
        },
        actions = {
            IconButton(onClick = {}, enabled = enabled) {
                Icon(Icons.Default.Delete, contentDescription = "Borrar")
            }
        }
    )

}
