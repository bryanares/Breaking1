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
    private val viewModel :BreakingBadViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel.getCharacter()

        val characterList = viewModel.getCharacter()
        var character = ""


        for (i in characterList.value!!){
            character = i.toString()
        }

        binding.lifecycleOwner = this

//        Picasso.get().load(character?.img).into(binding.bBadImageView)
        binding.bBadName.text = character?.name
        binding.bBadNickname.text = character?.nickname


        binding.refreshButton.setOnClickListener {

            try {
                Toast.makeText(context, "Refreshed", Toast.LENGTH_LONG).show()
//                Picasso.get().load(character?.img).into(binding.bBadImageView)
                binding.bBadName.text = character?.name
                binding.bBadNickname.text = character?.nickname.toString()
                Log.d("Try Block", character?.nickname.toString())
            }catch (e: Exception){
                Log.e("HomeFragment", e.toString())
            }


        }

        val view = binding.root
        return view
    }
}