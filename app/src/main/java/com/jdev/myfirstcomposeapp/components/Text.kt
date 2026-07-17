package com.jdev.myfirstcomposeapp.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp


@Composable
fun MyTexts(modifier: Modifier) {
    Column(modifier = modifier) {
        Text("Jose")
        Text("Jose rojo ", color = Color.Red)
        Text("Jose", fontSize = 25.sp)
        Text("FontStyle", fontStyle = FontStyle.Italic)
        Text("FontWeight", fontWeight = FontWeight.Bold)
        Text(
            "FontWeight",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 25.sp
        )
        Text("LetterSpacing", letterSpacing = 20.sp) // separa las letras
        Text("TextDecoration", textDecoration = TextDecoration.Underline)
        Text(
            "TextDecoration",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
        )
        Text(
            "EjemploLink",
            textDecoration = TextDecoration.Underline,
            color = Color.Blue,
            modifier = Modifier.clickable {}
        )
        Text(
            "Aling,Aling,Aling,Aling,Aling,Aling,Aling,Aling,Aling,Aling,Aling,Aling,Aling,Aling, pepeepepepepepe",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth() // para tenerlo alineado al centro tenemos que tener .fillMaxWidth
                .background(Color.Red),
            maxLines = 1, // Le decimos que solo una linea
            overflow = TextOverflow.Ellipsis // Esto te sale los típicos ... para saber que hay más texto.
        )
        // Algunos Estilos Material3 disponible:
        Text("Display Large", style = MaterialTheme.typography.displayLarge)
        Text("Headline Large", style = MaterialTheme.typography.headlineLarge)
        Text("Title Large", style = MaterialTheme.typography.titleLarge)
        Text("Body Large", style = MaterialTheme.typography.bodyLarge)
        Text("Label Large", style = MaterialTheme.typography.labelLarge)
    }
}



