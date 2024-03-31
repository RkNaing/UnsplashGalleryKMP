@file:OptIn(ExperimentalResourceApi::class)

package com.rkzmn.kmp.unsplashgallery.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rkzmn.kmp.unsplashgallery.utils.app.Drawables
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import unsplashgallerykmp.composeapp.generated.resources.Res
import unsplashgallerykmp.composeapp.generated.resources.img_placeholder

@Composable
fun NetworkImage(
    url: String,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
    placeholder: DrawableResource = Res.drawable.img_placeholder,
    error: DrawableResource = placeholder,
    alignment: Alignment = Alignment.Center,
    modifier: Modifier = Modifier
) {
    NetworkImage(
        url = url,
        contentDescription = contentDescription,
        contentScale = contentScale,
        onLoading = {
            NetworkImageDefaults.ImagePlaceholder(
                placeholder = placeholder,
                contentDescription = contentDescription,
                contentScale = contentScale,
                modifier = Modifier.fillMaxSize()
            )
        },
        onFailure = {
            NetworkImageDefaults.ImagePlaceholder(
                placeholder = error,
                contentDescription = contentDescription,
                contentScale = contentScale,
                modifier = Modifier.fillMaxSize()
            )
        },
        alignment = alignment,
        modifier = modifier
    )
}

@Composable
fun NetworkImage(
    url: String,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
    onLoading: @Composable (BoxScope.(Float) -> Unit)? = null,
    onFailure: @Composable (BoxScope.(Throwable) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    modifier: Modifier = Modifier
) {
    if (LocalInspectionMode.current) {
        NetworkImageDefaults.ImagePlaceholder(
            placeholder = Drawables.img_placeholder,
            contentDescription = contentDescription,
            contentScale = contentScale,
            alignment = alignment,
            modifier = modifier
        )
    } else {
        KamelImage(
            modifier = modifier,
            resource = asyncPainterResource(data = url),
            contentDescription = contentDescription,
            contentScale = contentScale,
            alignment = alignment,
            onLoading = onLoading,
            onFailure = onFailure
        )
    }
}

object NetworkImageDefaults {

    @Composable
    fun ImagePlaceholder(
        placeholder: DrawableResource,
        contentDescription: String? = null,
        contentScale: ContentScale = ContentScale.Fit,
        alignment: Alignment = Alignment.Center,
        modifier: Modifier = Modifier
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(resource = placeholder),
            contentDescription = contentDescription,
            alignment = alignment,
            contentScale = contentScale
        )
    }

    @Composable
    fun ProgressPlaceholder(
        progress: Float,
        modifier: Modifier = Modifier
    ) {
        CircularProgressIndicator(
            modifier = modifier,
            progress = { progress }
        )
    }

    @Composable
    fun ErrorIndicator(
        title: String? = null,
        message: String,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier.padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.CenterVertically
            )
        ) {

            if (!title.isNullOrBlank()) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = message,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}