package com.ozcanalasalvar.otp_view.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.ozcanalasalvar.otp_view.style.KeyboardType
import com.ozcanalasalvar.pinview.R

class OtpView : FrameLayout {

    private lateinit var otpView: OptViewComposeView
    private var fontSize: Float? = null
    private var textColor: Color? = null
    private var fontFamily: FontFamily? = null

    private var activeColor: Color? = null
    private var passiveColor: Color? = null
    private var errorEnabled: Boolean = false
    private var autoFocusEnabled: Boolean = true
    private var password: Boolean = false
    private var symbol: Char = '*'
    private var digits: Int = 6
    private var keyboardType: Int = 3


    constructor(context: Context) : super(context) {
        init(context, null, 0)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setAttributes(context, attrs)
        init(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        setAttributes(context, attrs)
        init(context, attrs, defStyleAttr)
    }

    constructor(
        context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        setAttributes(context, attrs)
        init(context, attrs, defStyleAttr)
    }


    @SuppressLint("NonConstantResourceId")
    private fun setAttributes(context: Context, attrs: AttributeSet?) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.OtpView)
        val N = a.indexCount
        for (i in 0 until N) {
            val attr = a.getIndex(i)
            when (attr) {
                R.styleable.OtpView_activeColor -> {
                    activeColor = Color(a.getColor(R.styleable.OtpView_activeColor, -1))
                }

                R.styleable.OtpView_passiveColor -> {
                    passiveColor = Color(a.getColor(R.styleable.OtpView_passiveColor, -1))
                }

                R.styleable.OtpView_digits -> {
                    digits = a.getInt(R.styleable.OtpView_digits, 6)
                }

                R.styleable.OtpView_autoFocusEnabled -> {
                    autoFocusEnabled = a.getBoolean(R.styleable.OtpView_autoFocusEnabled, true)
                }

                R.styleable.OtpView_textSize -> {
                    fontSize = a.getInt(R.styleable.OtpView_textSize, 22).toFloat()
                }

                R.styleable.OtpView_textColor -> {
                    textColor = Color(a.getColor(R.styleable.OtpView_textColor, -1))
                }

                R.styleable.OtpView_password -> {
                    password = a.getBoolean(R.styleable.OtpView_password, false)
                }

                R.styleable.OtpView_otpSymbol -> {
                    symbol =
                        a.getString(R.styleable.OtpView_otpSymbol)?.toCharArray()?.get(0) ?: '*'
                }

                R.styleable.OtpView_keyboardType -> {
                    keyboardType = a.getInt(R.styleable.OtpView_keyboardType, KeyboardType.NUMBER)
                }
            }
        }
        a.recycle()
    }


    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {

        otpView = OptViewComposeView(
            context = context,
            attrs = attrs,
            defStyle = defStyleAttr,
        )


        refresh()
        this.addView(otpView)
    }

    private fun refresh() {
        otpView.fontSize = fontSize
        otpView.textColor = textColor
        otpView.fontFamily = fontFamily
        otpView.activeColor = activeColor
        otpView.passiveColor = passiveColor
        otpView.errorEnabled = errorEnabled
        otpView.autoFocusEnabled = autoFocusEnabled
        otpView.digits = digits
        otpView.password = password
        otpView.symbol = symbol
        otpView.keyboardType = when (keyboardType) {
            KeyboardType.TEXT -> {
                KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Text)
            }

            KeyboardType.NUMBER -> {
                KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Number)
            }

            else -> {
                KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Number)
            }
        }
        otpView.setTextChangeListener(textChangeListener)
    }


    fun setTextSize(textSize: Int) {
        this.fontSize = textSize.toFloat()
        refresh()
    }

    fun setTextColor(color: Int) {
        this.textColor = Color(color)
        refresh()
    }

    fun setFontFamily(fontFamily: FontFamily) {
        this.fontFamily = fontFamily
        refresh()
    }


    fun setActiveColor(color: Int) {
        this.activeColor = Color(color)
        refresh()
    }

    fun setPassiveColor(color: Int) {
        this.passiveColor = Color(color)
        refresh()
    }

    fun setErrorEnabled(errorEnabled: Boolean) {
        this.errorEnabled = errorEnabled
        refresh()
    }

    fun setAutoFocusEnabled(autoFocusEnabled: Boolean) {
        this.autoFocusEnabled = autoFocusEnabled
        refresh()
    }

    fun setDigits(digits: Int) {
        this.digits = digits
        refresh()
    }


    interface ChangeListener {
        fun onTextChange(value: String, completed: Boolean)
    }

    private var textChangeListener: ChangeListener? = null
    fun setTextChangeListener(dataSelectListener: ChangeListener) {
        this.textChangeListener = dataSelectListener
        refresh()
    }

}