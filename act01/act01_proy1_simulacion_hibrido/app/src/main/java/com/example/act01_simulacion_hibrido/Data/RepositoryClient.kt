package com.example.act01_simulacion_hibrido.Data

import com.example.act01_simulacion_hibrido.Logic.Client

class RepositoryClient {
    companion object {  // solo uno por clase!!
        var primary = 100

        val arrayClient : List<Client> = listOf (
            Client (incrementPrimary(), "Luillo"),
            Client (incrementPrimary(), "Luopoldo"),
            Client (incrementPrimary(), "Lulu"),
            Client (incrementPrimary(), "Luo")
        )

        fun incrementPrimary() = primary ++ // clave e incrementar despues
    }
}