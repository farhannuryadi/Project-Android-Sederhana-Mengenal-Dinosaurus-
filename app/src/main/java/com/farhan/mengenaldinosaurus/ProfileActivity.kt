package com.farhan.mengenaldinosaurus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ProfileActivity : AppCompatActivity() {
    private lateinit var profile: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profile = findViewById(R.id.img_profile_gambar)
        profile.setImageResource(R.drawable.profile)

        val actionbar = supportActionBar
        actionbar!!.title = ""

        actionbar.setDisplayHomeAsUpEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}