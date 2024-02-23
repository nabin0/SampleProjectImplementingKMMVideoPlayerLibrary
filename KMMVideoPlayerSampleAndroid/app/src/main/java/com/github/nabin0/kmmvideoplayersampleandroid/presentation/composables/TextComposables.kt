package com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextWithLeadingIcon(
    icon: ImageVector,
    iconTint: Color,
    iconSize: Int,
    text: String,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        androidx.compose.material3.Icon(
            imageVector = icon,
            contentDescription = "",
            tint = iconTint,
            modifier = Modifier.padding(end = 3.dp).size(iconSize.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium.copy(
                color = textColor,
                fontSize = 25.sp,
                fontWeight = FontWeight.Black,
            ),
        )
    }
}