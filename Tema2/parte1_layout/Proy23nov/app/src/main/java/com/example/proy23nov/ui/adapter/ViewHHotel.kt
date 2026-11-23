package com.santi.pmdm.virgen.hospedaje.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.santi.pmdm.virgen.hospedaje.databinding.ItemHotelBinding
import com.santi.pmdm.virgen.hospedaje.models.Hotel

/*
Recibe la vista creada por el adaptador y mapeo de los datos en la vista.
 */
class ViewHHotel(view: View,
                var deleteOnClick: (Int) -> Unit,
                 var updateOnClick: (Int) -> Unit
) : RecyclerView.ViewHolder (view){
    lateinit var binding: ItemHotelBinding

    init {
        binding = ItemHotelBinding.bind(view)
    }

 //método que se encarga de mapear los item por propiedad del modelo.
    fun renderize(hotel : Hotel){
        binding.txtviewName.setText(hotel.name)
        binding.txtviewCity.setText(hotel.city)
        binding.txtviewProvince.setText(hotel.province)
        binding.txtviewPhone.setText(hotel.phone)
        Glide
            .with(itemView.context)
            .load(hotel.image)
            .centerCrop()
            .into(binding.ivHotel)

        setOnClickListener() //inicia los listener para los botones.
    }

    private fun setOnClickListener() {

        binding.btnEdit.setOnClickListener {
            val position = bindingAdapterPosition  //devuelve la posición del objeto que está representando actualmente este ViewHolder
           /*
           debemos comprobar que el viewHolder siga asociado a un elemento válido del Adapter antes de utilizar su posición.
           Puede dar la casualidad, que en este momento, el RecyclerView está realizando alguna actualización de sus elementos. (zonas oscuras)
            */
            if (position != RecyclerView.NO_POSITION){
                updateOnClick(position )
            }

        }

        binding.btnDelete.setOnClickListener{
            val position = bindingAdapterPosition

            if (position != RecyclerView.NO_POSITION){
                deleteOnClick(position)
            }
        }
    }
}
