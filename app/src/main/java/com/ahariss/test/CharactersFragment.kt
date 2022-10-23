package com.ahariss.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ahariss.test.databinding.FragmentCharactersBinding
import com.ahariss.test.mvvm.data.network.Resource
import com.ahariss.test.utils.visible
import com.ahariss.test.viewmodels.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null

    private val binding get() = _binding!!

    private val viewModel: CharactersViewModel by viewModels()


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

        setupObservers()
    }

    private fun getData() {
        viewModel.getCharacters()
    }

    private fun setupObservers() {

        viewModel.api.observe(viewLifecycleOwner, Observer {
            binding.loader.root.visible(it is Resource.Loading)
            when (it){
                is Resource.Failure -> {

                }
                Resource.Initial -> viewModel.getCharacters()

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