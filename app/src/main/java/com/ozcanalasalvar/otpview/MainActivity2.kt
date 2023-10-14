package com.ozcanalasalvar.otpview

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
//import com.ozcanalasalvar.otp_view.view.OtpView


class MainActivity2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val optView = findViewById<OtpView>(R.id.otpView)
//        optView.apply {
//            setActiveColor(getColor(R.color.white))
//            setPassiveColor(getColor(R.color.gray))
//            setDigits(6)
//            setAutoFocusEnabled(false)
//            setErrorEnabled(false)
//            setTextColor(getColor(R.color.purple_200))
//            //setFontFamily()
//            setTextSize(22)
//            setTextChangeListener(object : OtpView.ChangeListener {
//                override fun onTextChange(value: String, completed: Boolean) {
//
//                }
//
//            })
//        }

    }
}