package com.ahariss.test.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.ahariss.test.databinding.FragmentCharacterDetailBinding
import com.ahariss.test.ui.adapters.CollectionAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CharacterDetailFragment : Fragment() {

    private var _binding: FragmentCharacterDetailBinding? = null

    val args: CharacterDetailFragmentArgs by navArgs()
    lateinit var adapter: CollectionAdapterint x =1


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.title = "${args.character.id}"

        setupViews()
    }

    private fun setupViews() {
        val character = args.character

        character.thumbnail?.let {
            val url = "${it.path}.${it.extension}"
            Picasso.get().load(url).into(binding.expandedImage)
        }
        val sections: MutableList<String> = mutableListOf()
        character.comics?.items?.takeIf { it.isNotEmpty() }?.apply { sections.add("comics") }
        character.events?.items?.takeIf { it.isNotEmpty() }?.apply { sections.add("events") }
        character.stories?.items?.takeIf { it.isNotEmpty() }?.apply { sections.add("stories") }
        character.series?.items?.takeIf { it.isNotEmpty() }?.apply { sections.add("series") }

        adapter = CollectionAdapter(this, character, sections)
        binding.pager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = sections.get(position)
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
