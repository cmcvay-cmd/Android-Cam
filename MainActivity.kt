// MainActivity.kt
package com.example.faceverification

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.faceverification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.uploadVideoButton.setOnClickListener {
            startActivity(Intent(this, VideoUploadActivity::class.java))
        }

        binding.uploadIdButton.setOnClickListener {
            startActivity(Intent(this, IdUploadActivity::class.java))
        }
    }
}