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
import com.jdev.myfirstcomposeapp.components.MedicationList
import com.jdev.myfirstcomposeapp.components.MyCheckbox
import com.jdev.myfirstcomposeapp.components.MyRadioButton
import com.jdev.myfirstcomposeapp.components.MyRadioButtonList
import com.jdev.myfirstcomposeapp.components.ParentCheckBoxes
import com.jdev.myfirstcomposeapp.components.TriStateCheckBox
import com.jdev.myfirstcomposeapp.components.practicas.ColoresPersonalizados
import com.jdev.myfirstcomposeapp.components.login.Greeting
import com.jdev.myfirstcomposeapp.components.practicas.SelectPill
import com.jdev.myfirstcomposeapp.components.practicas.SymptomList
import com.jdev.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MedicationList (Modifier.padding(innerPadding))

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