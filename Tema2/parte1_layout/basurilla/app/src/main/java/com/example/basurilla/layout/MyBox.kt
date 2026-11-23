package com.example.basurilla.layout

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyBox(){
    //EL BOx, si no tiene contenido no se vería nada (como un wrap_content)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter){
        Box(modifier = Modifier
            .size(200.dp)
            .background(Color.Blue), contentAlignment = Alignment.Center) {
                Box(modifier = Modifier
                    .size(100.dp)
                    .background(Color.Pink40)
                )

        }
    }
}

