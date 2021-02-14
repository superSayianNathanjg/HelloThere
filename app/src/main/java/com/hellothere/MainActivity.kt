package com.hellothere

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var drawerLayout: DrawerLayout // Drawer menu
    private lateinit var soundPool: SoundPool

    /* Fragments */
    private val fragOne: ObiWanFrag = ObiWanFrag()
    private val fragTwo: GeneralGreviousFrag = GeneralGreviousFrag()
    private val fragThree: PapaPalpsFrag = PapaPalpsFrag()
    private val fragFour: DarthVaderFrag = DarthVaderFrag()
    private val fragAbout: AboutFragment = AboutFragment()

    /* Buttons */
    // Obi Wan
    private var helloThere: Int = 0
    private var highGround: Int = 0
    private var goodJob: Int = 0
    private var goodBye: Int = 0
    private var halfShip: Int = 0
    private var oldKenobi: Int = 0

    // Grevious
    private var generalKenobi: Int = 0
    private var situation: Int = 0
    private var coughing: Int = 0

    // Palpatine
    private var doIt: Int = 0
    private var order66: Int = 0
    private var senate: Int = 0
    private var goodPalpatine: Int = 0
    private var weakPalpatine: Int = 0

    // Darth Vader
    private var iAmYourFather: Int = 0
    private var apologyAccepted: Int = 0
    private var lackOfFaith: Int = 0
    private var yesVader: Int = 0
    private var dontFailMe: Int = 0
    private var noooVader: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerLayout)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val audioAttributes: AudioAttributes? = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build()
            soundPool = SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build()
        } else {
            soundPool = SoundPool(5, AudioManager.STREAM_MUSIC, 0)
        }

        // Loading SoundPool
        // Obi Wan
        helloThere = soundPool.load(this, R.raw.hello_there_sound, 1)
        highGround = soundPool.load(this, R.raw.high_ground_kenobi, 1)
        goodJob = soundPool.load(this, R.raw.good_job_kenobi, 1)
        goodBye = soundPool.load(this, R.raw.goodbye_kenobi, 1)
        halfShip = soundPool.load(this, R.raw.half_ship_kenobi, 1)
        oldKenobi = soundPool.load(this, R.raw.kenobi_old, 1)

        // Grevious
        generalKenobi = soundPool.load(this, R.raw.general_kenobi_sound,1)
        situation = soundPool.load(this, R.raw.general_grevious_situation,1)
        coughing = soundPool.load(this, R.raw.grevious_coughing ,1)

        // Palpatine
        doIt = soundPool.load(this, R.raw.do_it_trimmed , 1)
        order66 = soundPool.load(this,R.raw.order66_palpatine , 1)
        senate = soundPool.load(this,R.raw.senate_palpatine , 1)
        goodPalpatine = soundPool.load(this,R.raw.good_palpatine , 1)
        weakPalpatine = soundPool.load(this, R.raw.too_weak_palpatine , 1)

        // Darth Vader
       iAmYourFather = soundPool.load(this,R.raw.i_am_your_sound , 1)
       apologyAccepted = soundPool.load(this, R.raw.apology_vader , 1)
       lackOfFaith = soundPool.load(this,R.raw.faith_vader , 1)
       yesVader = soundPool.load(this, R.raw.yes_vader, 1)
       dontFailMe = soundPool.load(this, R.raw.fail_me_vader, 1)
       noooVader = soundPool.load(this,R.raw.nooo , 1)

        /* Navigation */
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
        when (view.id) {
            // Obi Wan
            R.id.hello_there -> {
                soundPool.play(helloThere, 1F, 1F, 0, 0, 1F)
            }
            R.id.high_ground_obi -> {
                soundPool.play(highGround, 1F, 1F, 0, 0, 1F)
            }
            R.id.good_job_obi -> {
                soundPool.play(goodJob, 1F, 1F, 0, 0, 1F)
            }
            R.id.goodbye_obi -> {
                soundPool.play(goodBye, 1F, 1F, 0, 0, 1F)
            }
            R.id.half_a_ship_obi -> {
                soundPool.play(halfShip, 1F, 1F, 0, 0, 1F)
            }
            R.id.older_kenobi -> {
                soundPool.play(oldKenobi, 1F, 1F, 0, 0, 1F)
            }
            // Grevious
            R.id.general_kenobi -> {
                soundPool.play(generalKenobi, 1F, 1F, 0, 0, 1F)
            }
            R.id.grevious_situation -> {
            soundPool.play(situation, 1F, 1F, 0, 0, 1F)
            }
            R.id.grevious_coughing -> {
            soundPool.play(coughing, 1F, 1F, 0, 0, 1F)
            }
            // Palpatine
            R.id.do_it -> {
                soundPool.play(doIt, 1F, 1F, 0, 0, 1F)
            }
            R.id.order_66_palpatine -> {
                soundPool.play(order66, 1F, 1F, 0, 0, 1F)
            }
            R.id.senate -> {
                soundPool.play(senate, 1F, 1F, 0, 0, 1F)
            }
            R.id.good_palpatine -> {
                soundPool.play(goodPalpatine, 1F, 1F, 0, 0, 1F)
            }
            R.id.weak_palpatine -> {
                soundPool.play(weakPalpatine, 1F, 1F, 0, 0, 1F)
            }
        }


