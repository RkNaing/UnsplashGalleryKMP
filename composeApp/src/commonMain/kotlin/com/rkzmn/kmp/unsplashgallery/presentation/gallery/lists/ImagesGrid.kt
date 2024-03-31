package com.rkzmn.kmp.unsplashgallery.presentation.gallery.lists

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rkzmn.kmp.unsplashgallery.presentation.gallery.ImageItemData
import com.rkzmn.kmp.unsplashgallery.presentation.gallery.item.GridImageItem
import com.rkzmn.kmp.unsplashgallery.presentation.gallery.item.gridImageItemWidth
import kotlinx.collections.immutable.ImmutableList

@Composable
fun ImagesGrid(
    modifier: Modifier = Modifier,
    onClick: (ImageItemData) -> Unit,
    images: ImmutableList<ImageItemData>
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = gridImageItemWidth)
    ) {

        items(
            items = images,
            key = { data -> data.id },
            contentType = { CONTENT_TYPE_IMAGE }
        ) { data ->
            GridImageItem(
                onClick = onClick,
                data = data
            )
        }

    }
}

private const val CONTENT_TYPE_IMAGE = "Image"