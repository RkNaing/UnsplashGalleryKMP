package com.rkzmn.kmp.unsplashgallery.presentation.common.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.rkzmn.kmp.unsplashgallery.presentation.theme.isAppInDarkTheme
import com.rkzmn.kmp.unsplashgallery.presentation.theme.seed

/**
 * Composable function that uses card for dark theme and elevated card for light theme.
 *
 * @param darkTheme Flag indicating whether the app is in dark theme mode. Defaults to [isAppInDarkTheme].
 * @param isSelected Flag indicating whether the card is selected. Defaults to `false`.
 * @param enabled Flag indicating whether the card is enabled. Defaults to `true`.
 * @param shape The shape of the card. Defaults to [CardDefaults.shape].
 * @param interactionSource The [MutableInteractionSource] to handle user interaction. Defaults to a new instance.
 * @param modifier The modifier for this composable.
 * @param onClick Lambda function to be executed when the card is clicked. Defaults to an empty lambda.
 * @param content Lambda function representing the content of the card.
 */
@Composable
fun AppCard(
    darkTheme: Boolean = isAppInDarkTheme,
    isSelected: Boolean = false,
    enabled: Boolean = true,
    shape: Shape = CardDefaults.shape,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    val cardColors: CardColors
    val cardElevation: CardElevation

    if (darkTheme) {
        cardColors = CardDefaults.cardColors()
        cardElevation = CardDefaults.cardElevation()
    } else {
        cardColors = CardDefaults.elevatedCardColors()
        cardElevation = CardDefaults.elevatedCardElevation()
    }


    Card(
        modifier = modifier.testTag(
            tag = if (isSelected) TEST_TAG_APP_CARD_SELECTED else TEST_TAG_APP_CARD
        ),
        onClick = onClick,
        border = if (isSelected) BorderStroke(1.dp, color = seed) else null,
        colors = cardColors,
        elevation = cardElevation,
        shape = shape,
        enabled = enabled,
        interactionSource = interactionSource,
        content = content
    )
}

const val TEST_TAG_APP_CARD_SELECTED = "AppCardSelected"
const val TEST_TAG_APP_CARD = "AppCard"