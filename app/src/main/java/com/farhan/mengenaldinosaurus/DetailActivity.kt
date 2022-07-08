package com.farhan.mengenaldinosaurus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_GAMBAR = "extra_gambar"
    }

    private lateinit var tvName: TextView
    private lateinit var tvDetail: TextView
    private lateinit var imgGambar: ImageView
    private lateinit var btnShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvName = findViewById(R.id.tv_detail_name)
        tvDetail = findViewById(R.id.tv_detail_detail)
        imgGambar = findViewById(R.id.img_detail_gambar)
        btnShare = findViewById(R.id.btn_share)

        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val gambar = intent.getIntExtra(EXTRA_GAMBAR, 0)

        tvName.text = name
        tvDetail.text = detail
        imgGambar.setImageResource(gambar)

        val actionbar = supportActionBar
        actionbar!!.title = ""

        actionbar.setDisplayHomeAsUpEnabled(true)

        btnShare.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, detail)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to :"))

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}