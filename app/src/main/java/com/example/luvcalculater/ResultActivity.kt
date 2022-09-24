package com.example.luvcalculater

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.luvcalculater.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initCliker()
        binding.prosentTv.text = intent.getStringExtra("key2")+"%"
        binding.snameTv.text = intent.getStringExtra("key1")
        binding.fnameTv.text = intent.getStringExtra("key")


    }

    private fun initCliker() {
        binding.btnRestart.setOnClickListener {
            var intent:Intent =  Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

