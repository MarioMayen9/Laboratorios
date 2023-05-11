package com.example.laboratorio5.ui.movie.billboard

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.laboratorio5.R
import com.example.laboratorio5.data.model.MovieModel
import com.example.laboratorio5.databinding.FragmentBillboardBinding
import com.example.laboratorio5.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.example.laboratorio5.ui.movie.viewmodel.MovieViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {
    private lateinit var actionNavToCreateMovie: FloatingActionButton
    private lateinit var actionNavToMovie: CardView
    private lateinit var actionHarryPotterNavToMovie: CardView
    private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory

    }

    private lateinit var binding: FragmentBillboardBinding
    private lateinit var adapter:MovieRecyclerViewAdapter


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
        setupRecyclerView(view)

        actionNavToCreateMovie.setOnClickListener {
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovie)
        }

       // actionNavToMovie.setOnClickListener{
       //     it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        //}


    }
    private fun bind(view: View) {
        actionNavToCreateMovie = view.findViewById(R.id.action_to_create_movie)
        //actionNavToMovie = view.findViewById(R.id.action_billboardFragment_to_movieFragment)

    }

    private fun showSelectedItem(movie: MovieModel){
        viewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }



    private fun displayMovies(){
        adapter.setData(viewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setupRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = MovieRecyclerViewAdapter{
                selectedMovie -> showSelectedItem(selectedMovie)
        }

        Log.d("TAG NameApp", viewModel.name.toString())

        binding.recyclerView.adapter = adapter
        displayMovies()
    }


}