package com.example.roomsample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomsample.model.UserData
import com.example.roomsample.model.UserDatabase
import com.example.roomsample.repasitory.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) :AndroidViewModel(application){
    private val repository:UserRepository
    val allusers:LiveData<List<UserData>>

    init {
        val userDao=UserDatabase.getInstanse().userDao()
        repository=UserRepository(userDao)
        allusers=repository.getAllUser()
    }

     fun insert(userData: UserData)=viewModelScope.launch {
         repository.addUser(userData)
     }

    fun delete(id:Int)=viewModelScope.launch {
        repository.deleteUser(id)
    }

    fun updateUser(userData: UserData){
        repository.updateUser(userData)
    }

}