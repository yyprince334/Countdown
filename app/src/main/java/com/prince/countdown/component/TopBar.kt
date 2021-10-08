package com.prince.countdown.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.prince.countdown.ui.theme.whiteText

@Composable
fun TopBar() {
    Text(
        text = "Countdown",
        modifier = Modifier.padding(32.dp),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h4,
        color = whiteText
    )
}

@Composable
fun Toolbar() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        TopBar()
    }
}