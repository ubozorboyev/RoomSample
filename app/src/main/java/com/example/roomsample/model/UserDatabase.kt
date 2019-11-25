package com.example.roomsample.model

import android.content.Context
import androidx.room.*
@Database(entities = arrayOf(UserData::class),version = 1,exportSchema = false)
abstract class UserDatabase :RoomDatabase(){
    abstract fun userDao():UserDao

    companion object{
        private lateinit var database: UserDatabase
        fun init(context: Context){
            synchronized(this){
                database=Room.databaseBuilder(context,UserDatabase::class.java,"user_table.db").build()
            }
        }

        fun getInstanse()= database

    }

}