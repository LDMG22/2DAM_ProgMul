package com.example.myapplication

import android.os.Bundle
import android.util.*
import androidx.appcompat.app.AppCompatActivity

private const val variable1 = "variable1_estado0"
private const val variable2 = "variable2_estado0"
class MainActivity : AppCompatActivity() {
    // 1.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 2.
    override fun onStart() {
        super.onStart()
        Log.d(variable1, "Se llama después de onCreate. Santi, muestro la pantalla. El usuario aún no puede interaccionar")
    }

    // 3.
    override fun onResume() {
        super.onResume()
        Log.d(variable1, "El usuario ya puede interaccionar con la pantalla")
    }

    // 4.
    override fun onPause() {
        super.onPause()
        Log.d(variable1, "Pierdo el foco de la pantalla. Boton home")
    }

    // 5.
    override fun onRestart() {
        super.onRestart()
        Log.d(variable1, "Vuelvo a estar visible para santi.")
    }

    // 6.
    override fun onStop() {
        super.onStop()
        Log.d(variable1, "Dejo de estar visible para el usuario. Otra App, S.O.")
    }

    // 7.
    override fun onDestroy() {
        super.onDestroy()
        Log.d(variable1, "La actividad muere.")
    }
}