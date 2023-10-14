package com.ozcanalasalvar.pinview

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun OtpView(
    modifier: Modifier = Modifier,
    value: String,
    digits: Int = 6,
    enabled: Boolean = true,
    errorEnabled: Boolean = false,
    autoFocusEnabled: Boolean = false,
    onFocusChanged: (Boolean) -> Unit = {},
    onTextChange: (String, Boolean) -> Unit,
) {
    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }
    BasicTextField(
        modifier = modifier
            .onFocusChanged {
                isFocused = it.isFocused
                onFocusChanged(it.isFocused)
            }
            .focusRequester(focusRequester),
        value = value,
        singleLine = true,
        onValueChange = {
            if (it.length <= digits && it.isDigitsOnly()) {
                onTextChange.invoke(it, it.length == digits)
                onFocusChanged(true)
            }
        },
        enabled = enabled,
        textStyle = TextStyle(textAlign = TextAlign.Center),
        keyboardOptions = KeyboardOptions(
            keyboardType =
            KeyboardType.Number
        ),
        decorationBox = { innerTextField ->
            Row(Modifier.width(IntrinsicSize.Min)) {
                val textLength = value.length
                repeat(digits) { index ->
                    Box(
                        modifier = Modifier
                            .size(width = 48.dp, height = 48.dp)
                            .background(
                                if (index < textLength && value[index]
                                        .toString()
                                        .isNotEmpty()
                                ) Color.White else Color.LightGray/*SmsCodeBg*/, shape =
                                RoundedCornerShape(5.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = if (errorEnabled) Color.Red else (if (index <
                                    textLength && value[index]
                                        .toString()
                                        .isNotEmpty()
                                ) Color.Black else Color.LightGray/*SmsCodeBg*/),
                                shape = RoundedCornerShape(5.dp)
                            )
                            .padding(1.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = if (index < textLength) value[index].toString() else "",
                            modifier = Modifier.align(
                                Alignment.Center
                            ),
                            fontSize = 22.sp,
                            style = TextStyle()
                            //fontFamily = FontFamily(Font(R.font.medium)),
                        )
                        if (index == textLength && isFocused) {
                            var alpha by remember { mutableStateOf(1f) }
                            LaunchedEffect(key1 = Unit) {
                                coroutineScope {
                                    launch {
                                        while (true) {
                                            delay(750L)
                                            alpha = 1f - alpha
                                        }
                                    }
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .width(2.dp)
                                    .height(20.dp)
                                    .alpha(alpha)
                                    .background(Color.Black)
                            )
                        }
                    }
                    if (index != digits - 1) Spacer(modifier = Modifier.width(8.dp))
                }
            }
        },
    )
    LaunchedEffect(autoFocusEnabled) {
        if (autoFocusEnabled)
            focusRequester.requestFocus()
    }
}

data class OtpViewColorPallet(

)