//        if (view.id == R.id.hello_there || view.id == R.id.gifImageViewObiWan) {
//            playSound(R.raw.hello_there_sound)
//
//        }
//        else if (view.id == R.id.high_ground_obi) {
//            playSound(R.raw.high_ground_kenobi)
//        }
//        else if (view.id == R.id.good_job_obi) {
//            playSound(R.raw.good_job_kenobi)
//        }
//        else if (view.id == R.id.goodbye_obi) {
//            playSound(R.raw.goodbye_kenobi)
//        }
//        else if (view.id == R.id.half_a_ship_obi) {
//            playSound(R.raw.half_ship_kenobi)
//        }
//        else if (view.id == R.id.older_kenobi) {
//            playSound(R.raw.kenobi_old)
//        }
//
//        // Grevious
//        else if (view.id == R.id.general_kenobi || view.id == R.id.gifImageViewGrevious) {
//            playSound(R.raw.general_kenobi_sound)
//        }else if (view.id == R.id.grevious_coughing) {
//            playSound(R.raw.grevious_coughing)
//        }
//        else if (view.id == R.id.grevious_situation) {
//            playSound(R.raw.general_grevious_situation)
//        }
//
//
//        // Palpatine
//        else if (view.id == R.id.do_it || view.id == R.id.palpatineGif) {
//            playSound(R.raw.do_it_trimmed)
//        }
//        else if (view.id == R.id.order_66_palpatine) {
//            playSound(R.raw.order66_palpatine)
//        }
//        else if (view.id == R.id.senate) {
//            playSound(R.raw.senate_palpatine)
//        }
//        else if (view.id == R.id.good_palpatine) {
//            playSound(R.raw.good_palpatine)
//        }
//        else if (view.id == R.id.weak_palpatine) {
//            playSound(R.raw.too_weak_palpatine)
//        }
//
//        // Vader
//        else if (view.id == R.id.i_am_your_button || view.id == R.id.i_am_your_father_gif) {
//            playSound(R.raw.i_am_your_sound)
//        }
//        else if (view.id == R.id.lack_of_faith_vader) {
//            playSound(R.raw.faith_vader)
//        }
//        else if (view.id == R.id.yes_vader) {
//            playSound(R.raw.yes_vader)
//        }
//        else if (view.id == R.id.fail_me_vader) {
//            playSound(R.raw.fail_me_vader)
//        }
//        else if (view.id == R.id.apology_vader) {
//            playSound(R.raw.apology_vader)
//        }
//        else if (view.id == R.id.noooo) {
//            playSound(R.raw.nooo)
//        }

    }

    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }

    private fun playSound(soundID: Int) {

    }

//    private fun onCompletion(mediaPlayer: MediaPlayer?) {
//        mediaPlayer?.reset()
//    }

    // Navigation Menu
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


