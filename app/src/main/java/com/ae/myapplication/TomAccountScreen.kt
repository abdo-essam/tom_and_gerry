package com.ae.myapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import kotlin.math.cos
import kotlin.math.sin
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign


@Composable
fun TomAccountScreen() {
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_bold, FontWeight.Bold),
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium),
        Font(R.font.ibm_plex_sans_arabic_regular, FontWeight.Normal),
        Font(R.font.ibm_plex_sans_arabic_semibold, FontWeight.SemiBold)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0F7B9A), // Top blue
                        Color(0xFF2D9CDB)  // Bottom lighter blue
                    )
                )
            )
    ) {
        // Background decorative elements
        BackgroundDecorations()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(60.dp))

            // Profile Section
            ProfileSection(fontFamily = ibmPlexSansArabic)

            Spacer(modifier = Modifier.height(8.dp))

            // White card container for all remaining content
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Take remaining space
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEEF4F6))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(top = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Stats Grid
                    StatsGrid(fontFamily = ibmPlexSansArabic)

                    Spacer(modifier = Modifier.height(32.dp))

                    // Settings Section
                    SettingsSection(fontFamily = ibmPlexSansArabic)

                    Spacer(modifier = Modifier.height(32.dp))

                    // Favorite Foods Section
                    FavoriteFoodsSection(fontFamily = ibmPlexSansArabic)

                    Spacer(modifier = Modifier.height(24.dp))

                    // Version text
                    Text(
                        text = "v.TomBeta",
                        fontSize = 14.sp,
                        color = Color(0xFF6B7280),
                        fontFamily = ibmPlexSansArabic,
                        fontWeight = FontWeight.Normal
                    )

                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}

@Composable
fun BackgroundDecorations() {
    // Large decorative circles in background
    Box(
        modifier = Modifier
            .size(300.dp)
            .offset(x = 200.dp, y = (-100).dp)
            .background(
                color = Color.White.copy(alpha = 0.1f),
                shape = CircleShape
            )
    )

    Box(
        modifier = Modifier
            .size(200.dp)
            .offset(x = (-80).dp, y = 100.dp)
            .background(
                color = Color.White.copy(alpha = 0.05f),
                shape = CircleShape
            )
    )

    Box(
        modifier = Modifier
            .size(150.dp)
            .offset(x = 250.dp, y = 400.dp)
            .background(
                color = Color.White.copy(alpha = 0.08f),
                shape = CircleShape
            )
    )
}

