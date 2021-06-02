package com.fs.bansosapp.ui.activity.profil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fs.bansosapp.data.model.Response.AdminsItem
import com.fs.bansosapp.databinding.ActivityProfilBinding

class ProfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfilBinding
    private lateinit var profilData: AdminsItem

    companion object{
        const val PROFIL_DATA = "profil_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profilData = intent.getParcelableExtra<AdminsItem>(PROFIL_DATA)!!

        setupData()
    }

    private fun setupData() {
        binding.profilUsername.text = profilData.nama
        binding.profilName.text = profilData.nama
        binding.profilEmail.text = profilData.email
        binding.profilAccess.text = profilData.writeAccess.toString()
    }
}