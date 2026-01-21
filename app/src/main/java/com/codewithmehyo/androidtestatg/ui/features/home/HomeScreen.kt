package com.codewithmehyo.androidtestatg.ui.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.codewithmehyo.androidtestatg.ui.components.HorizontalCarousel
import com.codewithmehyo.androidtestatg.ui.features.home.model.MediaItemUI
import com.codewithmehyo.androidtestatg.ui.components.SubscriptionCard
import com.codewithmehyo.androidtestatg.ui.components.TopCarousel
import com.codewithmehyo.androidtestatg.ui.components.VerticalCarousel

/**
 * The main screen of the application.
 *
 * @param modifier The modifier to be applied to the screen.
 * @param isSubscribed Whether the user is subscribed or not.
 * @param onSubscriptionClick The callback to be invoked when the subscription card is clicked.
 * @param onItemClick The callback to be invoked when a media item is clicked.
 * @param topItems The list of media items to be displayed in the top carousel.
 * @param verticalItems The list of media items to be displayed in the vertical carousel.
 * @param horizontalItems The list of media items to be displayed in the horizontal carousel.
 */
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    isSubscribed: Boolean,
    onSubscriptionClick : () -> Unit = {},
    onItemClick: (mediaUrl:String, adTagUrl:String) -> Unit = {_,_->},
    topItems: List<MediaItemUI> = listOf(),
    verticalItems: List<MediaItemUI> = listOf(),
    horizontalItems: List<MediaItemUI> = listOf()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(
                state = rememberScrollState(),
                enabled = true
            )
    ) {
        Spacer(Modifier.height(24.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "Home",
            style = MaterialTheme.typography.displayLarge,
            color = Color.White
        )
        Spacer(Modifier.height(24.dp))
        SubscriptionCard(
            modifier = Modifier.padding(start = 16.dp),
            onSubscriptionClick = onSubscriptionClick,
            isSubscribed = isSubscribed
        )
        Spacer(Modifier.height(32.dp))
        TopCarousel(
            onMediaClick = onItemClick,
            items = topItems
        )
        Spacer(Modifier.height(32.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "Vertical Images",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(24.dp))
        VerticalCarousel(
            onMediaClick = onItemClick,
            items = verticalItems
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "Horizontal Images",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
        Spacer(Modifier.height(32.dp))
        HorizontalCarousel(
            onMediaClick = onItemClick,
            items = horizontalItems
        )
        Spacer(Modifier.height(32.dp))
    }
}
