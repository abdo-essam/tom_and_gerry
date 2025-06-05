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
import androidx.compose.ui.draw.clip
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
import androidx.compose.ui.zIndex

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
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF79A4BD)) // Solid background color
    ) {
        // Ellipse shape overlay
        Box(
            modifier = Modifier
                .size(384.75.dp, 414.21.dp)
                .offset(x = (-180).dp, y = (-50).dp)
                .clip(CircleShape)
                .background(Color(0x33035484)) // #035484 with 20% alpha
        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Header Tags
            HeaderTags()

            // Container for overlapping elements
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                // Food Details Card
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 60.dp), // Space for food image
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(bottom = 80.dp) // Space for button
                    ) {
                        FoodDetailsContent(ibmPlexSansArabic)
                    }
                }

                // Food Image overlapping
                Image(
                    painter = painterResource(id = R.drawable.electric_pasta),
                    contentDescription = "Electric Tom pasta",
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.TopEnd)
                        .offset(x = (-20).dp, y = (-100).dp)
                        .zIndex(1f),
                    contentScale = ContentScale.Fit
                )

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
    }
}

@Composable
fun HeaderTags() {
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, top = 48.dp, bottom = 16.dp)
    ) {
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
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "High tension",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = ibmPlexSansArabic
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
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Shocking foods",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = ibmPlexSansArabic
            )
        }
    }
}

@Composable
fun FoodDetailsContent(ibmPlexSansArabic: FontFamily) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(top = 16.dp)
    ) {
        // Title and Heart Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Electric Tom pasta",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 32.sp,
                    color = Color(0xFF1F1F1E).copy(alpha = 0.87f),
                    fontFamily = ibmPlexSansArabic
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Price Badge
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(
                            color = Color(0xFFD0E5F0),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 6.dp)
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
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_heart_outline),
                contentDescription = "Favorite",
                tint = Color(0xFF03578A),
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* Handle favorite */ }
            )
        }

        // Description
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Pasta cooked with a charger cable and sprinkled with questionable cheese. Make sure to unplug it before eating (or not, you decide).",
            fontSize = 14.sp,
            color = Color(0xFF121212).copy(alpha = 0.6f),
            fontFamily = ibmPlexSansArabic,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            letterSpacing = 0.5.sp,
        )

        // Details Section
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Details",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.5.sp,
            lineHeight = 32.sp,
            color = Color(0xFF1F1F1E).copy(alpha = .87f),
            fontFamily = ibmPlexSansArabic
        )

        Spacer(modifier = Modifier.height(8.dp))

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
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Preparation method",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1F1F1E),
            fontFamily = ibmPlexSansArabic
        )

        Spacer(modifier = Modifier.height(20.dp))

        PreparationStep(1, "Put the pasta in a toaster.", ibmPlexSansArabic)
        Spacer(modifier = Modifier.height(16.dp))
        PreparationStep(2, "Pour battery juice over it.", ibmPlexSansArabic)
        Spacer(modifier = Modifier.height(16.dp))
        PreparationStep(3, "Wait for the spark to ignite.", ibmPlexSansArabic, isHighlighted = true)
        Spacer(modifier = Modifier.height(16.dp))
        PreparationStep(4, "Serve with an insulating glove.", ibmPlexSansArabic)
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
        modifier = modifier.height(120.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD0E5F0)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
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
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1F1F1E),
                fontFamily = ibmPlexSansArabic,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF6B7280),
                fontFamily = ibmPlexSansArabic,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun PreparationStep(
    stepNumber: Int,
    stepText: String,
    ibmPlexSansArabic: FontFamily,
    isHighlighted: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        // Step Number Circle
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(
                    color = if (isHighlighted) Color(0xFFE1F5FE) else Color(0xFFF3F4F6)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stepNumber.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = if (isHighlighted) Color(0xFF03578A) else Color(0xFF6B7280),
                fontFamily = ibmPlexSansArabic
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = stepText,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF374151),
            fontFamily = ibmPlexSansArabic,
            lineHeight = 24.sp,
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp)
        )
    }
}

@Composable
fun AddToCartButton(
    modifier: Modifier = Modifier,
    ibmPlexSansArabic: FontFamily
) {
    var showDiscountedPrice by remember { mutableStateOf(false) }

    Button(
        onClick = { showDiscountedPrice = !showDiscountedPrice },
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF03578A)
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Add to cart",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontFamily = ibmPlexSansArabic
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = "•",
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.5f),
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Box(
                contentAlignment = Alignment.Center
            ) {
                if (showDiscountedPrice) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "3 cheeses",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontFamily = ibmPlexSansArabic
                        )
                        Text(
                            text = "5 cheeses",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White.copy(alpha = 0.7f),
                            fontFamily = ibmPlexSansArabic,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                } else {
                    Text(
                        text = "5 cheeses",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        fontFamily = ibmPlexSansArabic
                    )
                }
            }
        }
    }
}