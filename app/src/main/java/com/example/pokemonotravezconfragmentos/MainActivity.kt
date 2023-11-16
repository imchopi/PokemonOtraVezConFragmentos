package com.example.pokemonotravezconfragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokemonotravezconfragmentos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Parte 3
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Parte 3
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}