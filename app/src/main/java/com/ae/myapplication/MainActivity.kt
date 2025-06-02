package com.ae.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TomStoreApp()
        }
    }
}

@Composable
fun TomStoreApp() {
    MaterialTheme {
        TomCatShopScreen()
    }
}


@Preview(showBackground = true, widthDp = 390, heightDp = 844) // Approximate iPhone 12/13 Pro size
@Composable
fun TomStoreScreenPreview() {
    MaterialTheme { // Ensure MaterialTheme is applied for previews
        TomCatShopScreen()
    }
}

@Composable
fun TomCatShopScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F7FA))
    ) {

        // Header Section
        HeaderSection()

        // Search Bar
         SearchBar()

        // Promotional Banner
         PromotionalBanner()

        // Cheap Tom Section
         CheapTomSection()
    }
}

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier,
    unreadCount: Int = 3
) {

    /* 1)  Custom font family (already in your project) */
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_bold,   FontWeight.Bold),
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium),
        Font(R.font.ibm_plex_sans_arabic_regular,FontWeight.Normal)
    )

    /* 2)  Outer horizontal container */
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        /* ─────────────────  Avatar (48x48 dp)  ───────────────── */
        Image(
            painter = painterResource(R.drawable.avatar_jerry),
            contentDescription = "Jerry avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)                         // exactly 48x48 as shown in screenshot
                .clip(RoundedCornerShape(12.dp))     // slightly smaller radius for 48dp image
        )

        Spacer(Modifier.width(12.dp))

        /* ─────────────────  Two-line greeting  ───────────────── */
        Column(
            modifier = Modifier
                .weight(1f)                          // take all remaining width
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text       = "Hi, Jerry",
                    fontSize   = 14.sp,              // slightly smaller for better proportion
                    fontWeight = FontWeight.Medium,
                    fontFamily = ibmPlexSansArabic,
                    color      = Color(0xFF1F2937)   // dark gray
                )
                Spacer(Modifier.width(6.dp))
                Text(text = "👋", fontSize = 18.sp)
            }

            Spacer(Modifier.height(2.dp))

            Text(
                text       = "Which Tom do you want to buy?",
                fontSize   = 12.sp,                  // smaller subtitle
                fontWeight = FontWeight.Normal,
                fontFamily = ibmPlexSansArabic,
                color      = Color(0xFFA5A6A4)       // light gray for subtitle
            )
        }

        /* ─────────────────  Bell with badge (40x40 dp)  ───────────────── */
        Box(
            contentAlignment = Alignment.Center
        ) {

            /* Rounded square container 40x40 dp with light border */
            Box(
                modifier = Modifier
                    .size(40.dp)                     // exactly 40x40 as shown in screenshot
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0xFFA5A6A4),   // very light gray border
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_notification),
                    contentDescription = "notifications",
                    modifier = Modifier.size(24.dp) // smaller icon for 40dp container
                )
            }

            /* Blue badge – positioned on the top-right corner */
            if (unreadCount > 0) {
                Box(
                    modifier = Modifier
                        .offset(x = 16.dp, y = (-16).dp)   // adjusted for 40dp container
                        .size(14.dp)                       // slightly smaller badge
                        .background(Color(0xFF03578A), CircleShape), // blue badge
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text       = unreadCount.toString(),
                        color      = Color.White,
                        fontSize   = 10.sp,            // smaller text for smaller badge
                        fontWeight = FontWeight.Medium,
                        fontFamily = ibmPlexSansArabic,
                        textAlign = TextAlign.Center,
                        lineHeight = 10.sp  // This ensures no extra line spacing
                    )
                }
            }
        }
    }
}


@Composable
fun SearchBar() {
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_bold, FontWeight.Bold),
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium),
        Font(R.font.ibm_plex_sans_arabic_regular, FontWeight.Normal)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = { },
            placeholder = {
                Text(
                    text = "Search about tom ...",
                    color = Color(0xFF969799),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = ibmPlexSansArabic,
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                    tint = Color(0xFF969799),
                    modifier = Modifier.size(24.dp)
                )
            },
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedTextColor = Color(0xFF1F2937),
                unfocusedTextColor = Color(0xFF1F2937)
            ),
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = ibmPlexSansArabic
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF03578A), RoundedCornerShape(16.dp))
                .clickable { /* Handle filter click */ },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = "Filter",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun PromotionalBanner() {
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_bold, FontWeight.Bold),
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium),
        Font(R.font.ibm_plex_sans_arabic_regular, FontWeight.Normal),
        Font(R.font.ibm_plex_sans_arabic_semibold, FontWeight.SemiBold)
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(120.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF03446A), // Dark blue on left
                            Color(0xFF0685D0)  // Lighter cyan-blue on right
                        ),
                        startX = 0f,
                        endX = Float.POSITIVE_INFINITY
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Text content on the left
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Buy 1 Tom and get 2 for free",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontFamily = ibmPlexSansArabic,
                        lineHeight = 20.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Adopt Tom! (Free Fail-Free\nGuarantee)",
                        fontSize = 12.sp,
                        color = Color.White.copy(alpha = 0.9f),
                        fontFamily = ibmPlexSansArabic,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 16.sp
                    )
                }

                // Tom image on the right
                Image(
                    painter = painterResource(id = R.drawable.tom_promotional),
                    contentDescription = "Tom promotional",

                    modifier = Modifier
                        .size(width = 115.38.dp , height = 108.dp)
                        .offset(x = 20.dp, y = (-10).dp), // Extend slightly beyond the card
                )
            }
        }
    }
}

