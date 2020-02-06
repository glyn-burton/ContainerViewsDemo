package com.example.containerviewsdemo
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dragons (

    var species:String,
    var nickname:String,
    var subSpecies:String,
    var breathAttack:String,
    var favFood:String
):Parcelable