@Composable
fun ProfileSection(fontFamily: FontFamily) {
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_bold, FontWeight.Bold),
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium),
        Font(R.font.ibm_plex_sans_arabic_regular, FontWeight.Normal)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Image
        Image(
            painter = painterResource(id = R.drawable.tom_profile), // Add this image
            contentDescription = "Tom Profile",
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Name
        Text(
            text = "Tom",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            letterSpacing = 0.sp,
            fontFamily = ibmPlexSansArabic
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Description
        Text(
            text = "specializes in failure!",
            fontSize = 12.sp,
            color = Color.White.copy(alpha = 0.8f),
            fontFamily = ibmPlexSansArabic,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Edit Button
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(25.dp)
                .background(
                    color = Color.White.copy(alpha = 0.12f),
                    shape = RoundedCornerShape(40.dp)
                )
                .clickable { /* Handle edit */ }
                .padding(vertical = 6.dp, horizontal = 12.dp)
        ) {
            Text(
                text = "Edit foolishness",
                fontSize = 10.sp,
                color = Color.White,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun StatsGrid(fontFamily: FontFamily) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StatCard(
                value = "2M 12K",
                label = "No. of quarrels",
                backgroundColor = Color(0xFFD0E5F0),
                iconRes = R.drawable.ic_quarrels,
                iconTint = Color(0xFF03578A),
                arcSweepAngle = 210f,
                modifier = Modifier.weight(1f),
                fontFamily = fontFamily
            )

            StatCard(
                value = "+500 h",
                label = "Chase time",
                backgroundColor = Color(0xFFDEEECD),
                iconRes = R.drawable.ic_chase,
                iconTint = Color(0xFF57AB0F),
                arcSweepAngle = 90f,
                modifier = Modifier.weight(1f),
                fontFamily = fontFamily
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StatCard(
                value = "2M 12K",
                label = "Hunting times",
                backgroundColor = Color(0xFFF2D9E7),
                iconRes = R.drawable.ic_hunting,
                iconTint = Color(0xFFF46983),
                arcSweepAngle = 320f,
                modifier = Modifier.weight(1f),
                fontFamily = fontFamily
            )

            StatCard(
                value = "3M 7K",
                label = "Heartbroken",
                backgroundColor = Color(0xFFFAEDCF),
                iconRes = R.drawable.ic_heartbroken,
                iconTint = Color(0xFFFFBF1A),
                arcSweepAngle = 50f,
                modifier = Modifier.weight(1f),
                fontFamily = fontFamily
            )
        }
    }
}

@Composable
fun StatCard(
    value: String,
    label: String,
    backgroundColor: Color,
    iconRes: Int,
    iconTint: Color,
    arcSweepAngle: Float,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily
) {
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_bold, FontWeight.Bold),
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium),
        Font(R.font.ibm_plex_sans_arabic_regular, FontWeight.Normal)
    )
    Card(
        modifier = modifier.height(58.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 9.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            // Icon with decorative circle
            Box(
                modifier = Modifier.size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                // White circle background for icon
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = Color.White,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = label,
                        tint = iconTint,
                        modifier = Modifier.size(18.dp)
                    )
                }

                // Decorative arc around the white circle
                Canvas(
                    modifier = Modifier.size(40.dp)
                ) {
                    val strokeWidth = 1.dp.toPx() // Thinner line
                    val radius = 20.dp.toPx()

                    // Draw arc starting from top (12 o'clock) going clockwise
                    drawArc(
                        color = iconTint,
                        startAngle = -90f,        // Start from top (12 o'clock)
                        sweepAngle = arcSweepAngle, // Variable arc length
                        useCenter = false,
                        style = Stroke(
                            width = strokeWidth,
                            cap = StrokeCap.Round
                        ),
                        size = Size(radius * 2, radius * 2),
                        topLeft = Offset(
                            (size.width - radius * 2) / 2,
                            (size.height - radius * 2) / 2
                        )
                    )

                    // Draw dot at the end of arc
                    val dotAngle = Math.toRadians((-90f + arcSweepAngle).toDouble())
                    val dotX = center.x + (radius * cos(dotAngle)).toFloat()
                    val dotY = center.y + (radius * sin(dotAngle)).toFloat()

                    drawCircle(
                        color = iconTint,
                        radius = 3.dp.toPx(),
                        center = Offset(dotX, dotY)
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Text content
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = value,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.5.sp,
                    lineHeight = 16.sp,
                    color = Color(0xFF121212).copy(alpha = 0.6f),
                    fontFamily = ibmPlexSansArabic
                )
                Text(
                    letterSpacing = 0.5.sp,
                    text = label,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = Color(0xFF121212).copy(alpha = 0.37f),
                    fontFamily = ibmPlexSansArabic,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun SettingsSection(fontFamily: FontFamily) {
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_bold, FontWeight.Bold),
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium),
        Font(R.font.ibm_plex_sans_arabic_regular, FontWeight.Normal)
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(24.dp)
    ) {
        Text(
            text = "Tom settings",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1F1F1E).copy(alpha = 0.87f),
            fontFamily = ibmPlexSansArabic,
        )

        SettingItem(
            title = "Change sleeping place",
            iconRes = R.drawable.ic_bed,
            fontFamily = ibmPlexSansArabic
        )

        SettingItem(
            title = "Meow settings",
            iconRes = R.drawable.ic_meow,
            fontFamily = ibmPlexSansArabic
        )

        SettingItem(
            title = "Password to open the fridge",
            iconRes = R.drawable.ic_fridge,
            fontFamily = ibmPlexSansArabic,
            isLast = true
        )
    }
}

@Composable
fun FavoriteFoodsSection(fontFamily: FontFamily) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(24.dp)
    ) {
        Text(
            text = "His favorite foods",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1F2937),
            fontFamily = fontFamily,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        SettingItem(
            title = "Mouses",
            iconRes = R.drawable.ic_mouse, // Add this icon
            fontFamily = fontFamily
        )

        SettingItem(
            title = "Last stolen meal",
            iconRes = R.drawable.ic_stolen_meal, // Add this icon
            fontFamily = fontFamily
        )

        SettingItem(
            title = "Change sleep mood",
            iconRes = R.drawable.ic_sleep_mood, // Add this icon
            fontFamily = fontFamily,
            isLast = true
        )
    }
}

@Composable
fun SettingItem(
    title: String,
    iconRes: Int,
    fontFamily: FontFamily,
    isLast: Boolean = false
) {
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_bold, FontWeight.Bold),
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium),
        Font(R.font.ibm_plex_sans_arabic_regular, FontWeight.Normal)
    )

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Handle click */ }
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                tint = Color(0xFF6B7280),
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = title,
                fontSize = 16.sp,
                color = Color(0xFF1F1F1E).copy(alpha = 0.87f),
                fontFamily = ibmPlexSansArabic,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f)
            )
        }

        if (!isLast) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(0xFFF3F4F6))
                    .padding(start = 40.dp)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844, showSystemUi = true)
@Composable
fun TomAccountScreenPreview() {
    MaterialTheme {
        TomAccountScreen()
    }
}