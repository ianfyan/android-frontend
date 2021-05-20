package com.fs.bansosapp.ui.activity.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fs.bansosapp.R
import com.fs.bansosapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.bottomNavigation.background = null
        binding.bottomNavigation.menu.getItem(2).setEnabled(false)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            var frag: Fragment? = null
            when (item.itemId){
                R.id.menu_home -> frag = HomeFragment()
                R.id.menu_bansos -> frag = BansosFragment()
                R.id.menu_analis -> frag = AnalyzeFragment()
                R.id.menu_map -> frag = MapFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, frag!!).commit()
            true
        }

        binding.fab.setOnClickListener {
            Toast.makeText(this, "Add Data Here!...", Toast.LENGTH_SHORT).show()
        }
    }
}