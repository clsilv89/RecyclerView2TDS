package com.caiosilva.projetomarcel2tdsps

data class ComicBookData(
    val id: Int,
    val title: String,
    val description: String,
    val pageCount: Int,
    val isHero: Boolean? = null
)
