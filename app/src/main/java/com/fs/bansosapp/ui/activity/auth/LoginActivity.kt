package com.fs.bansosapp.ui.activity.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fs.bansosapp.data.model.Task
import com.fs.bansosapp.databinding.ActivityLoginBinding
import com.fs.bansosapp.ui.activity.home.HomeActivity
import com.fs.bansosapp.ui.viewmodel.MainViewModel
import com.fs.bansosapp.ui.viewmodel.ViewModelFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = ViewModelFactory.getInstance(this)
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        binding.loginButton.setOnClickListener {
            //startActivity(Intent(this, HomeActivity::class.java))
            getToken()
        }
    }

    private fun getToken(){
        binding.loginProgress.visibility = View.VISIBLE
        val username = binding.usernameInput.text.toString()
        val password = binding.passwordInput.text.toString()
        val task = Task(username, password)
        mainViewModel.getToken(task).observe(this, Observer { token ->
            if (token == "Pass is wrong"){
                Toast.makeText(this, "Username atau password yang anda masukkan salah", Toast.LENGTH_SHORT).show()
                binding.loginProgress.visibility = View.GONE
            }else{
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra(HomeActivity.EXTRA_TOKEN, "Bearer "+token)
                startActivity(intent)
                finish()
            }
        })

    }
}