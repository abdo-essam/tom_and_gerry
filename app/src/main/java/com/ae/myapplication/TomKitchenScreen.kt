package com.ae.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
fun TomKitchenScreenPreview() {
    MaterialTheme {
        TomKitchenScreen()
    }
}

@Composable
fun TomKitchenScreen() {
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_bold, FontWeight.Bold),
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium),
        Font(R.font.ibm_plex_sans_arabic_regular, FontWeight.Normal),
        Font(R.font.ibm_plex_sans_arabic_semibold, FontWeight.SemiBold)
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF2F7FA))
                .verticalScroll(rememberScrollState())
                .padding(bottom = 80.dp) // Space for the fixed button
        ) {
            // Header with tags
            HeaderTags()

            // Food Image
            FoodImage()

            // Food Details Card
            FoodDetailsCard(ibmPlexSansArabic)
        }

        // Fixed Add to Cart Button
        AddToCartButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp),
            ibmPlexSansArabic = ibmPlexSansArabic
        )
    }
}

@Composable
fun HeaderTags() {
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF5A8BA8),
                shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
            )
            .padding(horizontal = 16.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {
            // Tag 1: High tension
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_tag),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "High tension",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = ibmPlexSansArabic,
                    lineHeight = 16.sp
                )
            }

            // Tag 2: Shocking foods
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chef_hat),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Shocking foods",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = ibmPlexSansArabic,
                    lineHeight = 16.sp
                )
            }
        }
    }
}

@Composable
fun FoodImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 32.dp)
            .padding(top = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.electric_pasta),
            contentDescription = "Electric Tom pasta",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun FoodDetailsCard(ibmPlexSansArabic: FontFamily) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            // Title and Price Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Electric Tom pasta",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xDE1F1F1E),
                    fontFamily = ibmPlexSansArabic,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_heart_outline),
                    contentDescription = "Favorite",
                    tint = Color(0xFF03578A),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { /* Handle favorite */ }
                )
            }

            // Price Badge
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(
                        color = Color(0xFFE1F5FE),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cheese),
                    contentDescription = "Cheese",
                    tint = Color(0xFF03578A),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "5 cheeses",
                    fontSize = 12.sp,
                    color = Color(0xFF03578A),
                    fontWeight = FontWeight.Medium,
                    fontFamily = ibmPlexSansArabic
                )
            }

            // Description
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Pasta cooked with a charger cable and sprinkled with questionable cheese. Make sure to unplug it before eating (or not, you decide).",
                fontSize = 14.sp,
                color = Color(0x99121212),
                fontFamily = ibmPlexSansArabic,
                fontWeight = FontWeight.Medium,
                lineHeight = 20.sp
            )

            // Details Section
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Details",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xDE1F1F1E),
                fontFamily = ibmPlexSansArabic,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                DetailCard(
                    icon = R.drawable.ic_temperature,
                    value = "1000 V",
                    label = "Temperature",
                    modifier = Modifier.weight(1f),
                    ibmPlexSansArabic = ibmPlexSansArabic
                )
                DetailCard(
                    icon = R.drawable.ic_timer,
                    value = "3 sparks",
                    label = "Time",
                    modifier = Modifier.weight(1f),
                    ibmPlexSansArabic = ibmPlexSansArabic
                )
                DetailCard(
                    icon = R.drawable.ic_skull,
                    value = "1M 12K",
                    label = "No. of deaths",
                    modifier = Modifier.weight(1f),
                    ibmPlexSansArabic = ibmPlexSansArabic
                )
            }

            // Preparation Method
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Preparation method",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1F2937),
                fontFamily = ibmPlexSansArabic
            )

            Spacer(modifier = Modifier.height(16.dp))

            PreparationStep(1, "Put the pasta in a toaster.", ibmPlexSansArabic)
            PreparationStep(2, "Pour battery juice over it.", ibmPlexSansArabic)
            PreparationStep(3, "Wait for the spark to ignite.", ibmPlexSansArabic)
            PreparationStep(4, "Serve with an insulating glove.", ibmPlexSansArabic)
        }
    }
}

@Composable
fun DetailCard(
    icon: Int,
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    ibmPlexSansArabic: FontFamily
) {
    Card(
        modifier = modifier.height(104.dp),
        shape = RoundedCornerShape(16.dp)   ,
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD0E5F0)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label,
                tint = Color(0xFF035587),
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = value,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF1F2937),
                fontFamily = ibmPlexSansArabic,
                textAlign = TextAlign.Center,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF6B7280),
                fontFamily = ibmPlexSansArabic,
                textAlign = TextAlign.Center,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
            )
        }
    }
}

@Composable
fun PreparationStep(
    stepNumber: Int,
    stepText: String,
    ibmPlexSansArabic: FontFamily
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        // Step Number Circle
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(
                    color = Color(0xFFE1F5FE),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stepNumber.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF03578A),
                fontFamily = ibmPlexSansArabic
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = stepText,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF6B7280),
            fontFamily = ibmPlexSansArabic,
            lineHeight = 20.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun AddToCartButton(
    modifier: Modifier = Modifier,
    ibmPlexSansArabic: FontFamily
) {
    var showStrikethrough by remember { mutableStateOf(false) }

    Button(
        onClick = { showStrikethrough = !showStrikethrough },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF03578A)
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Add to cart",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontFamily = ibmPlexSansArabic
            )

            Spacer(modifier = Modifier.width(16.dp))

            Box {
                // Price text with conditional strikethrough
                Text(
                    text = "5 cheeses",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White.copy(alpha = 0.8f),
                    fontFamily = ibmPlexSansArabic,
                    textDecoration = if (showStrikethrough) TextDecoration.LineThrough else TextDecoration.None
                )

                // Show "3 cheeses" when strikethrough is active
                if (showStrikethrough) {
                    Text(
                        text = "3 cheeses",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontFamily = ibmPlexSansArabic,
                        modifier = Modifier.offset(y = (-20).dp)
                    )
                }
            }
        }
    }
}

// Add these drawable resource IDs to your res/drawable folder:
// - ic_arrow_back (back arrow icon)
// - ic_tag (tag icon)
// - ic_chef_hat (chef hat icon)
// - ic_heart_outline (heart outline icon)
// - ic_temperature (thermometer icon)
// - ic_timer (timer/clock icon)
// - ic_skull (skull icon)
// - electric_pasta (the pasta dish image)