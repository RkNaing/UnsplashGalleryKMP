package com.rkzmn.kmp.unsplashgallery.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import androidx.compose.material3.Typography
import unsplashgallerykmp.composeapp.generated.resources.Res
import unsplashgallerykmp.composeapp.generated.resources.poppins_black
import unsplashgallerykmp.composeapp.generated.resources.poppins_black_italic
import unsplashgallerykmp.composeapp.generated.resources.poppins_bold
import unsplashgallerykmp.composeapp.generated.resources.poppins_bold_italic
import unsplashgallerykmp.composeapp.generated.resources.poppins_extra_bold
import unsplashgallerykmp.composeapp.generated.resources.poppins_extra_bold_italic
import unsplashgallerykmp.composeapp.generated.resources.poppins_italic
import unsplashgallerykmp.composeapp.generated.resources.poppins_light
import unsplashgallerykmp.composeapp.generated.resources.poppins_light_italic
import unsplashgallerykmp.composeapp.generated.resources.poppins_medium
import unsplashgallerykmp.composeapp.generated.resources.poppins_medium_italic
import unsplashgallerykmp.composeapp.generated.resources.poppins_regular
import unsplashgallerykmp.composeapp.generated.resources.poppins_semibold
import unsplashgallerykmp.composeapp.generated.resources.poppins_semibold_italic
import unsplashgallerykmp.composeapp.generated.resources.poppins_thin
import unsplashgallerykmp.composeapp.generated.resources.poppins_thin_italic

val poppinsTypography: Typography
    @Composable
    get() = createTypography()

@Composable
private fun createTypography(): Typography {
    val montserratAlternates = poppinsFontFamily

    val defaultTypography = Typography()

    return Typography(

        displayLarge = defaultTypography.displayLarge.copy(fontFamily = montserratAlternates),
        displayMedium = defaultTypography.displayMedium.copy(fontFamily = montserratAlternates),
        displaySmall = defaultTypography.displaySmall.copy(fontFamily = montserratAlternates),

        headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = montserratAlternates),
        headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = montserratAlternates),
        headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = montserratAlternates),

        titleLarge = defaultTypography.titleLarge.copy(fontFamily = montserratAlternates),
        titleMedium = defaultTypography.titleLarge.copy(fontFamily = montserratAlternates),
        titleSmall = defaultTypography.titleLarge.copy(fontFamily = montserratAlternates),

        bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = montserratAlternates),
        bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = montserratAlternates),
        bodySmall = defaultTypography.bodySmall.copy(fontFamily = montserratAlternates),

        labelLarge = defaultTypography.labelLarge.copy(fontFamily = montserratAlternates),
        labelMedium = defaultTypography.labelMedium.copy(fontFamily = montserratAlternates),
        labelSmall = defaultTypography.labelSmall.copy(fontFamily = montserratAlternates)
    )
}

@OptIn(ExperimentalResourceApi::class)
private val poppinsFontFamily: FontFamily
    @Composable
    get() = FontFamily(
        Font(
            resource = Res.font.poppins_thin,
            weight = FontWeight.Thin,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.poppins_thin_italic,
            weight = FontWeight.Thin,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.poppins_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.poppins_light_italic,
            weight = FontWeight.Light,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.poppins_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.poppins_italic,
            weight = FontWeight.Normal,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.poppins_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.poppins_medium_italic,
            weight = FontWeight.Medium,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.poppins_semibold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.poppins_semibold_italic,
            weight = FontWeight.SemiBold,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.poppins_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.poppins_bold_italic,
            weight = FontWeight.Bold,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.poppins_extra_bold,
            weight = FontWeight.ExtraBold,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.poppins_extra_bold_italic,
            weight = FontWeight.ExtraBold,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.poppins_black,
            weight = FontWeight.Black,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.poppins_black_italic,
            weight = FontWeight.Black,
            style = FontStyle.Italic,
        )
    )