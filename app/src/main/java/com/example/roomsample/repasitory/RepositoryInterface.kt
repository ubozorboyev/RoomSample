package com.example.roomsample.repasitory

import androidx.lifecycle.LiveData
import com.example.roomsample.model.UserData

interface RepositoryInterface {
    fun addUser(userData: UserData)
    fun getAllUser():LiveData<List<UserData>>
    fun updateUser(userData: UserData)
    fun deleteUser(id: Int)

}