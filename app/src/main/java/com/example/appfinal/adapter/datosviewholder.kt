package com.example.appfinal.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appfinal.Datos
import com.example.appfinal.DetailActivity
import com.example.appfinal.databinding.ItemMateriasBinding
import java.text.FieldPosition


class datosviewholder(val view: View): RecyclerView.ViewHolder(view) {

    private val bind= ItemMateriasBinding.bind(view)
    fun render(datos: Datos, position: Int){

        bind.tvPais.text = datos.pais
        bind.tvPos.text = position.toString()

        bind.layout.setOnClickListener {
            val intent = Intent(view.context, DetailActivity::class.java)
            intent.putExtra("dato", datos)
            view.context.startActivity(intent)
        }
    }

}