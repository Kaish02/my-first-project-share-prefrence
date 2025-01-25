package com.example.spproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class lottieAnimation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lottie_animation)

        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPreferencesReGet = getSharedPreferences("mySharedPreferencesProject", MODE_PRIVATE)
            val getNameRe = sharedPreferencesReGet.getString("Name", null)

            if (getNameRe != null) {
                startActivity(Intent(this, UserHomePage::class.java))
                finish()
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }, 4000)


    }
}