package com.ahariss.test.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ahariss.test.mvvm.models.MarvelCharacter
import com.ahariss.test.ui.adapters.tabs.ListFragment

class CollectionAdapter constructor( fragment: Fragment,private var marvelCharacter: MarvelCharacter, private var sections: List<String>) : FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int = sections.size

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        val fragment = ListFragment()
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putString("type",sections.get(position))
            putParcelable("character", marvelCharacter)
        }
        return fragment
    }
}