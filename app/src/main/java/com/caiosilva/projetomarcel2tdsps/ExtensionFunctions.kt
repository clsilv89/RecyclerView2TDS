package com.caiosilva.projetomarcel2tdsps

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.setImageFromUrl(url: String) {
    Picasso.get().load(url).into(this)
}