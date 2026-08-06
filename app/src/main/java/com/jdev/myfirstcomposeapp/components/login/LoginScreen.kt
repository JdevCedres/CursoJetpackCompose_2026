package com.jdev.myfirstcomposeapp.components.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Preview(showBackground = true)
@Composable
fun ExamplePreview(){
    Example("Dad")
}

@Composable
fun Example(a: String){
    Text( "Jose, $a", modifier = Modifier
        .background(Color.Red)
        .padding(horizontal = 30.dp)
        .clickable{}

    )
}