package com.example.per8_tugas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.per8_tugas.LoginFragment.Companion.EXTRA_USERNAME
import com.example.per8_tugas.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_PASSWORD = "extra_password"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_USERNAME)
        val password = intent.getStringExtra(EXTRA_PASSWORD)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val phone = intent.getStringExtra((EXTRA_PHONE))

        with(binding) {
            txtUsername.text = username
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_back -> {
                val intentToMainActivity = Intent(this,MainActivity::class.java)
                startActivity(intentToMainActivity)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}