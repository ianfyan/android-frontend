package com.fs.bansosapp.ui.activity.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fs.bansosapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}