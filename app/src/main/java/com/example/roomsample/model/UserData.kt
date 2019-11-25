package com.example.roomsample.model

import androidx.annotation.IdRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserData(
    @PrimaryKey @ColumnInfo(name = "_id") val idRes:Int,
    @ColumnInfo(name = "name") var name:String

)