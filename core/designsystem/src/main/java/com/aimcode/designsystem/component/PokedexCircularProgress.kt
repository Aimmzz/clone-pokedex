package com.aimcode.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BoxScope.PokedexCircularProgress(
    color: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primary
) {
    CircularProgressIndicator(
        modifier = Modifier.align(Alignment.Center),
        color = color,
    )
}

@Preview
@Composable
private fun PokedexCircularProgressPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        PokedexCircularProgress()
    }
}
