package com.example.mysqliteexample

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cursos.*
import kotlinx.android.synthetic.main.activity_grupo.*
import kotlinx.android.synthetic.main.activity_matricula.*

class CalificarActivity : AppCompatActivity() {



    fun clearEditTexts(){
        numeroGrupoMatricula.setText("")
        numeroGrupoBuscarM.setText("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_nota)

        findViewById<Button>(R.id.califBtn).setOnClickListener{
            Toast.makeText(this, "Nota asignada", Toast.LENGTH_LONG).show()

            startActivity(Intent(this,listViewPrincipal::class.java))
        }

    }



}