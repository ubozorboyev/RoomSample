package com.example.roomsample.ui.dialog

import android.app.AlertDialog
import android.content.Context
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.roomsample.R
import com.example.roomsample.model.UserData
import kotlinx.android.synthetic.main.dialog_view.view.*

class AddUserDialog(context: Context) {
    private var user_id:Int=0
    private val dialog=AlertDialog.Builder(context).create()
    private val view=LayoutInflater.from(context).inflate(R.layout.dialog_view,null,false)
    private var listener:((UserData)->Unit)?=null
    init {
        dialog.setView(view)
        onClickView(view)
    }

    fun onClickListener(ls:(UserData)->Unit){
        listener=ls
    }

    fun onClickView(view: View){
        view.apply {
            dialogOk.setOnClickListener {
                val name=inputName.text.toString()
                val username=inputSurname.text.toString()

                Log.d("FFF","name $name")

                if (name.isNotEmpty() && username.isNotEmpty()){
                    listener?.invoke(UserData( user_id++,name,username))
                    hideDialog()
                }
            }
            dialogCancel.setOnClickListener { hideDialog() }
        }
    }

    fun hideDialog(){
        dialog.dismiss()
    }

    fun showDialog(){
        dialog.show()
    }

}