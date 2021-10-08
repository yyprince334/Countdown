package com.prince.countdown.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember


class ArcTransition(progress: State<Float>) {
    val progress by progress
}

@Composable
fun updateCircularTransitionData(remainingTime: Long, totalTime: Long): ArcTransition {
    val transition = updateTransition(targetState = remainingTime, label = "Anim1")
    val progress = transition.animateFloat(
        transitionSpec = { tween(1000, easing = FastOutSlowInEasing)}, label = "Anim2"
    ) { timeLeft ->
        if (timeLeft < 0) {
            360f
        }
        else {
            360f - ((360f / totalTime) * (totalTime - timeLeft))
        }
    }
    return remember(transition) { ArcTransition(progress = progress) }
}

