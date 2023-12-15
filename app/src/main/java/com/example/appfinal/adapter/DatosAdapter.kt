package com.example.appfinal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appfinal.Datos
import com.example.appfinal.R

class DatosAdapter(private val datosList: List<Datos>) : RecyclerView.Adapter<datosviewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): datosviewholder {
    val layoutInflater = LayoutInflater.from(parent.context)
    return datosviewholder(layoutInflater.inflate(R.layout.item_materias, parent, false))
        //return datosviewholder(layoutInflater.inflate(R.layout.item_materias, parent, false))
    }

    override fun getItemCount(): Int {
       return datosList.size
    }

    override fun onBindViewHolder(holder: datosviewholder, position: Int) {
    val item = datosList[position]
    holder.render(item, position + 1)

    }
}