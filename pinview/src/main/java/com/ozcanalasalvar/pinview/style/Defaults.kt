package com.ozcanalasalvar.pinview.style

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

object Defaults {
    val activeBackground: Color = Color.White
    val passiveBackground: Color = Color(0xFFEBF1F5)
    val errorColor: Color = Color.Red
    val textStyle: TextStyle = TextStyle(color = Color.Black, fontSize = 22.sp)
    val digits: Int = 6
}

inline fun Color?.takeOrElse(block: () -> Color): Color = this ?: block()