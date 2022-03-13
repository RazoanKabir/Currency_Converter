package com.razoan.currencyconverter.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.razoan.currencyconverter.R

class Splash : AppCompatActivity() {
    private val length = 3000

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable {
            val mainIntent = Intent(this@Splash, MainActivity::class.java)
            this@Splash.startActivity(mainIntent)
            overridePendingTransition(R.anim.right_in, R.anim.left_out)
            finish()
        }, length.toLong())
    }
}