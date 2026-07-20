package com.jdev.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.jdev.myfirstcomposeapp.R


@Composable
fun MyImage(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.payaso),
            contentDescription = "prueba",
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(50))
                .border(
                    width = 5.dp,
                    shape = RoundedCornerShape(50),
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Red,
                            Color.Blue,
                            Color.Yellow
                        )
                    )
                ),
            contentScale = ContentScale.FillBounds // Cuando el tamaño no se ajusta no coincide
            // con el espacio disponible, "contentScale" decide como se ajusta
        )
    }
}

// Imagen desde Internet, vamos a utilizar Coil

/**
 *  Como instalarlo o usarlo:
 *      1 Cargamos dependencia :
 *          implementation("io.coil-kt.coil3:coil-compose:3.5.0")
 *      2 Vamos a build.gradle.kts(App) importamos las dependencia, pero antes en el gradle.tomls
 *          miramos si está desactualizado
 *      3 Tendremos que ir a AndroidManifest.xml
 *          y ponemos el permiso de Internet: <uses-permission android:name="android.permission.INTERNET"/>
 *
 */


@Composable
fun MyNetworkImage(modifier: Modifier) {
    AsyncImage(
        model = "https://picsum.photos/200/300",
        contentDescription = "Image form network",
        modifier = modifier.size(250.dp),
        onError = {
            Log.i("Image", "Ha ocurrido un error ${it.result.throwable.message}")
        }
    )
}

// ICONOS
@Preview
@Composable
fun MyIcon(modifier: Modifier = Modifier) {
    var color by remember { mutableStateOf(Color.Yellow) }
    Icon(
        painter = painterResource(R.drawable.carita_feliz),
        contentDescription = null,
        modifier = modifier
            .size(200.dp)
            .clickable {
                color = Color.Red
            },
        tint = color// Por defecto viene negro y con tint lo pintas
    )
}











