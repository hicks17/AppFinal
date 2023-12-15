package com.example.appfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfinal.adapter.DatosAdapter
import com.example.appfinal.databinding.ActivityMainBinding
import com.google.android.material.R

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val divisas = listOf("Dolar estadounidense", "Peso mexicano", "Dólar canadiense", "Rupia", "Peso argentino")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initReciclerView()


        setSpinnerList()
        initListeners()
    }

    private fun initListeners() {
        binding.calcular.setOnClickListener {
            if(binding.tvDivisa1.text.toString().toInt() != 0)
                calcularDivisas()
            else
                toast("El valor no puede ser 0")
        }
    }

    private fun calcularDivisas() {


        when(binding.spinner1.selectedItemPosition){
            0 -> {
                when(binding.spinner2.selectedItemPosition){
                    0 -> {
                        toast("Es la misma divisa")
                    }
                    1 -> {
                        setValor(formula = 17.19)
                    }
                    2 -> {
                        setValor(formula = 1.34)
                    }
                    3 -> {
                        setValor(formula = 83.31)
                    }
                    4 -> {
                        setValor(formula = 800.54)
                    }
                }
            }
            1 -> {
                when(binding.spinner2.selectedItemPosition){
                    0 -> {
                        setValor(formula = 0.058)
                    }
                    1 -> {
                        toast("Es la misma divisa")
                    }
                    2 -> {
                        setValor(formula = 0.078)
                    }
                    3 -> {
                        setValor(formula = 4.85)
                    }
                    4 -> {
                        setValor(formula = 46.57)
                    }
                }
            }
            2 -> {
                when(binding.spinner2.selectedItemPosition){
                    0 -> {
                        setValor(formula = 0.75)
                    }
                    1 -> {
                        setValor(formula = 12.18)
                    }
                    2 -> {
                        toast("Es la misma divisa")
                    }
                    3 -> {
                        setValor(formula = 62.13)
                    }
                    4 -> {
                        setValor(formula = 596.98)
                    }
                }
            }
            3 -> {
                when(binding.spinner2.selectedItemPosition){
                    0 -> {
                        setValor(formula = 0.012)
                    }
                    1 -> {
                        setValor(formula = 0.21)
                    }
                    2 -> {
                        setValor(formula = 0.016)
                    }
                    3 -> {
                        toast("Es la misma divisa")
                    }
                    4 -> {
                        setValor(formula = 9.61)
                    }
                }
            }
            4 -> {
                when(binding.spinner2.selectedItemPosition){
                    0 -> {
                        setValor(formula = 0.0012)
                    }
                    1 -> {
                        setValor(formula = 0.021)
                    }
                    2 -> {
                        setValor(formula = 0.0017)
                    }
                    3 -> {
                        setValor(formula = 0.104)
                    }
                    4 -> {
                        toast("Es la misma divisa")
                    }
                }
            }
        }
    }

    private fun setValor(multiplicador:Int = binding.tvDivisa1.text.toString().toInt(), formula:Double){
        binding.tvDivisa2.setText((multiplicador * formula).toString())
    }

    private fun setSpinnerList() {
        val listaDivisas = ArrayAdapter<String>(
            this,
            R.layout.support_simple_spinner_dropdown_item
        )
        listaDivisas.addAll(divisas)
        binding.spinner1.adapter = listaDivisas
        binding.spinner2.adapter = listaDivisas
    }

    private fun initReciclerView(){
        binding.recyclerprofes.layoutManager = LinearLayoutManager(this)
        binding.recyclerprofes.adapter = DatosAdapter(ProveedorDatos.Datoslist)
    }
}