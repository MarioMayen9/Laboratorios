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
    ): View {
        binding = FragmentNewMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        setObserver()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }


    private fun setObserver() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    val mylist = viewModel.getMovies().reversed()
                    Log.d("TAG APP", status)
                    Log.d("TAG APP", mylist.toString())
                    viewModel.clearStatus()
                    viewModel.clearData()
                    findNavController().popBackStack()
                }
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d("TAG APP", status)
                    viewModel.clearStatus()
                }
            }
        }
    }



}