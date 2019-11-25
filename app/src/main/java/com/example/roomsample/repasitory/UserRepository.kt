package com.example.roomsample.repasitory

import androidx.lifecycle.LiveData
import com.example.roomsample.model.UserDao
import com.example.roomsample.model.UserData

class UserRepository (val userDao: UserDao) :RepositoryInterface{

    override fun addUser(userData: UserData) {
        userDao.insert(userData)
    }

    override fun getAllUser(): LiveData<List<UserData>> {
        return userDao.getAllUser()
    }

    override fun updateUser(userData: UserData) {
        userDao.update(userData)
    }

    override fun deleteUser(id: Int) {
        userDao.deteteUser(id)
    }
}