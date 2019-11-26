package com.example.roomsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomsample.R
import com.example.roomsample.model.UserData
import com.example.roomsample.ui.dialog.AddUserDialog
import com.example.roomsample.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private val viewmodel:UserViewModel by lazy { UserViewModel(application) }
private val adapter:UserAdapter= UserAdapter()
private val dialog by lazy {AddUserDialog(this)}
private var count=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView.adapter=adapter

        viewmodel.allusers.observe(this, Observer {
            adapter.setList(it)
        })

        fabButton.setOnClickListener {
            viewmodel.insert(UserData(null,"Name ${++count}","Surname $count"))
//         dialog.showDialog()
        }

        dialog.onClickListener {
            Log.d("FFF","userdada $it")
            viewmodel.insert(it)
        }


    }
}
