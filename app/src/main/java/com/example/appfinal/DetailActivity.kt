package com.example.appfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.appfinal.databinding.ActivityDetailBinding
import java.io.Serializable

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datos = intent.getSerializableExtra("dato") as Datos

        binding.tvDivisa.text = "Moneda: ${datos.divisa}"
        binding.tvPais.text = datos.pais
        binding.tvPoblacion.text = "Poblacion: ${datos.poblacion}"
        Glide.with(this).load(datos.photo).into(binding.ivPais)

    }
}