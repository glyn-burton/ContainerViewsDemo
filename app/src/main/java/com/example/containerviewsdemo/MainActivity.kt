package com.example.containerviewsdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun DragonMainSite(view: View) {

        var intent = Intent(this, DragonTypesActivity::class.java)
        startActivity(intent)

    }
}
