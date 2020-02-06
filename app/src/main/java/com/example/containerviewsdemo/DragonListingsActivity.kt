package com.example.containerviewsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_dragon_listings.*

class DragonListingsActivity : AppCompatActivity() {

    val adapter  by lazy{DragonAdapter(dragonList)}

    var dragonList : ArrayList<Dragons> = ArrayList<Dragons>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragon_listings)
        dragonList = intent.getParcelableArrayListExtra(DRAGON_KEY)
        initRecyclerView()
    }
    private fun initRecyclerView()
    {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvDragonListing.layoutManager = layoutManager
        rvDragonListing.addItemDecoration((itemDecoration))
        rvDragonListing.adapter = adapter
    }
}
