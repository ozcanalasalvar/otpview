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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozcanalasalvar.otpview.ui.theme.OtpviewTheme
import com.ozcanalasalvar.pinview.compose.OtpView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OtpviewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        var otpText by remember {
                            mutableStateOf("")
                        }

                        Spacer(modifier = Modifier.height(100.dp))

                        OtpView(
                            value = otpText,
                            digits = 6,
                            onFocusChanged = { focused ->
                                Log.i("focues = ", "$focused")
                            },
                            onTextChange = { value, completed ->
                                otpText = value
                            },
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
        Column(modifier = Modifier.padding(20.dp).background(Color.White)) {
            OtpView(
                value = "",
                digits = 6,
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
                onFocusChanged = { _ -> },
                onTextChange = { _, _ -> },
            )
        }
    }
}