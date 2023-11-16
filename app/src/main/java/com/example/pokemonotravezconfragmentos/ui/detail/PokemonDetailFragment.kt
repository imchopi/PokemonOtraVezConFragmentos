package com.example.pokemonotravezconfragmentos.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokemonotravezconfragmentos.databinding.FragmentPokemonDetailBinding

// Parte 12 - Copiado y pegado
class PokemonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPokemonDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
}