package com.mokhtar.androidmoviestask.ui.home.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.mokhtar.trendsmovietask.R
import com.mokhtar.trendsmovietask.util.IMAGE_BASE_URL


@BindingAdapter("base_url", "file_path", "image_size")
fun ImageView.loadImageUrl(base_url: String, file_path: String, image_size: String) {

    if (base_url.isNotEmpty()) {

        val size = if (image_size == "1")
            "w300"
        else
            "w500"

        val completeUrl = "$base_url$size$file_path"
        println("ImageView - $completeUrl")
        load(completeUrl)
        {
            error(R.drawable.ic_place_holder)
            crossfade(100)
        }
    }
}

@BindingAdapter("file_path")
fun ImageView.loadImageUrl(file_path: String) {
    if(!file_path.isNullOrEmpty())
    {
        val completeUrl = "$IMAGE_BASE_URL$file_path"

        println("ImageView - $completeUrl")

        load(completeUrl)
        {
            error(R.drawable.ic_place_holder)
            transformations(RoundedCornersTransformation())
            crossfade(600)
            scale(coil.size.Scale.FILL)
        }
    }

}