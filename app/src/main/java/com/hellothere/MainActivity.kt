package com.hellothere

import android.graphics.Typeface
import android.media.MediaPlayer
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFrag = ObiWanFrag()
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)


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
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.hello_there_sound)
        view.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }
    }

    fun soundKenobi(view: View) {
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.general_kenobi)
        view.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        when (item.itemId) {
            R.id.menu1 -> {
                val fragOne: ObiWanFrag = ObiWanFrag()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout_fragment, fragOne)
                    .commit()
            }
            R.id.menu2 -> {
                val secondFrag: GeneralGerviousFrag = GeneralGerviousFrag()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout_fragment, secondFrag)
                    .commit()
            }
            R.id.menu3 -> {
                Toast.makeText(this, "Dewwwit, coming soon ;)", Toast.LENGTH_LONG).show()
            }
        };   drawerLayout.close()
        return true
    }

}
