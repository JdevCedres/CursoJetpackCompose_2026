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
import com.jdev.myfirstcomposeapp.components.MyCheckbox
import com.jdev.myfirstcomposeapp.components.MyIcon
import com.jdev.myfirstcomposeapp.components.MySlider
import com.jdev.myfirstcomposeapp.components.MySwitch
import com.jdev.myfirstcomposeapp.components.practicas.ColoresPersonalizados
import com.jdev.myfirstcomposeapp.components.practicas.IndicadorDeterminado
import com.jdev.myfirstcomposeapp.components.practicas.MostarOcultar
import com.jdev.myfirstcomposeapp.components.practicas.PrimerIndicador
import com.jdev.myfirstcomposeapp.login.Greeting
import com.jdev.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MySlider (Modifier.padding(innerPadding))

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