package com.example.laboratorio5.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio5.R
import com.example.laboratorio5.data.model.MovieModel
import com.example.laboratorio5.databinding.FragmentNewMovieBinding


class NewMovieFragment : Fragment() {
        private lateinit var binding: FragmentNewMovieBinding
        private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory

        }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitActionButton.setOnClickListener {
            createMovie()
        }
    }

    private fun createMovie() {
        val newMovie = MovieModel(
            binding.nameEditText.text.toString(),
            binding.categoryEditText.text.toString(),
            binding.descriptionEditText.text.toString(),
            binding.calificationEditText.text.toString()
        )

        viewModel.addMovies(newMovie)
        val mylist = viewModel.getMovies().reversed()
        Log.d("My movie list", mylist.toString())

        findNavController().popBackStack()

    }





}