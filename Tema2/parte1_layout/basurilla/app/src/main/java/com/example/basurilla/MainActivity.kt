package com.example.basurilla

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basurilla.ui.theme.BasurillaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasurillaTheme {}
        }
    }
}

@Composable
fun ProbeComponent(name: String, modifier: Modifier = Modifier) {
    // sirve para respetar el padding del contenido al menu de la bateria, la hora etc..
    Scaffold(modifier = Modifier) { innerPadding ->
        MyBox();
    }
}

@Preview(showBackground = true)
@Composable
fun ProbeComponentPreview() {
    BasurillaTheme {
        ProbeComponent("Android")
    }
}