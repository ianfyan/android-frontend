package com.fs.bansosapp.ui.activity.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fs.bansosapp.R
import com.fs.bansosapp.databinding.ActivityHomeBinding
import com.fs.bansosapp.ui.activity.crud.CrudActivity
import com.fs.bansosapp.ui.viewmodel.MainViewModel
import com.fs.bansosapp.ui.viewmodel.ViewModelFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var mainViewModel: MainViewModel

    companion object {
        const val EXTRA_TOKEN = "extra_token"
        private lateinit var token: String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        token = intent.getStringExtra(EXTRA_TOKEN)!!
        val factory = ViewModelFactory.getInstance(this)
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        binding.bottomNavigation.background = null
        binding.bottomNavigation.menu.getItem(2).setEnabled(false)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            var frag: Fragment = HomeFragment.newInstance(token)
            when (item.itemId){
                R.id.menu_home -> frag = HomeFragment.newInstance(token)
                R.id.menu_bansos -> frag = BansosFragment()
                R.id.menu_analis -> frag = AnalyzeFragment()
                R.id.menu_map -> frag = MapFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, frag!!).commit()
            true
        }

        binding.fab.setOnClickListener {
            mainViewModel.getProfil(token).observe(this, Observer { data ->
                val writeAccess = data.admins[0].writeAccess
                if (writeAccess){
                    val intent = Intent(this, CrudActivity::class.java)
                    intent.putExtra(CrudActivity.DATA_TOKEN, token)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Anda tidak memiliki akses", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}