package com.yongjincompany.attendence.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val BottomBoxShape = Shapes(
    medium = RoundedCornerShape(topStart = 14.dp, topEnd = 14.dp)
)