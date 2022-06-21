package com.mokhtar.androidmoviestask.ui.home.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.mokhtar.trendsmovietask.R
import com.mokhtar.trendsmovietask.util.ConfigurationStore


@BindingAdapter("file_path")
fun ImageView.loadImageUrl(file_path: String) {


        val baseUrl = ConfigurationStore.getConfigurationData().images.secureBaseUrl
        val completeUrl = "${baseUrl}original$file_path"

        load(completeUrl)
        {
            error(R.drawable.ic_place_holder)
            transformations(RoundedCornersTransformation())
            crossfade(600)
            scale(coil.size.Scale.FILL)
        }

}