package com.mokhtar.trendsmovietask.ui.detail

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mokhtar.trendsmovietask.databinding.FragmentDetailsBinding
import com.mokhtar.trendsmovietask.ui.base.BaseFragment

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<DetailsViewModel, FragmentDetailsBinding>() {

    //region variables
    override val mViewModel: DetailsViewModel by viewModels()
    private val args: DetailsFragmentArgs by navArgs()
    //endregion

    //region events

    override fun getViewBinding(view: View) = FragmentDetailsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMovieDetails()

        binding.apply {
            ivBack.setOnClickListener { findNavController().navigateUp() }
        }
    }

    //endregion

    //region helper functions

    private fun getMovieDetails() {
        args.let {
            binding.movie = it.movieData

            val transition = TransitionInflater.from(requireContext())
                .inflateTransition(android.R.transition.move)
            sharedElementEnterTransition = transition
            sharedElementReturnTransition = transition

        }
    }


    //endregion

}