package com.example.mysqliteexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mysqliteexample.Models.Admin

class LoginAdmin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_admin)

        var et_user_name = findViewById(R.id.et_user_nameAdmin) as EditText
        var et_password = findViewById(R.id.passwordAdmin) as EditText
        var btn_submit = findViewById(R.id.btnLogearAdmin) as Button

        btn_submit.setOnClickListener {
            val user_name = et_user_name.text;
            val password = et_password.text;
           val admin = Admin("admin","admin","admin")

            if(admin.user == user_name.toString() && admin.password == password.toString() ){
                val bundle = Bundle()
                val i = Intent(this, listView::class.java)
                startActivity(i)
                finish()

            }else{
                Toast.makeText(this, "El usuario no se encuentra registrado", Toast.LENGTH_SHORT).show()
            }

        }


    }

}

