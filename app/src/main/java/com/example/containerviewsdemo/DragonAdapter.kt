package com.example.containerviewsdemo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.singular_dragon.view.*


class DragonAdapter (val dragonListing : ArrayList<Dragons>) : RecyclerView.Adapter<DragonAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.singular_dragon, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.populateItem(dragonListing[position])
    }


    override fun getItemCount() = dragonListing.size

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        fun populateItem(dragon: Dragons)
        {
            itemView.tvDragonTitles.text = dragon.nickname
            itemView.setOnClickListener {
                val intent = Intent(it.context, DragonDescription::class.java)
                intent.putExtra(DRAGON_KEY, dragon)
                it.context.startActivity(intent)
            }
        }

    }
}










