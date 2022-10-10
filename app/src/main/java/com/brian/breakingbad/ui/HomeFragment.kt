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
        binding.bBadOccupation.text = character?.get(0)?.occupation?.get(0).toString()
        binding.bBadActor.text = character?.get(0)?.portrayed.toString()
        binding.bBadBirthday.text = character?.get(0)?.birthday.toString()
        binding.bBadStatus.text = character?.get(0)?.status.toString()
        binding.bBadAppearance.text = character?.get(0)?.category.toString()


        binding.refreshButton.setOnClickListener {

            try {

                for (i in character?.indices!!) {
                    Picasso.get().load(viewModel.getCharacter().value?.get(i)?.img)
                        .into(binding.bBadImageView)
                    binding.bBadName.text = viewModel.getCharacter().value?.get(i)?.name.toString()
                    binding.bBadNickname.text =
                        viewModel.getCharacter().value?.get(i)?.nickname.toString()
                    binding.bBadOccupation.text =
                        viewModel.getCharacter().value?.get(i)?.occupation?.get(i).toString()
                    binding.bBadActor.text =
                        viewModel.getCharacter().value?.get(i)?.portrayed.toString()
                    binding.bBadBirthday.text =
                        viewModel.getCharacter().value?.get(i)?.birthday.toString()
                    binding.bBadStatus.text =
                        viewModel.getCharacter().value?.get(i)?.status.toString()
                    binding.bBadAppearance.text =
                        viewModel.getCharacter().value?.get(i)?.category.toString()

                    Log.d(
                        "HomeFragment",
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