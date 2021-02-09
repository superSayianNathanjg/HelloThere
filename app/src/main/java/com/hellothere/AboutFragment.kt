package com.hellothere

import android.content.res.Resources
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hellothere.R.*

class AboutFragment : Fragment(layout.fragment_about) {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var switch: Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mediaPlayer = MediaPlayer.create(context, raw.catina_band)
        mediaPlayer.start()


    }
    override fun onPause() {
        super.onPause()
        mediaPlayer.pause()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val button: Button = view.findViewById(R.id.musicSwitch)
        button.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
            }
            else {
                mediaPlayer.pause()
            }
        }
    }



  //  Create sound function for each sound wihtin each fragment?
}