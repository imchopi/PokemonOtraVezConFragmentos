package com.example.pokemonotravezconfragmentos.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.pokemonotravezconfragmentos.R
import com.example.pokemonotravezconfragmentos.data.model.Pokemon
import com.example.pokemonotravezconfragmentos.databinding.FragmentPokemonDetailBinding

// Parte 12 - Copiado y pegado
class PokemonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPokemonDetailBinding
    private val viewModel: PokemonDetailViewModel by viewModels()
    val args: PokemonDetailFragmentArgs by navArgs()

    val observer = Observer<Pokemon> {
        binding.topAppBar.setNavigationOnClickListener(){
            findNavController().popBackStack(R.id.pokemonListFragment, false)
        }
        binding.textViewPokemonName.text = it.name
        binding.imageViewPokemon.load(it.front)
        binding.textViewHeight.text = "Height: ${it.height/10} m"
        binding.textViewWeight.text = "Weight: ${it.weight/10} kg"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetch(args.name)
        viewModel.pokemonDetails.observe(viewLifecycleOwner, observer)
    }

}