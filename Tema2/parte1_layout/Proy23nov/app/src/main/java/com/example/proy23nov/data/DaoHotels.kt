package com.example.proy23nov.data

import  com.example.proy23nov.domain.models.Hotel
import com.santi.pmdm.virgen.hospedaje.interfaces.InterfaceDao

//es un constructor privado para evitar sobre escribir datos
class DaoHotels private constructor(): InterfaceDao {
    //un DAO es una clase que consigue dar datos para que lo entienda el dominio, tienen que ser dato que entiendan el proyecto!!! el dao conecta los datos con el dominio
    companion object {
        val myDao: DaoHotels by lazy{  //lazy delega a un primer acceso
            DaoHotels()  //Me creo sólo este objeto una vez.
        }
    }

    //Metodo que accede a la BBDD y devuelve todos los datos
    override
    fun getDataHotels(): List<Hotel>   = Repository.listHotels
}