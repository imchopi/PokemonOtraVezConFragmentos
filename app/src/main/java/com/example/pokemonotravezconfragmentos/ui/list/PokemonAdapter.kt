package com.example.pokemonotravezconfragmentos.ui.list

import android.view.LayoutInflater
import coil.load
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonotravezconfragmentos.data.model.Pokemon
import com.example.pokemonotravezconfragmentos.databinding.ItemPokemonBinding

class PokemonAdapter(val onClick:((Pokemon)->Unit)) :
    ListAdapter<Pokemon,PokemonAdapter.PokemonViewHolder>(PokemonDiffCallback) {

    inner class PokemonViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindPokemon(p: Pokemon){
            binding.imgViewPokemon.load(p.front)
            binding.textViewPokemonName.text = p.name
            binding.root.setOnClickListener {
                onClick(p)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false,)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bindPokemon(pokemon)
    }

    object PokemonDiffCallback: DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }

    }


}
