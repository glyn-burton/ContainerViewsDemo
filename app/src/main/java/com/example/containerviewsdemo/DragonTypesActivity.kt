package com.example.containerviewsdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_dragon_types.*

class DragonTypesActivity : AppCompatActivity() {
    val list by lazy { initList() }
    var dragonList : ArrayList<Dragons> = populateList()
    var speciesFilter : ArrayList<Dragons> = ArrayList<Dragons>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragon_types)
        initListView()
    }

    private fun populateList(): ArrayList<Dragons>{
        val returnList = ArrayList<Dragons>()
        returnList.add(Dragons("CHROMATIC", "Valara", "Black", "Lightning", "Fauns"))
        returnList.add(Dragons("CHROMATIC", "Big Red", "Red", "Fire", "Redheads"))
        returnList.add(Dragons("METALLIC", "Golly", "Gold", "Light", "Pizza"))
        returnList.add(Dragons("METALLIC", "Sufa", "Silver", "Ice", "Dim Sum"))
        returnList.add(Dragons("GEM", "Dara", "Amethyst", "Floral", "Vegetables"))
        returnList.add(Dragons("GEM", "Minnie", "Sapphire", "Water", "FroYo"))
        returnList.add(Dragons("PLANAR", "Angel", "Celestial", "Soul", "Steak"))
        returnList.add(Dragons("PLANAR", "Bo", "Shadow", "Darkness", "Emptiness"))
        returnList.add(Dragons("UNDEAD", "Zuzu", "Vampiric", "Blood", "Teenagers"))
        returnList.add(Dragons("UNDEAD", "Gloro", "Ghost", "Plasma", "Potato Chips"))
        returnList.add(Dragons("CHROMATIC", "RT", "Green", "Poison", "Seafood"))
        returnList.add(Dragons("METALLIC", "Tash", "Bronze", "Rust", "Chocolate"))
        return returnList

    }


    fun initListView () {

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list )

        lvDragonSpecies.adapter = adapter

        lvDragonSpecies.setOnItemClickListener{_,_,i,_ ->

            val intent = Intent(this, DragonListingsActivity::class.java)
            speciesFilter = dragonList.filter { it.species == list[i]} as ArrayList<Dragons>
            intent.putParcelableArrayListExtra(DRAGON_KEY, speciesFilter)
            startActivity(intent)


        }

    }

    fun initList() :ArrayList<String>{
        val stringList = ArrayList<String>()

        stringList.add("CHROMATIC")
        stringList.add("METALLIC")
        stringList.add("GEM")
        stringList.add("PLANAR")
        stringList.add("UNDEAD")


        return stringList

    }
}
