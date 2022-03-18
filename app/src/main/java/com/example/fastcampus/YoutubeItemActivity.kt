package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class YoutubeItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_item)


        val videoUrl = intent.getStringExtra("video_url")

        val mediaController = MediaController(this)

        findViewById<VideoView>(R.id.youtube_video_view).apply {
            this.setVideoPath(videoUrl)
            this.requestFocus()
            this.start()
            mediaController.show()
        }
    }

    // Exoplayer
    // - 기능이 다양함
    // - 사용이 쉽다
    // - DRM
    // - Streaming
}