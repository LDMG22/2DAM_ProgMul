package com.example.proy23nov.ui.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proy23nov.R
import com.example.proy23nov.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // ATRIBUTOS
    lateinit var binding: ActivityMainBinding
    lateinit var controller:Controller


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.main)

        //margenes para no solapar con la barra superior del telefono (bateria, hora...)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    private fun init(){
        initRecycleView()
        controller =  Controller(this)
    }

    private fun initRecycleView(){
        binding.myRecycleView.layoutManager = LinearLayoutManager(this)
    }
}