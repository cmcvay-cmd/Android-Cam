// VideoUploadActivity.kt
package com.example.faceverification

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.faceverification.databinding.ActivityVideoUploadBinding
import com.github.hiteshsondhi88.libffmpeg.FFmpeg

class VideoUploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoUploadBinding
    private lateinit var ffmpeg: FFmpeg

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ffmpeg = FFmpeg.getInstance(this)

        binding.selectVideoButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "video/*"
            }
            startActivityForResult(intent, REQUEST_VIDEO)
        }

        binding.streamVideoButton.setOnClickListener {
            if (binding.videoUri != null) {
                startActivity(Intent(this, VideoStreamActivity::class.java).apply {
                    putExtra("video_uri", binding.videoUri.toString())
                })
            } else {
                Toast.makeText(this, "Please select a video first", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_VIDEO && resultCode == RESULT_OK) {
            data?.data?.let { uri ->
                binding.videoUri = uri
                binding.selectedVideoText.text = "Selected Video: ${uri.path}"
            }
        }
    }

    companion object {
        private const val REQUEST_VIDEO = 1
    }
}