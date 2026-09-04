package com.jdev.myfirstcomposeapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jdev.myfirstcomposeapp.components.MyFAB
import com.jdev.myfirstcomposeapp.components.MyTopAppBar
import com.jdev.myfirstcomposeapp.components.SelectorDosis
import com.jdev.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyTopAppBar() },
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                    floatingActionButton = { MyFAB() }
                )
                { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(Color.Cyan),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Esta es mi screen", modifier = Modifier.clickable {
                            scope.launch {
                                val result = snackbarHostState.showSnackbar(
                                    "Ejemplo...",
                                    actionLabel = "Deshacer"
                                )
                                if (result == SnackbarResult.ActionPerformed){
                                    // pulsó deshacer
                                } else {
                                    // no hizo nada
                                }
                            }
                        })
                    }

                }
            }
        }
    }
}


