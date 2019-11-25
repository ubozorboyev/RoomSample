package com.example.roomsample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomsample.model.UserData
import com.example.roomsample.model.UserDatabase
import com.example.roomsample.repasitory.UserRepository

class UserViewModel :ViewModel(){
    private val repository:UserRepository
    val allusers:LiveData<List<UserData>>

    init {
        val userDao=UserDatabase.getInstanse().userDao()
        repository=UserRepository(userDao)
        allusers=repository.getAllUser()
    }

    fun insert(userData: UserData){
        repository.addUser(userData)
    }
}