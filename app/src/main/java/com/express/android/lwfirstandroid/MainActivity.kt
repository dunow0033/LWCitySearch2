package com.express.android.lwfirstandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.express.android.lwfirstandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            loginButton.setOnClickListener {
                val username = usernameInput.text.toString()
                val password = passwordInput.text.toString()

                if(TextUtils.isEmpty(username)) {
                    usernameInput.setError("Please enter username")
                } else if(TextUtils.isEmpty(password)) {
                    passwordInput.setError("Please enter password")
                } else {
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra("user", username)
                    intent.putExtra("password", password)

                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}