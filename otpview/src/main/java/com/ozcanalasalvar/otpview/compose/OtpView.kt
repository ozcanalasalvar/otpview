package com.ozcanalasalvar.otpview.compose

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ozcanalasalvar.otpview.style.ColorStyle
import com.ozcanalasalvar.otpview.style.ColorStyle.Companion.merge
import com.ozcanalasalvar.otpview.style.Defaults
import com.ozcanalasalvar.otpview.style.takeOrElse

@Composable
fun OtpView(
    modifier: Modifier = Modifier,
    value: String,
    digits: Int = 6,
    enabled: Boolean = true,
    errorEnabled: Boolean = false,
    errorColor: Color? = null,
    autoFocusEnabled: Boolean = true,
    textColor: Color? = null,
    fontSize: TextUnit = 22.sp,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    textStyle: TextStyle = Defaults.textStyle,
    activeColor: Color? = null,
    passiveColor: Color? = null,
    colorStyle: ColorStyle = ColorStyle.Default,
    onFocusChanged: (Boolean) -> Unit = {},
    onTextChange: (String, Boolean) -> Unit,
) {

    val textFieldColor = textColor.takeOrElse { textStyle.color }

    val mergedStyle = textStyle.merge(
        TextStyle(
            color = textFieldColor,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            fontStyle = fontStyle,
        )
    )

    val active = activeColor.takeOrElse { colorStyle.active }
    val passive = passiveColor.takeOrElse { colorStyle.passive }
    val error = errorColor.takeOrElse { colorStyle.error }

    val mergedColorStyle = colorStyle.merge(
        ColorStyle(
            activeColor = active, passiveColor = passive, errorColor = error
        )
    )


    InnerOtpView(
        modifier = modifier,
        value = value,
        digits = digits,
        enabled = enabled,
        errorEnabled = errorEnabled,
        autoFocusEnabled = autoFocusEnabled,
        colorStyle = mergedColorStyle,
        textStyle = mergedStyle,
        onFocusChanged = onFocusChanged,
        onTextChange = onTextChange,
    )

}
