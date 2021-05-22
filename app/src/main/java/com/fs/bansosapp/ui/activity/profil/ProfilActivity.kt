package com.fs.bansosapp.ui.activity.profil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fs.bansosapp.databinding.ActivityProfilBinding

class ProfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}