package com.example.roomdatabse

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
class User(id:Int?,firstName:String?,lastName:String?,age:Int?) {

    @PrimaryKey(autoGenerate = true)
    val id:Int? = 0

    val firstName:String? = null

    val lastName:String? = null

    val age:Int? = 0
}

