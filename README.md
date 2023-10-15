# OtpView

<br>
<br>

<p align="start">
  <img src="https://github.com/ozcanalasalvar/otpview/blob/main/art/Screenshot_20231014_225243.png" width="300">
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <img src="https://github.com/ozcanalasalvar/otpview/blob/main/art/Screenshot_20231014_222403.png" width="300">
</p>

<br>
<br>


# Jetpack Compose Usage

<br>

```java
OtpView(
  value = "",
  digits = 6,
  textColor = Color.White,
  activeColor = Color.Blue,
  passiveColor = Color.Cyan,
  fontSize = 22.sp,
  fontStyle = FontStyle.Italic,
  fontWeight = FontWeight.Bold,
  fontFamily = FontFamily(),
  onTextChange = { _, _ -> },
)
```

<br>
<br>

# View Usage

```java
val optView = findViewById<OtpView>(R.id.otpView)
optView.apply {
  setActiveColor(getColor(R.color.white))
  setPassiveColor(getColor(R.color.gray))
  setDigits(6)
  setAutoFocusEnabled(false)
  setErrorEnabled(false)
  setTextColor(getColor(R.color.purple_200))
  setFontFamily(/*YOUR CUSTOM FONT*/)
  setTextSize(22)
  setTextChangeListener(object : OtpView.ChangeListener {
  override fun onTextChange(value: String, completed: Boolean) {

    }
  })
}

```
<br>
<br>

```xml
<com.ozcanalasalvar.otp_view.view.OtpView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:activeColor="@color/white"
        app:autoFocusEnabled="false"
        app:digits="6"
        app:passiveColor="@color/gray"
        app:textColor="@color/orange"
        app:textSize="22"
        app:fontFamily="@font/your_custom_font"/>
```
<br>
<br>

# Implementation Gradle

###### Add it in your root build.gradle at the end of repositories:

```groovy
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' }
	}
}
```

###### Add the dependency

```groovy
dependencies {
	 implementation("com.github.ozcanalasalvar:otpview:1.0.8")

	//For view based UI's
	implementation 'androidx.compose.material3:material3:Tag'
}
```
