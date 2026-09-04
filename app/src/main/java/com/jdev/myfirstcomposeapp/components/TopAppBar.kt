package com.jdev.myfirstcomposeapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.jdev.myfirstcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = { Text("My App") },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_info),
                contentDescription = null
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_info),
                contentDescription = null
            )
            Icon(
                painter = painterResource(R.drawable.ic_info),
                contentDescription = null,
                tint = Color.White
            )
            Icon(
                painter = painterResource(R.drawable.ic_info),
                contentDescription = null
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,
            scrolledContainerColor = Color.Black
        )
    )
}

// Ejemplo Completo - TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraPastillero(
    onVolverClick: () -> Unit,
    onBuscarClick: () -> Unit,
    onAjustesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = { Text("Mi Pastillero") },
        navigationIcon = {
            IconButton(onClick = onVolverClick) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
            }
        },
        actions = {
            IconButton(onClick = onBuscarClick) {
                Icon(Icons.Default.Search, contentDescription = "Buscar medicamentos")
            }
            IconButton(onClick = onAjustesClick) {
                Icon(Icons.Default.Settings, contentDescription = "Ajustes")
            }

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

// Uso dentro del Scaffold
/**
 * Scaffold(
 *      topBar = {
 *          BarraPastillero(
 *              onVolverClick = {navegación, más adelante en el curso},
 *              onBuscarClick = {abrir buscador},
 *              onAjustesClick = {ir a ajustes}
 *          )
 *       }
) { innerPadding ->

//contenido de la página
 *
 *      }
 * )
 *

 */