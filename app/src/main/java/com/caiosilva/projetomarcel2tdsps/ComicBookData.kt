package com.caiosilva.projetomarcel2tdsps

data class ComicBookData(
    val id: Int,
    val title: String,
    val description: String,
    val pageCount: Int,
    val imageUrl: String,
    val isHero: Boolean? = null
)
