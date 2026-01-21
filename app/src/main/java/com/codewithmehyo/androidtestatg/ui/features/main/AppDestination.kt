package com.codewithmehyo.androidtestatg.ui.features.main

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppDestination {

    @Serializable
    data object Home : AppDestination

    @Serializable
    data class Player(val mediaUrl: String, val adTagUrl: String) : AppDestination
}