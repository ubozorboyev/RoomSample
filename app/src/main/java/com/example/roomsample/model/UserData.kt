package com.example.roomsample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val _id:Int?=null,

    @ColumnInfo(name = "name")
    var name:String,

    @ColumnInfo(name = "username")
    var username:String
)