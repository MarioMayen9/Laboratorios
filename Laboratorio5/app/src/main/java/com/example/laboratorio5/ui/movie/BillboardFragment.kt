package com.example.laboratorio5.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.laboratorio5.R
import com.example.laboratorio5.databinding.FragmentBillboardBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {
    private lateinit var actionNavToCreateMovie: FloatingActionButton
    private lateinit var actionNavToMovie: CardView
    private lateinit var actionHarryPotterNavToMovie: CardView

    private lateinit var binding: FragmentBillboardBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBillboardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind(view)

        actionNavToCreateMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovie)
        }
        actionNavToMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }
        actionHarryPotterNavToMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieHarryPotter)
        }
    }
    private fun bind(view: View) {
        actionNavToCreateMovie = view.findViewById(R.id.action_to_create_movie)
        actionNavToMovie = view.findViewById(R.id.movie_card)
        actionHarryPotterNavToMovie = view.findViewById(R.id.movie_card2)

    }

}