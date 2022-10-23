package com.ahariss.test.ui.adapters

import android.R.attr.data
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.ahariss.test.R
import com.ahariss.test.mvvm.models.MarvelCharacter
import com.squareup.picasso.Picasso


class CharacterAdapter() : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    var characters: List<MarvelCharacter> = mutableListOf()

    fun setCharactersList(characters: List<MarvelCharacter>) {

        this.characters +=  characters
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: AppCompatImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
            imageView = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = characters.get(position).name
        var img = "${characters.get(position).thumbnail.path}.${characters.get(position).thumbnail.extension}"
        println(img)
        Picasso.get().load(img).into(viewHolder.imageView)


    }

    override fun getItemCount(): Int {
        return characters.size
    }
}