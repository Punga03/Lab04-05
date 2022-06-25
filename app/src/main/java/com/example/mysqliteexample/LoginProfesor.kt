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

             val profe1 = com.example.mysqliteexample.Models.Profesor("123","Pablo",
                 "87542165","pablo@gmail.com","pablito","profesor");

            val profe2 = com.example.mysqliteexample.Models.Profesor("234","Jhonny",
                "87878787","jhnonny@gmail.com","jhony123","profesor");

            val profe3 = com.example.mysqliteexample.Models.Profesor("565","Jose",
                "6578921","jose@gmail.com","josesito","profesor");


            if(profe1.cedula == user_name.toString() && profe1.clave == password.toString()){

                val i = Intent(this, MenuProfesor::class.java)
                startActivity(i)
                finish()

            }else{
                if(profe2.cedula == user_name.toString() && profe2.clave == password.toString()){

                    val i = Intent(this, MenuProfesor::class.java)
                    startActivity(i)
                    finish()

                }else{
                    if(profe3.cedula == user_name.toString() && profe3.clave == password.toString()){

                        val i = Intent(this, MenuProfesor::class.java)
                        startActivity(i)
                        finish()

                    }else{
                        Toast.makeText(this, "El usuario no se encuentra registrado", Toast.LENGTH_SHORT).show()
                    }
                }

            }


        }
    }
}