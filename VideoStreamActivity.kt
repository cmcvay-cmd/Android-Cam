// VideoStreamActivity.kt
package com.example.faceverification

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.faceverification.databinding.ActivityVideoStreamBinding
import com.github.hiteshsondhi88.libffmpeg.FFmpeg

class VideoStreamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoStreamBinding
    private lateinit var ffmpeg: FFmpeg

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoStreamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ffmpeg = FFmpeg.getInstance(this)

        intent.getStringExtra("video_uri")?.let { uriString ->
            val uri = Uri.parse(uriString)
            binding.videoView.setVideoURI(uri)
            binding.videoView.start()
        }
    }
}