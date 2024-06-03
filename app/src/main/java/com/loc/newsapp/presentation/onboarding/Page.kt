package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int

)

val pages = listOf<Page>(
    Page(
        title = "Stay Informed,\nStay Empowered",
        description = "Get the latest news from around the world, delivered straight to your device",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Personalized for You",
        description = "Discover news tailored to your interests",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Dive Deeper",
        description = "Go beyond headlines with our in-depth articles and analysis",
        image = R.drawable.onboarding3
    )
)