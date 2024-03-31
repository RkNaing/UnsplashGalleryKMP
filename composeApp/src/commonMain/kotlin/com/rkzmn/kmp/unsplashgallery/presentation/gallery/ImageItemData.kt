package com.rkzmn.kmp.unsplashgallery.presentation.gallery

import androidx.compose.runtime.Immutable

@Immutable
data class ImageItemData(
    val id: String,
    val imageUrl: String,
    val aspectRatio: Float,
    val description: String?,
    val shortDescription: String?
)
