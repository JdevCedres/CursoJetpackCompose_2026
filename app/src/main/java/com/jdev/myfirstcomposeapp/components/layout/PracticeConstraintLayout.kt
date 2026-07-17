package com.jdev.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.approachLayout
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlin.reflect.KParameter

@Composable
fun MyPracticeBasicConstraintLayout(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow, boxCyan, boxDarkGray, boxBlack, boxBlue) = createRefs()
        Box(
            Modifier
                .size(175.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    start.linkTo(parent.start)
                    bottom.linkTo(boxMagenta.top)
                }
        )

        Box(
            Modifier
                .size(75.dp)
                .background(Color.Black)
                .constrainAs(boxBlack){
                    start.linkTo(boxCyan.end)
                    end.linkTo(boxDarkGray.start)
                    bottom.linkTo(boxDarkGray.bottom)
                    top.linkTo(boxCyan.top)
                }
        )

        Box(
            Modifier
                .size(175.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue){
                    top.linkTo(boxYellow.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Box(
            Modifier
                .size(175.dp)
                .background(Color.DarkGray)
                .constrainAs(boxDarkGray){
                    end.linkTo(parent.end)
                    bottom.linkTo(boxGreen.top)
                }
        )


        Box(
            Modifier
                .size(75.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(boxYellow.bottom)
                    start.linkTo(boxYellow.end)
                })
        Box(
            Modifier
                .size(75.dp)
                .background(Color.Gray)
                .constrainAs(boxGray) {
                    top.linkTo(boxYellow.bottom)
                    end.linkTo(boxYellow.start)
                })
        Box(
            Modifier
                .size(75.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    bottom.linkTo(boxYellow.top)
                    start.linkTo(boxYellow.end)
                })
        Box(
            Modifier
                .size(75.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    bottom.linkTo(boxYellow.top)
                    end.linkTo(boxYellow.start)
                })
        Box(
            Modifier
                .size(75.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })

    }
}