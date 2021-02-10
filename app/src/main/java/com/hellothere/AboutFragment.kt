package com.hellothere

import android.content.res.Resources
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.hellothere.R.*

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
            }
            else {
                mediaPlayer.pause()
            }
        }

        val textView: TextView = view.findViewById(R.id.patreon_link)
        textView.movementMethod = LinkMovementMethod.getInstance()
        textView.setLinkTextColor(Color.CYAN)

    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }



  //  Create sound function for each sound wihtin each fragment?
}