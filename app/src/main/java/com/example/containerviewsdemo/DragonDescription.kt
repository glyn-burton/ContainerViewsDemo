package com.example.containerviewsdemo

import android.graphics.drawable.Drawable
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_dragon_description.*

class DragonDescription : AppCompatActivity() {
    var dragon_info_string = ""
    var dragonCryChrom = R.raw.dragoncryone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragon_description)

        val passedDragons = intent?.getParcelableExtra<Dragons>(DRAGON_KEY)
        when {

            passedDragons?.species == "CHROMATIC" -> {
                dragonCryChrom = R.raw.dragoncryone
                when
                {
                    passedDragons?.nickname == "Big Red" -> dragon_info_string = red_dragon_info
                    passedDragons?.nickname == "Valara" -> dragon_info_string = black_dragon_info
                    passedDragons?.nickname == "RT" -> dragon_info_string = green_dragon_info
                }
            }
            passedDragons?.species == "METALLIC" -> {
                dragonCryChrom = R.raw.dragoncrytwo

                when
                {
                    passedDragons?.nickname == "Golly" -> dragon_info_string = gold_dragon_info
                    passedDragons?.nickname == "Sufa" -> dragon_info_string = silver_dragon_info
                    passedDragons?.nickname == "Tash" -> dragon_info_string = bronze_dragon_info
                }
            }
            passedDragons?.species == "GEM" -> {
                dragonCryChrom = R.raw.dragoncrythree

                when
                {
                    passedDragons?.nickname == "Dara" -> dragon_info_string = amethyst_dragon_info
                    passedDragons?.nickname == "Minnie" -> dragon_info_string = sapphire_dragon_info
                }
            }
            passedDragons?.species == "PLANAR" -> {
                dragonCryChrom = R.raw.dragoncryfour
                when
                {
                    passedDragons?.nickname == "Angel" -> dragon_info_string = celestial_dragon_info
                    passedDragons?.nickname == "Bo" -> dragon_info_string = shadow_dragon_info
                }
            }
            passedDragons?.species == "UNDEAD" -> {
                dragonCryChrom = R.raw.dragoncryfive
                when
                {
                    passedDragons?.nickname == "Zuzu" -> dragon_info_string = vampiric_dragon_info
                    passedDragons?.nickname == "Gloro" -> dragon_info_string = ghost_dragon_info
                }
            }

        }
        var dragonImage = when  {
            passedDragons?.nickname == "Big Red" -> { R.drawable.reddragon }
            passedDragons?.nickname == "Valara" -> {R.drawable.blackdragon}
            passedDragons?.nickname == "Golly" -> {R.drawable.golddragon}
            passedDragons?.nickname == "Sufa" -> {R.drawable.silverdragon}
            passedDragons?.nickname == "Dara" -> {R.drawable.amethystdragon}
            passedDragons?.nickname == "Minnie" -> {R.drawable.sapphiredragon}
            passedDragons?.nickname == "Angel" -> {R.drawable.celestialdragon}
            passedDragons?.nickname == "Bo" -> {R.drawable.shadowdragon}
            passedDragons?.nickname == "Zuzu" -> {R.drawable.vampiredragon}
            passedDragons?.nickname == "Gloro" -> {R.drawable.ghostdragon}
            passedDragons?.nickname == "RT" -> {R.drawable.greendragon}
            passedDragons?.nickname == "Tash" -> {R.drawable.bronzedragon}


            else -> R.drawable.dragons
        }
        tvDragonNickname.text =  passedDragons?.nickname ?: "Unknown"
        tvDragonSubSpecies.text =   "Subspecies: " + passedDragons?.subSpecies ?: "Unknown"
        tvBreathAttack.text =  "Breath Attack: " + passedDragons?.breathAttack ?: "Unknown"
        tvFavoriteFood.text =   "Favorite Food: "+ passedDragons?.favFood ?: "Unknown"
        imDragonImage.setImageResource(dragonImage)
        tvAboutDragon.text = dragon_info_string
    }

    fun DragonCry(view: View) {


        var mediaPlayer: MediaPlayer? = MediaPlayer.create(this, dragonCryChrom)
        mediaPlayer?.start()

    }


}
