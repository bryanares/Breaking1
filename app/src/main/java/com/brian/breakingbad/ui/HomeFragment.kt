package com.brian.breakingbad.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.brian.breakingbad.R
import com.brian.breakingbad.databinding.FragmentHomeBinding
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {
    private val viewModel: BreakingBadViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel.getCharacter()

        var character = viewModel.getCharacter().value

        binding.lifecycleOwner = this

        Picasso.get().load(character?.get(0)?.img).into(binding.bBadImageView)
        binding.bBadName.text = character?.get(0)?.name.toString()
        binding.bBadNickname.text = character?.get(0)?.nickname.toString()


        binding.refreshButton.setOnClickListener {

            try {

                for (i in character?.indices!!) {
                    Picasso.get().load(viewModel.getCharacter().value?.get(i)?.img).into(binding.bBadImageView)
                    binding.bBadName.text = viewModel.getCharacter().value?.get(i)?.name.toString()
                    binding.bBadNickname.text = viewModel.getCharacter().value?.get(i)?.nickname.toString()

                    Log.d("HomeFragment",
                        viewModel.getCharacter().value?.get(i)?.nickname.toString()
                    )
                }

            } catch (e: Exception) {
                Log.e("HomeFragment", e.toString())
            }
        }
        val view = binding.root
        return view
    }
}