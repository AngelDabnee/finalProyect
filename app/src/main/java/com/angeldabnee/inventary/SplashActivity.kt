package com.angeldabnee.inventary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.imageViewLogo)
        logo.setOnClickListener()
        {
            var i = Intent(this,AuthActivity::class.java)
            startActivity(i)
            finish()
            /*Toast.makeText(this,"Iniciando", Toast.LENGTH_SHORT).show()*/
        }
    }
}