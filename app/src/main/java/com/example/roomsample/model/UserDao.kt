package com.example.roomsample.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
      @Query("SELECT * FROM users ")
      fun getAllUser():LiveData<List<UserData>>

      @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun insert(userData: UserData)

      @Query("DELETE  FROM users WHERE _id= :id")
      fun deteteUser(id:Int)
      @Update
      fun update(userData: UserData)
}