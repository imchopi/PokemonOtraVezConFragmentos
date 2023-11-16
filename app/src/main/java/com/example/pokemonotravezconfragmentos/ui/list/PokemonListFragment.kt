package com.example.pokemonotravezconfragmentos.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.pokemonotravezconfragmentos.data.model.Pokemon
import com.example.pokemonotravezconfragmentos.databinding.FragmentPokemonListBinding

// Parte 5
class PokemonListFragment : Fragment() {
    private val viewModel:PokemonListViewModel by viewModels()
    private lateinit var binding: FragmentPokemonListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PokemonAdapter()
        binding.recyclerViewPokemonList.adapter = adapter

        viewModel.pokemonListUi.observe(viewLifecycleOwner) { pokemonList ->
            Log.d("DERRAPANDO",pokemonList.toString())
            adapter.submitList(pokemonList)
        }
    }

}