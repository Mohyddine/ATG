package com.codewithmehyo.androidtestatg.ui.features.player

data class PlayerUiState(
    val isPlaying: Boolean = true,
    val currentPosition: Long = 0L,
    val duration: Long = 0L
)