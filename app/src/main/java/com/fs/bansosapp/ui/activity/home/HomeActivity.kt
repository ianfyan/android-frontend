package com.fs.bansosapp.ui.activity.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fs.bansosapp.R
import com.fs.bansosapp.databinding.ActivityHomeBinding
import com.fs.bansosapp.ui.activity.crud.CrudActivity

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
            startActivity(Intent(this, CrudActivity::class.java))
        }
    }
}