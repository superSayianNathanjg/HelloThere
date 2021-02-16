/*
 * Copyright (c)  . All rights reserved.
 */

package com.hellothereapp

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.hellothereapp.R.layout
import com.hellothereapp.R.raw

class AboutFragment : Fragment(layout.fragment_about) {
    private lateinit var mediaPlayer: MediaPlayer
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

        val button: SwitchCompat = view.findViewById(R.id.musicSwitch)
        button.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            } else {
                mediaPlayer.pause()
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }


    //  Create sound function for each sound wihtin each fragment?
}