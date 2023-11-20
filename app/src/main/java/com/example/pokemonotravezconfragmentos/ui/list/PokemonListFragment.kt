package com.example.pokemonotravezconfragmentos.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.pokemonotravezconfragmentos.R
import com.example.pokemonotravezconfragmentos.data.api.PokemonApiModel
import com.example.pokemonotravezconfragmentos.data.api.PokemonRepository
import com.example.pokemonotravezconfragmentos.data.model.Pokemon
import com.example.pokemonotravezconfragmentos.databinding.FragmentPokemonListBinding
import com.example.pokemonotravezconfragmentos.databinding.ItemPokemonBinding

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
        val adapter = PokemonAdapter(::toDetail)
        binding.progress.visibility = View.VISIBLE
        binding.recyclerViewPokemonList.adapter = adapter
        viewModel.pokemonListUi.observe(viewLifecycleOwner) { pokemonList ->
            Log.d("DERRAPANDO",pokemonList.toString())
            adapter.submitList(pokemonList)
            binding.progress.visibility = View.GONE
        }
    }

    fun toDetail (pokemon: Pokemon) {
        val action = PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDetailFragment(pokemon.name)
        findNavController().navigate(action)
    }

}