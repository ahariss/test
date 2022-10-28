package com.ahariss.test.ui.adapters.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahariss.test.databinding.FragmentListBinding
import com.ahariss.test.mvvm.models.Item
import com.ahariss.test.mvvm.models.MarvelCharacter
import com.ahariss.test.ui.adapters.ItemsAdapter

private const val ARG_OBJECT = "object"

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var marvelCharacter:MarvelCharacter?

        val linearLayoutManager = LinearLayoutManager(requireContext())


        arguments?.takeIf { it.containsKey("character") }?.apply {
            marvelCharacter = getParcelable("character")
            var adapter : ItemsAdapter?
            var items : List<Item> = mutableListOf()
            arguments?.takeIf { it.containsKey("type") }?.apply {
                when (getString("type")){
                     "comics" ->{
                         marvelCharacter?.comics?.items?.let {
                             items = it
                         }
                    }
                    "stories" ->{
                        marvelCharacter?.stories?.items?.let {
                            items = it
                        }
                    }
                    "series" ->{
                        marvelCharacter?.series?.items?.let {
                            items = it
                        }
                    }
                    "events" ->{
                        marvelCharacter?.events?.items?.let {
                            items = it
                        }
                    }
                }
                binding.itemsList.apply {
                    this.layoutManager = linearLayoutManager
                    adapter =  ItemsAdapter(items)
                    this.adapter = adapter
                }

            }
        }
    }
}