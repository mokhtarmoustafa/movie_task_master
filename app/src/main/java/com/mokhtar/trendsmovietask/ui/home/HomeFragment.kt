package com.mokhtar.trendsmovietask.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.mokhtar.androidmoviestask.data.remote.model.movie.Movie
import com.mokhtar.trendsmovietask.R
import com.mokhtar.trendsmovietask.databinding.HomeFragmentBinding
import com.mokhtar.trendsmovietask.ui.base.BaseFragment
import com.mokhtar.trendsmovietask.ui.home.adapter.MoviesAdapter
import com.mokhtar.trendsmovietask.util.ConfigurationStore
import com.mokhtar.trendsmovietask.util.State
import com.mokhtar.trendsmovietask.util.checkForInternet
import com.mokhtar.trendsmovietask.util.showToast

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>(),
    MoviesAdapter.Interaction {

    //region variables
    override val mViewModel: HomeViewModel by viewModels()

    private val adapter = MoviesAdapter(this)
    //endregion


//region events

    override fun getViewBinding(view: View) = HomeFragmentBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvMovies.adapter = adapter
        if (checkForInternet(requireContext())) {
            if (adapter.itemCount == 0) {
                getConfigurationData()
                getALlMovies()
            } else
                hideShimmerEffect()


        } else
            showToast(getString(R.string.msg_no_internet_connection))


    }

    override fun onItemSelected(position: Int, item: Movie, extra: FragmentNavigator.Extras) {

        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item)
        navigate(action, extra)
    }


    //endregion

    //region helper functions
    private fun getALlMovies() {

        lifecycleScope.launchWhenStarted {
            mViewModel.movieList.collectLatest { it ->
                if (it != null) {
                    hideShimmerEffect()
                    adapter.submitData(it)
                }

            }
        }


    }

    private fun getConfigurationData() {

        lifecycleScope.launchWhenStarted {
            mViewModel.configurationLiveData.collect {
                when (it) {
                    is State.Loading -> {}
                    is State.Success -> {
                        it.data?.let {
                            ConfigurationStore.setConfigurationData(it)
                        }

                    }
                    is State.Error -> {
                        showToast(it.message)
                    }
                }
            }
        }
        mViewModel.getConfigurationData()

    }

    private fun hideShimmerEffect() {
        binding.apply {
            shimmerView.stopShimmer()
            shimmerView.visibility = View.GONE
            rvMovies.visibility = View.VISIBLE
            gEmpty.visibility = View.GONE
        }

    }

    private fun navigate(destination: NavDirections, extraInfo: FragmentNavigator.Extras) =
        with(findNavController()) {
            currentDestination?.getAction(destination.actionId)
                ?.let {
                    navigate(destination, extraInfo)
                }
        }

    //endregion


    companion object {
        fun newInstance() = HomeFragment()
        private const val TAG = "HomeFragment"
    }


}