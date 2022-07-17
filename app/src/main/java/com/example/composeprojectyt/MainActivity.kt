package com.example.composeprojectyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            Scaffold(scaffoldState = scaffoldState) {
                val counter = produceState(initialValue = 0) {
                    delay(3000)
                    value = 5
                }
                if (counter.value == 5) {
                    LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
                        scaffoldState.snackbarHostState.showSnackbar("Hello!")
                    }
                }
                Button(onClick = {}) {
                    Text(text = "Click Here: ${counter.value}")
                }
            }
        }
    }
}