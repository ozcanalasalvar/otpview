package com.ozcanalasalvar.otpview

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ozcanalasalvar.otpview.ui.theme.OtpviewTheme
import com.ozcanalasalvar.pinview.OtpView

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
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        var otpText by remember {
                            mutableStateOf("")
                        }

                        Spacer(modifier = Modifier.height(100.dp))

                        OtpView(
                            value = otpText,
                            digits = 5,
                            enabled = true,
                            errorEnabled = false,
                            autoFocusEnabled = true,
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OtpviewTheme {
        Greeting("Android")
    }
}