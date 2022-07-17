package com.example.composeprojectyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            var textFieldStateValue by remember {
                mutableStateOf("")
            }
            val buttonScope = rememberCoroutineScope()
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    TextField(
                        value = textFieldStateValue,
                        label = { Text("Enter your name") },
                        singleLine = true,
                        onValueChange = {
                            textFieldStateValue = it
                        })
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        buttonScope.launch { scaffoldState.snackbarHostState.showSnackbar("Hello, $textFieldStateValue") }
                    }) {
                        Text("Press Me")
                    }
                }
            }
        }
    }
}