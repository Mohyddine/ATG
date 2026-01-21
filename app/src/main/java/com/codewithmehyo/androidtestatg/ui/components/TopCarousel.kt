package com.codewithmehyo.androidtestatg.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Button
import androidx.tv.material3.Carousel
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.codewithmehyo.androidtestatg.ui.features.home.model.MediaItemUI

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun TopCarousel(
    modifier: Modifier = Modifier,
    onMediaClick: (mediaUrl:String, adTagUrl:String) -> Unit = {_,_->},
    items: List<MediaItemUI>
) {
    Carousel(
        itemCount = items.size,
        modifier = modifier
            .fillMaxWidth()
            .height(376.dp),

        ) { indexOfCarouselItem ->
        val featuredMovie = items[indexOfCarouselItem]
        val backgroundColor = MaterialTheme.colorScheme.background
        Box {
            AsyncImage(
                model = featuredMovie.imageUrl,
                contentDescription = null,
                placeholder = painterResource(
                    id = featuredMovie.imagePlaceHolder
                ),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
            Box(
                contentAlignment = Alignment.BottomStart,
                modifier = Modifier
                    .fillMaxSize()
                    .drawBehind {
                        val brush = Brush.horizontalGradient(
                            listOf(backgroundColor, Color.Transparent)
                        )
                        drawRect(brush)
                    }
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = featuredMovie.title,
                        style = MaterialTheme.typography.displaySmall
                    )
                    Spacer(modifier = Modifier.height(28.dp))
                    Button(
                        onClick = {
                            onMediaClick(
                                featuredMovie.videoUrl,
                                featuredMovie.adUrl
                            )
                        }
                    ) {
                        Text(text = "Play Now")
                    }
                }
            }
        }
    }
}
