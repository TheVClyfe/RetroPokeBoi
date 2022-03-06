package com.vclyfe.experiment.retrofitboi.components

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vclyfe.experiment.retrofitboi.R
import com.vclyfe.experiment.retrofitboi.databinding.ItemPokemonListBinding
import com.vclyfe.experiment.retrofitboi.model.PokemonListData

class PokemonListAdapter(private val context: Context, private val pokemonList: MutableList<PokemonListData> = mutableListOf()): RecyclerView.Adapter<PokemonListAdapter.PokemonListItemViewHolder>() {

    class PokemonListItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var idTextView: TextView = view.findViewById(R.id.cardItemId)
        var nameTextView: TextView = view.findViewById(R.id.cardItemText)

        init {
            view.setOnClickListener {
                Log.d("RecyclerView", "Item clicked!")
            }
        }
    }

    fun addToPokemonList(list: List<PokemonListData>) {
        pokemonList.addAll(list)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListItemViewHolder {
        val vBinding = ItemPokemonListBinding.inflate(LayoutInflater.from(context), parent, false)
        return PokemonListItemViewHolder(vBinding.root)
    }

    //when the view becomes visible to the user
    override fun onBindViewHolder(holder: PokemonListItemViewHolder, position: Int) {
        val pokemonListItem = pokemonList[position]
        val pokeUrlHolder = pokemonListItem.url.split("/")
        holder.idTextView.text = pokeUrlHolder[pokeUrlHolder.lastIndex-1]
        holder.nameTextView.text = pokemonListItem.name
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}