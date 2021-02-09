package com.hellothere

import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import java.util.*

class MainActivity : AppCompatActivity() {
    private final lateinit var mediaPlayer: MediaPlayer
    private final lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFrag = ObiWanFrag()
        drawerLayout = findViewById(R.id.drawerLayout)
        mediaPlayer = MediaPlayer.create(this, R.raw.hello_there_sound)
        mediaPlayer.start()


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout_fragment, firstFrag)
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

    fun soundHelloThere(view: View) {
        mediaPlayer = MediaPlayer.create(this, R.raw.hello_there_sound)
//        view.setOnClickListener {
////            if (!mediaPlayer.isPlaying) {
////                mediaPlayer.start()
////            }
//
//        }
        mediaPlayer.start()
    }

    fun soundKenobi(view: View) {
        mediaPlayer = MediaPlayer.create(this, R.raw.general_kenobi_sound)
        mediaPlayer.start()
//        view.setOnClickListener {
//            if (!mediaPlayer.isPlaying) {
//                mediaPlayer.start()
//            }
//        }
    }

    fun soundPalpatine(view: View) {
        mediaPlayer = MediaPlayer.create(this, R.raw.do_it_trimmed)
//        view.setOnClickListener {
//            if (!mediaPlayer.isPlaying) {
//
//            }
//        }
        mediaPlayer.start()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawerLayout = findViewById(R.id.drawerLayout)
        when (item.itemId) {
            R.id.menu1 -> {
                val fragOne: ObiWanFrag = ObiWanFrag()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout_fragment, fragOne)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.menu2 -> {
                val secondFrag: GeneralGreviousFrag = GeneralGreviousFrag()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout_fragment, secondFrag)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.menu3 -> {
                val thirdFrag: PapaPalpsFrag = PapaPalpsFrag()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout_fragment, thirdFrag)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.about -> {
                val fourthFrag: AboutFragment = AboutFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout_fragment, fourthFrag)
                    .addToBackStack(null)
                    .commit()
            }
        };   drawerLayout.close()
        return true
    }





}
