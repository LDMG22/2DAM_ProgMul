package com.example.myapplication

import android.os.Bundle
import android.util.*
import androidx.appcompat.app.AppCompatActivity

private const val variable1 = "variable1_estado0"
private const val variable2 = "variable2_estado0"
/*
    ENUNCIADOS:
        1. Ciclo de vida:  Sobreescribir todos los métodos del ciclo de vida y mediante Log, capturaremos lo que sucede.
        2. Debugger: Crearos un par de variables y modificarla en cada uno de los métodos del activity. Ir ejecutando paso a paso y comprobando el estado de dichas variables.
        3. Crearos una clase llamada ClaseA que tenga:
                - Tres atributos
                - Codificar dos constructores
                - Getters/setters
                - toString
           Desde el metodo onStart(), crearos un objeto de la claseA, sesearlo y realizar un Toast ( toast = burbuja que dura unos segundos como notificacion desde abajo)
           Poner puntos de ruptura en cada metodo de la claseA y utilizar las opciones de la depuración.
*/

/*
    ESTADOS DEL ACTIVITY:
        1.- Inexistente:  No memoria, No visibilidad, No primer plano
        2.- Detenida:     Si memoria, No visibilidad, No primer plano
        3.- Pausada:      Si memoria, Parcial visbil, No primer plano
        4.- En ejecucion: Si memoria, Si visibilidad, Si primer plano
*/

class MainActivity : AppCompatActivity() {
    // 1. Siempre se llama a este metodo después de crearse el Activity.
    // se INFLAN las vistas ==> ** cargar datos en memoria
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 2. Justo antes de verse, se prepara para mostrarse despueś
    override fun onStart() {
        super.onStart()
        Log.d(variable1, "variable1, muestro la pantalla y aún no puede interaccionar")
        Log.d(variable2, "variable2, muestro la pantalla y aún no puede interaccionar")
    }

    // 3. Activity en 1er plano (poner en pila de activitys) -> El usuario ya PUEDE INTERACTUAR con la interfaz
    override fun onResume() {
        super.onResume()
        Log.d(variable1, "variable1, ya se puede interactuar con la pantalla")
        Log.d(variable2, "variable2, ya se puede interactuar con la pantalla")
    }


    // **- - - ACTIVITY EJECUCIÓN - - -**


    // 4. Actiity deja de estar en primer plano / pierde el foco.
    //    También cuando el activity se vuelve parcialmente visible
    //          a) 5. onResume()  --> [ vuelve al Start() después de iniciarse Stop() ]
    //          b) 6. onStop() --> [ Stop() > Restart() > Start() ]
    override fun onPause() {
        super.onPause()
        Log.d(variable1, "variable1, pierdo el foco de la pantalla. Boton home")
        Log.d(variable2, "variable2, pierdo el foco de la pantalla. Boton home")
    }

    // 5. Activity vuelve a estar en primer plano
    override fun onRestart() {
        super.onRestart()
        Log.d(variable1, "Vuelvo a estar visible para santi.")
    }

    // 6. Activity deja de ser visible para el usuario (según S.O y los parámetros que siga)
    //      esto se debe al oonPause() y de ahi o: a) onRestart() = vuelve a estar visible O SINO b) onDestroy()
    override fun onStop() {
        super.onStop()
        Log.d(variable1, "Dejo de estar visible para el usuario. Otra App, S.O.")
    }

    // 7. Es destruido o por el usuario o por S.O, permite liberar recursos con ello
    override fun onDestroy() {
        super.onDestroy()
        Log.d(variable1, "La actividad muere.")
    }
}