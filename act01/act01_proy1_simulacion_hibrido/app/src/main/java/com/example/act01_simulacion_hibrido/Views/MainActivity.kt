package com.example.act01_simulacion_hibrido.Views

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.act01_simulacion_hibrido.Logic.Client
import com.example.act01_simulacion_hibrido.Logic.Controller
import com.example.act01_simulacion_hibrido.R

class MainActivity : AppCompatActivity() {
    private lateinit var myButtonAdd: ImageView
    private lateinit var myButtonUpdate: ImageView
    private lateinit var myButtonDel: ImageView
    private lateinit var myDialog : Dialog
    private val controller= Controller()

    companion object {
        const val TAG = "---SALIDA---"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log. d(TAG, "Esto es un ejemplo de log")
        start()
    }



    // como si fuera el main
    private fun start() {
        myButtonAdd = findViewById(R.id.myButtonAdd)   //Recuperamos la referencia en memoria del botón de la interfaz.
        myButtonUpdate = findViewById(R.id.myButtomEdit)
        myButtonDel = findViewById(R.id.myButtomDel)
        myDialog = Dialog(controller)

        // Configurar callbacks con lambdas
        myDialog.setClientAddListener { id, name ->
            val newClient = Client(id, name)
            controller.ClientAddController(newClient)
            val msg = "El cliente con id = $id, ha sido insertado correctamente"
            Log.d(TAG, msg)
            showConsoleData(msg)
        }

        myDialog.setClientUpdateListener { id, name ->
            val msg = if (controller.ClientUpdateController(id, name)) {
                "El cliente con id = $id, ha sido actualizado correctamente"
            } else {
                "El cliente con id = $id, no ha sido encontrado para actualizar"
            }
            Log.d(TAG, msg)
            showConsoleData(msg)
        }

        myDialog.setClientDelListener { id ->
            val msg = if (controller.ClientDelController(id)) {
                "El cliente con id = $id, ha sido eliminado correctamente"
            } else {
                "El cliente con id = $id, no ha sido encontrado para eliminar"
            }
            Log.d(TAG, msg)
            showConsoleData(msg)
        }

        myButtonAdd.setOnClickListener {
            myDialog.show(0)
        }

        myButtonUpdate.setOnClickListener {
            myDialog.show(1)
        }

        myButtonDel.setOnClickListener {
            myDialog.show(2)
        }


    }


    fun showConsoleData(msg:String){
        val msg = controller.showData()
        Thread.sleep(2000)
        Log. d(TAG, msg)
    }
}
