package com.example.act01_simulacion_hibrido.Views

import com.example.act01_simulacion_hibrido.Logic.Controller

//simulacion de dialogo
class Dialog(var controller: Controller) {
    private var clientAddListener: ((Int, String) -> Unit)? = null
    private var clientUpdateListener: ((Int, String) -> Unit)? = null
    private var clientDelListener: ((Int) -> Unit)? = null

    // CONFI LISTENER
    // añadir cliente
    fun setClientAddListener(listener: (Int, String) -> Unit) {
        clientAddListener = listener
    }

    // actualizar cliente
    fun setClientUpdateListener(listener: (Int, String) -> Unit) {
        clientUpdateListener = listener
    }

    // eliminar cliente
    fun setClientDelListener(listener: (Int) -> Unit) {
        clientDelListener = listener
    }

    // mostrar dialogo
    fun show(typeAction: Int) {
        when (typeAction) {
            0 -> {
                val newId = controller.devIdRandom()
                if (newId != -1) {
                    clientAddListener?.invoke(newId, "NUEVO CLIENTE")
                }
            }
            1 -> {
                val editId = controller.devIdRandom()
                if (editId != -1) {
                    clientUpdateListener?.invoke(editId, "CAMBIADO")
                }
            }
            2 -> {
                val deleteId = controller.devIdRandom()
                if (deleteId != -1) {
                    clientDelListener?.invoke(deleteId)
                }
            }
        }
    }
}