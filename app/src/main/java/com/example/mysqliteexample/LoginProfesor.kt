package com.example.mysqliteexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mysqliteexample.Models.Admin

class LoginProfesor : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_profesor)

        var et_user_name = findViewById(R.id.et_user_nameProfe) as EditText
        var et_password = findViewById(R.id.passwordProfe) as EditText
        var btn_submit = findViewById(R.id.btnLogearProfe) as Button

        btn_submit.setOnClickListener {
            val user_name = et_user_name.text;
            val password = et_password.text;

             val profe1 =
                 com.example.mysqliteexample.Models.Profesor("123","Pablo","87542165","pablo@gmail.com","pablito","profesor");


            if(profe1.cedula == user_name.toString() && profe1.clave == password.toString()){

                val i = Intent(this, listView::class.java)
                startActivity(i)
                finish()

            }else{
                Toast.makeText(this, "El usuario no se encuentra registrado", Toast.LENGTH_SHORT).show()
            }

        }
    }
}