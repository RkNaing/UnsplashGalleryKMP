package com.rkzmn.kmp.unsplashgallery.presentation.gallery.item

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rkzmn.kmp.unsplashgallery.presentation.common.components.AppCard
import com.rkzmn.kmp.unsplashgallery.presentation.common.components.NetworkImage
import com.rkzmn.kmp.unsplashgallery.presentation.gallery.ImageItemData
import com.rkzmn.kmp.unsplashgallery.utils.app.Drawables
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import unsplashgallerykmp.composeapp.generated.resources.img_placeholder

// https://dribbble.com/shots/16403749-Unsplash-App-Redesign-Concept/attachments/10183324?mode=media
@OptIn(ExperimentalResourceApi::class)
@Composable
fun GridImageItem(
    modifier: Modifier = Modifier,
    onClick: (ImageItemData) -> Unit,
    data: ImageItemData
) {
    AppCard(
        modifier = modifier.width(gridImageItemWidth).aspectRatio(ratio = data.aspectRatio),
        shape = MaterialTheme.shapes.large,
        onClick = { onClick(data) }
    ) {
        NetworkImage(
            modifier = Modifier.fillMaxWidth(),
            url = data.imageUrl,
            contentDescription = null,
            placeholder = Drawables.img_placeholder
        )
    }
}

val gridImageItemWidth = 180.dp