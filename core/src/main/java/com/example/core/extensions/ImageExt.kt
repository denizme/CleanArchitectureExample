package com.example.core.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.load(resId: String, centerCrop: Boolean = true, fit: Boolean = true) {
    Picasso.get()
        .load(resId)
        .also { if (centerCrop) it.centerCrop() }
        .also { if (fit) it.fit() }
        .into(this)
}