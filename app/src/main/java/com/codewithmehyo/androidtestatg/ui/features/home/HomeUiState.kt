package com.codewithmehyo.androidtestatg.ui.features.home

import com.codewithmehyo.androidtestatg.ui.features.home.model.MediaItemUI

data class HomeUiState(
    val isSubscribed: Boolean = false,
    val horizontalItems: List<MediaItemUI> = emptyList(),
    val verticalItems: List<MediaItemUI> = emptyList(),
    val topItems: List<MediaItemUI> = emptyList(),
)