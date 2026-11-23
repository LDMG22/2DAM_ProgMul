package com.santi.pmdm.virgen.hospedaje.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santi.pmdm.virgen.hospedaje.R
import com.santi.pmdm.virgen.hospedaje.models.Hotel

class AdapterHotel(
    var listHotel : MutableList<Hotel>, // todos los dotos. Si algna se actualizara, DEBE de actualizar / rehacer el RecycleView.
    //son de tipo entero para saber la POSICION
    var deleteOnClick: (Int) -> Unit, // funcion que hay que invocar cuando se borre un elemento (hotel). Ira al contorller
    var updateOnClick: ( Int) -> Unit // funcion que hay que invocar cuando se actualice un elemeneto (hotel). Ira al controller
) : RecyclerView.Adapter<ViewHHotel>(){
  /*
  Método que crea la view del ViewHolderHotel
   */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHHotel {
       val layoutInflater = LayoutInflater.from(parent.context)//objeto para crear la vista (inflar), el parent es el recyvle view
       val layoutItemHotel = R.layout.item_hotel  //accedo al xml del item a crear.
       val view = layoutInflater.inflate(layoutItemHotel, parent, false) //inflamos la vista
      return ViewHHotel(
          view,
           deleteOnClick,
           updateOnClick
       )
    }

    /*
    Este método, debe renderizar todos los datos o propiedades de cada hotel con la view.
    Accedemos al objeto por medio de position
     */
   override fun onBindViewHolder(holder: ViewHHotel, position: Int) {
        holder.renderize(listHotel.get(position))  //renderizamos la view.
     }

    /*
    Este método, devuelve el número de objetos a representar en el recyclerView.
     */
    override fun getItemCount(): Int = listHotel.size
}
