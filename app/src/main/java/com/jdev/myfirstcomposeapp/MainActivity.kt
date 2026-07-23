package com.jdev.myfirstcomposeapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jdev.myfirstcomposeapp.components.MyButton
import com.jdev.myfirstcomposeapp.components.MyIcon
import com.jdev.myfirstcomposeapp.components.MyImage
import com.jdev.myfirstcomposeapp.components.MyNetworkImage
import com.jdev.myfirstcomposeapp.components.MyPracticeTextField
import com.jdev.myfirstcomposeapp.components.Progress
import com.jdev.myfirstcomposeapp.components.ProgressAdvance
import com.jdev.myfirstcomposeapp.components.ProgressAnimation
import com.jdev.myfirstcomposeapp.login.Greeting
import com.jdev.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProgressAnimation (Modifier.padding(innerPadding))

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android")
    }
}