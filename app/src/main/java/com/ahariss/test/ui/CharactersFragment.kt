package com.ahariss.test.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahariss.test.databinding.FragmentCharactersBinding
import com.ahariss.test.mvvm.data.network.Resource
import com.ahariss.test.mvvm.di.MainAcitvityImp
import com.ahariss.test.ui.adapters.CharacterAdapter
import com.ahariss.test.utils.visible
import com.ahariss.test.viewmodels.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    @Inject
    lateinit var mainAcitvityImp: MainAcitvityImp

    private var _binding: FragmentCharactersBinding? = null

    private val binding get() = _binding!!

    private val viewModel: CharactersViewModel by viewModels()


    lateinit var adapter : CharacterAdapter

    private lateinit var linearLayoutManager : LinearLayoutManager


    private val lastVisibleItemPosition: Int
        get() = linearLayoutManager.findLastVisibleItemPosition()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/


        setupUI()

        setupObservers()
    }

    private fun setupUI() {
        adapter = CharacterAdapter(mainAcitvityImp.callback)
        linearLayoutManager = LinearLayoutManager(requireContext())
        binding.list.apply {
            this.layoutManager = linearLayoutManager
            this.adapter = adapter
        }

        binding.list.adapter = adapter

        initScrollListener();

    }

    private fun initScrollListener() {
        binding.list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val totalItemCount = recyclerView.layoutManager!!.itemCount
                if (totalItemCount == lastVisibleItemPosition + 1) {
                    getData()
                }
            }
        })
    }


    private fun getData() {
        viewModel.getCharacters()
    }

    private fun setupObservers() {

        viewModel.characters.observe(viewLifecycleOwner, Observer {
            it?.let { characters ->
                adapter.setCharactersList(characters)
            }
        })

        viewModel.api.observe(viewLifecycleOwner, Observer {
            binding.loader.root.visible(it is Resource.Loading)
            when (it){
                is Resource.Failure -> {

                }
                Resource.Initial -> viewModel.getCharacters(true)
                is Resource.Success -> {

                }
                else -> {
                    //nothing
                }
            }
        })

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}