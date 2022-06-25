package com.example.mysqliteexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mysqliteexample.Models.Alumno

class LoginAlumno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_alumno)

        var et_user_name = findViewById(R.id.et_user_nameAlumno) as EditText
        var et_password = findViewById(R.id.passwordAlumno) as EditText
        var btn_submit = findViewById(R.id.btnLogearAlumno) as Button

        btn_submit.setOnClickListener {
            val user_name = et_user_name.text;
            val password = et_password.text;

            val alumno1 = Alumno("117360079","Aaron Gutierrez",87305787,
                "aaron@gmail.com","02/03/99","Ing.Sistemas","aaron123","alumno");

            val alumno2 = Alumno("789789","Yoschua Villegas",89453215,
                "yoschua@gmail.com","04/10/2002","Ing.Sistemas","yoschua123","alumno");

            val alumno3 = Alumno("898989","Jesus Sanchez",78985621,
                "jesus@gmail.com","10/12/2001","Ing.Sistemas","jesus123","alumno");

            if(alumno1.cedula == user_name.toString() && alumno1.clave == password.toString()){

                val i = Intent(this, MenuAlumnos::class.java)
                startActivity(i)
                finish()

            }else{
                if(alumno2.cedula == user_name.toString() && alumno2.clave == password.toString()){

                    val i = Intent(this, MenuAlumnos::class.java)
                    startActivity(i)
                    finish()

                }else{
                    if(alumno3.cedula == user_name.toString() && alumno3.clave == password.toString()){

                        val i = Intent(this, MenuAlumnos::class.java)
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