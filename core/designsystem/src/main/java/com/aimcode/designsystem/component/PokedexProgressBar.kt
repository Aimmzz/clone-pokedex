package com.aimcode.designsystem.component

import android.content.res.Configuration
import androidx.annotation.FloatRange
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokedexProgressBar(
    modifier: Modifier = Modifier,
    @FloatRange(0.0, 1.0) progress: Float,
    color: Color,
    label: String,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp.value
    val isLocalInspectionMode = LocalInspectionMode.current
    val density = LocalDensity.current

    var progressWidth by remember {
        mutableFloatStateOf(
            if (isLocalInspectionMode) {
                screenWidth
            } else {
                0f
            },
        )
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(18.dp)
            .onSizeChanged {
                progressWidth = it.width * progress
            }
            .background(
                color = Color.White,
                shape = RoundedCornerShape(64.dp),
            )
            .clip(RoundedCornerShape(64.dp)),
    ) {
        var textWidth by remember { mutableIntStateOf(0) }
        val threshold = 16
        val isInner by remember(progressWidth, textWidth) {
            mutableStateOf(progressWidth > (textWidth + threshold * 2))
        }

        val animation: Float by animateFloatAsState(
            targetValue = if (progressWidth == 0f) 0f else 1f,
            animationSpec = tween(durationMillis = 950, easing = LinearOutSlowInEasing),
            label = "",
        )

        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .height(18.dp)
                .width(with(density) { (progressWidth * animation).toDp() })
                .background(color = color, shape = RoundedCornerShape(64.dp)),
        ) {
            if (isInner) {
                Text(
                    modifier = Modifier
                        .onSizeChanged { textWidth = it.width }
                        .align(Alignment.CenterEnd)
                        .padding(end = with(density) { (threshold * 2).toDp() }),
                    text = label,
                    fontSize = 12.sp,
                    color = Color.White,
                )
            }
        }

        if (!isInner) {
            Text(
                modifier = Modifier
                    .onSizeChanged { textWidth = it.width }
                    .align(Alignment.CenterStart)
                    .padding(
                        start = with(density) { (progressWidth.toInt() + threshold).toDp() }
                    ),
                text = label,
                fontSize = 12.sp,
                color = Color.Black,
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PokedexProgressBarPreview1() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.LightGray),
    ) {
        PokedexProgressBar(
            modifier = Modifier.align(Alignment.Center),
            progress = 0.1f,
            color = MaterialTheme.colorScheme.primary,
            label = "150/300",
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PokedexProgressBarPreview2() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.LightGray),
    ) {
        PokedexProgressBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            progress = 0.5f,
            color = MaterialTheme.colorScheme.primary,
            label = "150/300",
        )
    }
}