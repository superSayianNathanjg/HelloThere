package com.hellothere

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.awaitAll

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFrag = ObiWanFrag()
        val secondFrag = GeneralGerviousFrag()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout_fragment, firstFrag)
            commit()
        }

        findViewById<Button>(R.id.obi_wan_button).setOnClickListener {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout_fragment, firstFrag)
                addToBackStack(null)
                commit()
            }
        }

        findViewById<Button>(R.id.general_grevious_button).setOnClickListener {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout_fragment, secondFrag)
                addToBackStack(null)
                commit()

            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)

        findViewById<MaterialToolbar>(R.id.topAppBar).setNavigationOnClickListener {
            drawerLayout.open()
        }


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
}


//        findViewById<Button>(R.id.hello_there).setOnClickListener(View.OnClickListener {
////            val intent = Intent(this, SecondActivity::class.java)
////            startActivity(intent)

//        })

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu_toolbar, menu)
//        return true
//    }