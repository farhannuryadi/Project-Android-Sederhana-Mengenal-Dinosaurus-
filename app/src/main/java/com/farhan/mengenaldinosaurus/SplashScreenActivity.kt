package com.farhan.mengenaldinosaurus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    private val WAKTU: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val actionbar = supportActionBar
        actionbar!!.hide()

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreenActivity,MainActivity::class.java))
            finish()
        }, WAKTU
        )
    }
}