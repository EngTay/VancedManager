package com.vanced.manager.ui.component.text

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.vanced.manager.ui.component.color.managerAnimatedColor

@Composable
fun ToolbarTitleText(
    text: String
) {
    ManagerText(
        text = text,
        textStyle = MaterialTheme.typography.h1,
        color = managerAnimatedColor(MaterialTheme.colors.onSurface)
    )
}