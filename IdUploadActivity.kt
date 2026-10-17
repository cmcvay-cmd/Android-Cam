// IdUploadActivity.kt
package com.example.faceverification

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.faceverification.databinding.ActivityIdUploadBinding

class IdUploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIdUploadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectIdButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
            }
            startActivityForResult(intent, REQUEST_IMAGE)
        }

        binding.verifyIdButton.setOnClickListener {
            if (binding.idUri != null) {
                // Implement ID verification logic here
                Toast.makeText(this, "ID Verification in Progress...", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please select an ID image first", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK) {
            data?.data?.let { uri ->
                binding.idUri = uri
                binding.selectedIdText.text = "Selected ID: ${uri.path}"
            }
        }
    }

    companion object {
        private const val REQUEST_IMAGE = 2
    }
}