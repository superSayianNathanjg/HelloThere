package com.hellothere

import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mediaPlayer: MediaPlayer // Plays the audio
    private lateinit var drawerLayout: DrawerLayout // Drawer menu

    /* Fragments */

    private val fragOne: ObiWanFrag = ObiWanFrag()
    private val fragTwo: GeneralGreviousFrag = GeneralGreviousFrag()
    private val fragThree: PapaPalpsFrag = PapaPalpsFrag()
    private val fragFour: DarthVaderFrag = DarthVaderFrag()
    private val fragAbout: AboutFragment = AboutFragment()

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
        }
        else if (view.id == R.id.older_kenobi) {
            playSound(R.raw.kenobi_old)
        }

        // Grevious
        else if (view.id == R.id.general_kenobi || view.id == R.id.gifImageViewGrevious) {
            playSound(R.raw.general_kenobi_sound)
        }else if (view.id == R.id.grevious_coughing) {
            playSound(R.raw.grevious_coughing)
        }
        else if (view.id == R.id.grevious_situation) {
            playSound(R.raw.general_grevious_situation)
        }


        // Palpatine
        else if (view.id == R.id.do_it || view.id == R.id.palpatineGif) {
            playSound(R.raw.do_it_trimmed)
        }
        else if (view.id == R.id.order_66_palpatine) {
            playSound(R.raw.order66_palpatine)
        }
        else if (view.id == R.id.senate) {
            playSound(R.raw.senate_palpatine)
        }

        // Vader
        else if (view.id == R.id.i_am_your_button || view.id == R.id.i_am_your_father_gif) {
            playSound(R.raw.i_am_your_sound)
        }
        else if (view.id == R.id.lack_of_faith_vader) {
            playSound(R.raw.faith_vader)
        }
        else if (view.id == R.id.yes_vader) {
            playSound(R.raw.yes_vader)
        }
        else if (view.id == R.id.fail_me_vader) {
            playSound(R.raw.fail_me_vader)
        }
        else if (view.id == R.id.apology_vader) {
            playSound(R.raw.apology_vader)
        }
        else if (view.id == R.id.noooo) {
            playSound(R.raw.nooo)
        }

    }

//    private fun playSound(view: View, soundID: Int) {
//        view.setOnClickListene
//        )
//
//    }

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
                        .replace(R.id.frame_layout_fragment, fragTwo)
                        .addToBackStack(null)
                        .commit()
            }
            R.id.menu3 -> { // Palpatine
                supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout_fragment, fragThree)
                        .addToBackStack(null)
                        .commit()
            }
            R.id.menu4 -> { // Darth Vader
                supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout_fragment, fragFour)
                        .addToBackStack(null)
                        .commit()
            }
            R.id.about -> { // About page
                supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout_fragment, fragAbout)
                        .addToBackStack(null)
                        .commit()
            }
        }; drawerLayout.close()
        return true
    }
}


