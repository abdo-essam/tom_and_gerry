package com.ae.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Define colors from style guide
val PrimaryPink = Color(0xFFFF7074)
val SecondaryPink = Color(0xFFFF9494)
val LightPink = Color(0xFFFED8DF)
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Gray = Color(0xFF585858)

// Inter Font Family (add these font files to res/font/ or use default system font)
val InterFontFamily = FontFamily.Default // Replace with InterFontFamily when you add the fonts

// Donut data class for positioning
data class DonutItem(
    val imageRes: Int,
    val offsetX: Float,
    val offsetY: Float,
    val size: Float,
    val rotation: Float,
    val animationDelay: Int
)

@Composable
fun DonutsOnboardingScreen(
    onGetStartedClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightPink) // Solid LightPink background
    ) {
        // TOP LEFT - Purple donut with sprinkles
        Image(
            painter = painterResource(id = R.drawable.donut_purple),
            contentDescription = null,
            modifier = Modifier
                .size(186.dp)
                .offset(
                    x = (-20).dp,
                    y = (-5).dp
                )
                .rotate(15f),
            contentScale = ContentScale.Fit
        )

        // DONUTS COLLECTION - Exact Figma specifications
        Image(
            painter = painterResource(id = R.drawable.donuts_collection),
            contentDescription = null,
            modifier = Modifier
                .size(width = 500.dp, height = 600.dp),
            contentScale = ContentScale.FillBounds
        )

        // TOP RIGHT - Large pink glazed donut
        Image(
            painter = painterResource(id = R.drawable.donut_pink_glazed),
            contentDescription = null,
            modifier = Modifier
                .height(155.dp)
                .width(210.dp)
                .offset(
                    x = 180.dp,
                    y = 60.dp
                ),
        )


        // BOTTOM LEFT - Small glazed donut
        Image(
            painter = painterResource(id = R.drawable.donut_pink_glazed),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .offset(
                    x = 20.dp,
                    y = 360.dp
                )
                .rotate(75f),
            contentScale = ContentScale.Fit
        )

        // BOTTOM RIGHT - Donut pieces/crumbs
        Image(
            painter = painterResource(id = R.drawable.donut_pieces),
            contentDescription = null,
            modifier = Modifier
                .height(165.dp)
                .width(209.dp)
                .offset(
                    x = 300.dp,
                    y = 430.dp
                )
                .rotate(-10f),
            contentScale = ContentScale.Fit
        )

        // CONTENT SECTION - Bottom portion
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            // Main Title
            Text(
                text = "Gonuts\nwith\nDonuts",
                fontSize = 54.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = InterFontFamily,
                color = PrimaryPink,
                modifier = Modifier.padding(bottom = 19.dp)
            )

            // Description text
            Text(
                text = "Gonuts with Donuts is a Sri Lanka dedicated food outlets for specialize manufacturing of Donuts in Colombo, Sri Lanka.",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = SecondaryPink,
                fontFamily = InterFontFamily,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Get Started Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(67.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(White),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    fontFamily = InterFontFamily,
                    text = "Get Started",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Black,
                )
            }
            Spacer(
                modifier = Modifier.height(46.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DonutsOnboardingScreenPreview() {
    DonutsOnboardingScreen()
}

// Usage in your Activity or Navigation
@Composable
fun DonutsApp() {
    MaterialTheme {
        DonutsOnboardingScreen(
            onGetStartedClick = {
                // Handle navigation to next screen
            }
        )
    }
}