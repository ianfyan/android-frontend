package com.fs.bansosapp.ui.activity.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fs.bansosapp.databinding.ActivitySplashScreenBinding
import com.fs.bansosapp.ui.activity.slider.SliderActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startActivity(Intent(applicationContext, SliderActivity::class.java))
        finish()
    }
}