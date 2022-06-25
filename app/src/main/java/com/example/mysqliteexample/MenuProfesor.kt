package com.example.mysqliteexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuProfesor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_profesor)
        findViewById<Button>(R.id.btnCalificar).setOnClickListener{
            startActivity(Intent(this,listViewEstudiantes::class.java))
        }
    }
}