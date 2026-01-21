package com.codewithmehyo.androidtestatg.ui.features.player

import androidx.lifecycle.ViewModel
import androidx.media3.exoplayer.ExoPlayer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel for the player screen.
 */
@HiltViewModel
class PlayerViewModel @Inject constructor(

) : ViewModel() {
    // A state flow to keep track of whether the player is currently playing.
    private val _isPlaying = MutableStateFlow(true)
    /**
     * A state flow that emits true if the player is playing, false otherwise.
     */
    val isPlaying: StateFlow<Boolean> = _isPlaying

    /**
     * Toggles the playback of the video.
     *
     * @param player The ExoPlayer instance.
     */
    fun togglePlay(player: ExoPlayer) {
        player.playWhenReady = !player.isPlaying
        _isPlaying.value = player.isPlaying
    }
}