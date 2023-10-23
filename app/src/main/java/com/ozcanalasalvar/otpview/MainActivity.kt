package com.ozcanalasalvar.otpview

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozcanalasalvar.otp_view.compose.OtpView
import com.ozcanalasalvar.otpview.ui.theme.Orange
import com.ozcanalasalvar.otpview.ui.theme.OtpviewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OtpviewTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Orange),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .verticalScroll(rememberScrollState())
                            .background(Orange),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        var otpText by remember {
                            mutableStateOf("")
                        }
                        Spacer(modifier = Modifier.height(30.dp))

                        Text(
                            text = "Enter Verification Code",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(170.dp))
                        Text(
                            text = "We have sent OTP on your number",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        OtpView(
                            value = otpText,
                            digits = 6,
                            textColor = Orange,
                            passiveColor = Color.White.copy(alpha = 0.8f),
                            fontSize = 25.sp,
                            onFocusChanged = { focused ->
                                Log.i("focues = ", "$focused")
                            },
                            onTextChange = { value, completed ->
                                otpText = value
                            },
                        )

                        Spacer(modifier = Modifier.height(180.dp))

                        Text(
                            text = buildAnnotatedString {
                                append("Didn't receive a Otp?")
                                withStyle(
                                    style = SpanStyle(
                                        textDecoration = TextDecoration.Underline,
                                    )
                                ) {
                                    append("Resend Otp")
                                }
                            },
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OtpViewPreview() {
    OtpviewTheme {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .background(Color.White)
        ) {
            OtpView(
                value = "",
                digits = 6,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onFocusChanged = { _ -> },
                onTextChange = { _, _ -> },
            )

            Spacer(modifier = Modifier.height(30.dp))


            OtpView(
                value = "123",
                digits = 4,
                onFocusChanged = { _ -> },
                onTextChange = { _, _ -> },
            )

            Spacer(modifier = Modifier.height(30.dp))


            OtpView(
                value = "123",
                digits = 4,
                fontSize = 32.sp,
                onFocusChanged = { _ -> },
                onTextChange = { _, _ -> },
            )

            Spacer(modifier = Modifier.height(30.dp))


            OtpView(
                value = "1234",
                digits = 6,
                textColor = Color.Blue,
                onFocusChanged = { _ -> },
                onTextChange = { _, _ -> },
            )

            Spacer(modifier = Modifier.height(30.dp))

            OtpView(
                value = "1234",
                digits = 6,
                textColor = Color.White,
                activeColor = Color.Blue,
                passiveColor = Color.Cyan,
                fontSize = 22.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                onTextChange = { _, _ -> },
            )
        }
    }
}