package com.ozcanalasalvar.pinview.style

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color


@Immutable
class ColorStyle {

    var active: Color
    var passive: Color
    var error: Color


    constructor(
        activeColor: Color = Defaults.activeBackground,
        passiveColor: Color = Defaults.passiveBackground,
        errorColor: Color = Defaults.errorColor,
    ) {
        active = activeColor
        passive = passiveColor
        error = errorColor
    }

    constructor() {
        active = Defaults.activeBackground
        passive = Defaults.passiveBackground
        error = Defaults.errorColor
    }

    companion object {
        val Default = ColorStyle()

        @Stable
        fun ColorStyle.merge(other: ColorStyle? = null): ColorStyle {
            if (other == null || other == Default) return this
            return ColorStyle(
                activeColor = other.active, passiveColor = other.passive, errorColor = other.error
            )
        }

    }
}