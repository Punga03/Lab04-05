package com.example.mysqliteexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuAlumnos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_alumnos)


        findViewById<Button>(R.id.btnMatricular).setOnClickListener{
            startActivity(Intent(this,Matricula::class.java))
        }
    }
}