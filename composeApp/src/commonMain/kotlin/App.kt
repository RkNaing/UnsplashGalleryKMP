import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.rkzmn.kmp.unsplashgallery.presentation.common.components.NetworkImage
import com.rkzmn.kmp.unsplashgallery.presentation.theme.UnsplashGalleryTheme
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import unsplashgallerykmp.composeapp.generated.resources.Res
import unsplashgallerykmp.composeapp.generated.resources.compose_multiplatform
import unsplashgallerykmp.composeapp.generated.resources.img_placeholder

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    UnsplashGalleryTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    NetworkImage(
                        url = "https://unsplash.com/photos/9HRHn_41IgY/download?ixid=M3wxMjA3fDB8MXxhbGx8NXx8fHx8fDJ8fDE3MTE4Nzc0MDh8&force=true",
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        placeholder = Res.drawable.img_placeholder,
                        modifier = Modifier.fillMaxWidth(0.5f).aspectRatio(2160 /3840f)
                    )
                    Text("Compose: $greeting")
                }
            }
        }
    }
}