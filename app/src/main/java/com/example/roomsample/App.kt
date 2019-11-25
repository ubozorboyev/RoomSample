package com.example.roomsample

import android.app.Application
import com.example.roomsample.model.UserDatabase

class App :Application(){
    override fun onCreate() {
        super.onCreate()
        UserDatabase.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        UserDatabase.getInstanse().close()
    }

}