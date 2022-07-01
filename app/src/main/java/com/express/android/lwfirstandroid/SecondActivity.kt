package com.express.android.lwfirstandroid

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.express.android.lwfirstandroid.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("user")
        val password = intent.getStringExtra("password")

        binding.tvWelcome.setText("Welcome ${username}, you entered ${password}")
    }
}