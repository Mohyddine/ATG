package com.codewithmehyo.androidtestatg.ui.features.home.model

data class MediaItemUI(
    val id: Int,
    val title: String,
    val imagePlaceHolder: Int,
    val imageUrl: String? = null,
    val videoUrl: String,
    val adUrl: String,
)