package com.hellothere

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment

class AboutFragment : Fragment(R.layout.fragment_about) {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mediaPlayer = MediaPlayer.create(context, R.raw.catina_band)
        mediaPlayer.start()
    }
    override fun onPause() {
        super.onPause()
        mediaPlayer.pause()
    }

  //  Create sound function for each sound wihtin each fragment?
}