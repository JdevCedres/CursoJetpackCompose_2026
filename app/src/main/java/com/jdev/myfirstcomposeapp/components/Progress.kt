package com.jdev.myfirstcomposeapp.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.jdev.myfirstcomposeapp.R


@Composable
fun Progress(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            Modifier.size(100.dp),
            color = Color.Red,
            strokeWidth = 10.dp,
            trackColor = Color.Yellow,
            strokeCap = StrokeCap.Square
        )
        Spacer(Modifier.height(24.dp))
        LinearProgressIndicator(
            color = Color.Red,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Round
        )
    }
}


@Composable
fun ProgressAdvance(modifier: Modifier = Modifier) {
    var progress by rememberSaveable { mutableFloatStateOf(0.5f) }
    var isLoading by remember { mutableStateOf(false) }
    val animateProgress by animateFloatAsState(targetValue = progress)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                progress = { animateProgress },
                Modifier.size(100.dp),
                color = Color.Red,
                strokeWidth = 10.dp,
                trackColor = Color.Yellow,
                strokeCap = StrokeCap.Square
            )
        }

        Spacer(Modifier.height(24.dp))
        LinearProgressIndicator(
            progress = { animateProgress },
            color = Color.Red,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Round
        )
        Row(Modifier.padding(24.dp)) {
            Button(onClick = { progress -= 0.1f }) { Text("<--") }
            Spacer(Modifier.width(24.dp))
            Button(onClick = { progress += 0.1f }) { Text("-->") }
        }
        Button(onClick = { isLoading = !isLoading }) { Text("Show/hide") }
    }
    // Usamos la libreria de lottie, vamos a su pagina y seguimos las instrucciones

    /*
        Vamos a settings.gradle.kts e incluimos maven ("https://oss.sonatype.org/content/repositories/snapshots/" )

        DependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven ("https://oss.sonatype.org/content/repositories/snapshots/" )
    }
}
        Luego vamos a build.gradle.kts(app) y ponemos la dependencia y cambiamos version y lo pasamos kts
     */


}

@Composable
fun ProgressAnimation(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
    }

}