@Composable
fun CheapTomSection() {
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_bold, FontWeight.Bold),
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium),
        Font(R.font.ibm_plex_sans_arabic_regular, FontWeight.Normal),
        Font(R.font.ibm_plex_sans_arabic_semibold, FontWeight.SemiBold)
    )

    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Cheap tom section",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1F2937),
                    fontFamily = ibmPlexSansArabic
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "View all",
                        fontSize = 12.sp,
                        color = Color(0xFF03578A),
                        fontFamily = ibmPlexSansArabic,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = "View all",
                        tint = Color(0xFF03578A),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        items(getTomItems().chunked(2)) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                rowItems.forEach { item ->
                    TomItemCard(
                        item = item,
                        modifier = Modifier.weight(1f)
                    )
                }
                if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TomItemCard(
    item: TomItem,
    modifier: Modifier = Modifier
) {
    val ibmPlexSansArabic = FontFamily(
        Font(R.font.ibm_plex_sans_arabic_bold, FontWeight.Bold),
        Font(R.font.ibm_plex_sans_arabic_medium, FontWeight.Medium),
        Font(R.font.ibm_plex_sans_arabic_regular, FontWeight.Normal),
        Font(R.font.ibm_plex_sans_arabic_semibold, FontWeight.SemiBold)
    )

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Tom Character Image
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Tom Name
            Text(
                text = item.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1F1F1E),
                textAlign = TextAlign.Center,
                fontFamily = ibmPlexSansArabic
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Description
            Text(
                text = item.description,
                fontSize = 12.sp,
                color = Color(0xFF969799),
                textAlign = TextAlign.Center,
                lineHeight = 14.sp,
                maxLines = 3,
                fontFamily = ibmPlexSansArabic,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Price and Cart Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Price with cheese icon - Light blue background
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(
                            color = Color(0xFFE1F5FE), // Light blue background
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cheese),
                        contentDescription = "Cheese",
                        tint = Color(0xFF03578A),
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${item.price} cheeses",
                        fontSize = 11.sp,
                        color = Color(0xFF03578A),
                        fontWeight = FontWeight.Medium,
                        fontFamily = ibmPlexSansArabic
                    )
                }

                // Shopping cart button
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.size(30.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF03578A),
                        containerColor = Color.Transparent
                    ),
                    border = BorderStroke(1.dp, Color(0xFF03578A)),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_shopping_cart),
                        contentDescription = "Add to cart",
                        modifier = Modifier.size(16.dp),
                        tint = Color(0xFF03578A)
                    )
                }
            }
        }
    }
}

data class TomItem(
    val name: String,
    val description: String,
    val price: Int,
    val imageRes: Int
)

fun getTomItems(): List<TomItem> = listOf(
    TomItem(
        name = "Sport Tom",
        description = "He runs 1 meter... trips over his boot.",
        price = 5,
        imageRes = R.drawable.sport_tom
    ),
    TomItem(
        name = "Tom the lover",
        description = "He loves one-sidedly... and is beaten by the other side.",
        price = 5,
        imageRes = R.drawable.tom_lover
    ),
    TomItem(
        name = "Tom the bomb",
        description = "He blows himself up before Jerry can catch him.",
        price = 10,
        imageRes = R.drawable.tom_bomb
    ),
    TomItem(
        name = "Spy Tom",
        description = "Disguises itself as a table.",
        price = 12,
        imageRes = R.drawable.spy_tom
    ),
    TomItem(
        name = "Frozen Tom",
        description = "He was chasing Jerry, he froze after the first look.",
        price = 10,
        imageRes = R.drawable.frozen_tom
    ),
    TomItem(
        name = "Sleeping Tom",
        description = "He doesn't chase anyone, he just snores in stereo.",
        price = 10,
        imageRes = R.drawable.sleeping_tom
    )
)
