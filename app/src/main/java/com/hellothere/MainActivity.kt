package com.hellothere

import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mediaPlayer: MediaPlayer // Plays the audio
    private lateinit var drawerLayout: DrawerLayout // Drawer menu

    /* Fragments */
    private var fragOne: ObiWanFrag = ObiWanFrag()
    private var secondFrag: GeneralGreviousFrag = GeneralGreviousFrag()
    private var thirdFrag: PapaPalpsFrag = PapaPalpsFrag()
    private var fourthFrag: AboutFragment = AboutFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerLayout)

        mediaPlayer = MediaPlayer.create(this, R.raw.hello_there_sound)
        mediaPlayer.start()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout_fragment, fragOne)
            commit()
        }

        // When top bar is clicked, open draw.
        findViewById<MaterialToolbar>(R.id.topAppBar).setNavigationOnClickListener {
            drawerLayout.open()
        }

        // When top bar item is clicked. Close draw.
        findViewById<NavigationView>(R.id.navigationView).setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.close()
            true
        }

    }

    override fun onClick(view: View) {
        mediaPlayer = MediaPlayer.create(this, R.raw.hello_there_sound)

        if (view.id == R.id.hello_there || view.id == R.id.gifImageViewObiWan) {
            playSound(R.raw.hello_there_sound)
        } else if (view.id == R.id.general_kenobi || view.id == R.id.gifImageViewGrevious) {
            playSound(R.raw.general_kenobi_sound)
        } else if (view.id == R.id.do_it || view.id == R.id.palpatineGif) {
            playSound(R.raw.do_it_trimmed)
        }
    }

    private fun playSound(soundID: Int) {
        mediaPlayer = MediaPlayer.create(this, soundID)
        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener {
            onCompletion(mediaPlayer)
        }
    }

    private fun onCompletion(mediaPlayer: MediaPlayer?) {
        mediaPlayer?.release()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawerLayout = findViewById(R.id.drawerLayout)
        when (item.itemId) {
            R.id.menu1 -> { // Obi Wan
                supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout_fragment, fragOne)
                        .addToBackStack(null)
                        .commit()
            }
            R.id.menu2 -> { // General Grevious
                supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout_fragment, secondFrag)
                        .addToBackStack(null)
                        .commit()
            }
            R.id.menu3 -> { // Palpatine
                supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout_fragment, thirdFrag)
                        .addToBackStack(null)
                        .commit()
            }
            R.id.about -> { // About page
                supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout_fragment, fourthFrag)
                        .addToBackStack(null)
                        .commit()
            }
        }; drawerLayout.close()
        return true
    }
}


