package com.shakiv.pizzjuice.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


object ImageUtils {
    fun setProfileImage(img: String?, view: ImageView) {
        val requestOptions = RequestOptions().transforms(CenterCrop(), RoundedCorners(16))
        Glide.with(view).load(img)
            .centerCrop()
            .skipMemoryCache(false)
            .apply(requestOptions)
            .into(view)
    }
}