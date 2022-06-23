package com.example.mysqliteexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Escoger : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escoger)

        findViewById<Button>(R.id.btnEst).setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnCurs).setOnClickListener{
            startActivity(Intent(this,Cursos::class.java))
        }

    }
}