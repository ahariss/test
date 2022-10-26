package com.ahariss.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.ahariss.test.databinding.FragmentCharacterDetailBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CharacterDetailFragment : Fragment() {

    private var _binding: FragmentCharacterDetailBinding? = null

    val args: CharacterDetailFragmentArgs by navArgs()


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


//        requireActivity().actionBar?.setTitle(args.character.id?.toString())
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "${args.character.id}"



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}