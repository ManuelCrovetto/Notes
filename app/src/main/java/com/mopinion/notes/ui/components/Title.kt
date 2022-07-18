package com.mopinion.notes.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun AppTitle() {
    Text(
        text = "Notes",
        style = TextStyle(
            fontSize = 24.sp,
            color = Color.Black,
        )
    )
}
