package com.jdev.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyBasicConstraintLayout(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow) = createRefs()
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(boxYellow.bottom)
                    start.linkTo(boxYellow.end)
                })
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Gray)
                .constrainAs(boxGray) {
                    top.linkTo(boxYellow.bottom)
                    end.linkTo(boxYellow.start)
                })
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    bottom.linkTo(boxYellow.top)
                    start.linkTo(boxYellow.end)
                })
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    bottom.linkTo(boxYellow.top)
                    end.linkTo(boxYellow.start)
                })
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })
    }
}

// Constraint Layout avanzando

@Composable
fun ConstraintExampleGuide(modifier: Modifier) {
    ConstraintLayout(Modifier.fillMaxSize()) {

        //val topGuide = createGuidelineFromTop(25.dp) // esto es una guia para poder engancharnos a ella
        val boxRed = createRef()
        val topGuide =
            createGuidelineFromTop(0.1f) // es más habitual usarlo así 0.1f es un diez porciento
        // Independientemente de la pantalla siempre cogerá el 10% de una linea en este caso en el top

        Box(
            Modifier
                .size(150.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(topGuide)
                })
    }
}

@Composable
fun ConstraintBarrier(modifier: Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxCyan) = createRefs() // -> Aquí si que está el boxCyan pero no en el barrier

        val barrier = createEndBarrier(
            boxRed,
            boxYellow
        ) // Crea una barrera donde las vistas no pueden pasar imaginarias
        Box(Modifier
            .size(65.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })
        Box(Modifier
            .size(200.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                top.linkTo(boxRed.bottom, margin = 40.dp)
                start.linkTo(parent.start, margin = 32.dp)
            })
        Box(Modifier
            .size(70.dp)
            .background(Cyan)
            .constrainAs(boxCyan) {
                start.linkTo(barrier) // siempre va a respetar la barrera
            })
    }
}

@Composable
fun ConstraintChain(modifier: Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxCyan) = createRefs()


        Box(Modifier
            .size(100.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(boxYellow.top)
            })
        Box(Modifier
            .size(100.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(boxRed.bottom)
                bottom.linkTo(boxCyan.top)
            })
        Box(Modifier
            .size(100.dp)
            .background(Cyan)
            .constrainAs(boxCyan) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(boxYellow.bottom)
                bottom.linkTo(parent.bottom)
            })

        //createVerticalChain(boxRed, boxYellow, boxCyan, chainStyle = ChainStyle.Packed) // Se juntan
       // createVerticalChain(boxRed, boxYellow, boxCyan, chainStyle = ChainStyle.Spread) // Le pone espacio entre ellos
        createVerticalChain(boxRed, boxYellow, boxCyan, chainStyle = ChainStyle.SpreadInside) // Le pone espacio entre ellos a los extremos

        // Se puede hacer en horizontal, ponerlo todo en horizontal.
    }
}




















































