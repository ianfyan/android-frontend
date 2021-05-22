package com.fs.bansosapp.ui.activity.crud

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fs.bansosapp.databinding.ActivityCrudBinding

class CrudActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrudBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrudBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}