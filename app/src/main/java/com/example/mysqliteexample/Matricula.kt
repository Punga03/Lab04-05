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

class Matricula : AppCompatActivity() {

    internal var dbHelper = DataBaseHelperGrupo(this)

    fun showDialog(title : String,Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    fun clearEditTexts(){
        numeroGrupoMatricula.setText("")
        numeroGrupoBuscarM.setText("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matricula)

        handleViewing()
        handleSearch()

        findViewById<Button>(R.id.matricularBtn).setOnClickListener{
            Toast.makeText(this, "HA SIDO MATRICULADO", Toast.LENGTH_LONG).show()

            startActivity(Intent(this,listViewPrincipal::class.java))
        }
    }

    fun handleViewing() {
        btnDesplegar.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.allData
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }

                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("NUMEROGRUPO :" + res.getString(0) + "\n")
                    buffer.append("CICLO :" + res.getString(1) + "\n")
                    buffer.append("CURSO :" + res.getString(2) + "\n")
                    buffer.append("HORARIO :" + res.getString(3) + "\n")
                    buffer.append("PROFESOR :" + res.getString(4) + "\n\n")
                }
                showDialog("Data Listing", buffer.toString())
            }
        )
    }

    fun handleSearch()  {
        btnBuscarGr.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.searchData(numeroGrupoBuscarM.text.toString())
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }
                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("NUMEROGRUPO :" + res.getString(0) + "\n")
                    buffer.append("CICLO :" + res.getString(1) + "\n")
                    buffer.append("CURSO :" + res.getString(2) + "\n")
                    buffer.append("HORARIO :" + res.getString(3) + "\n")
                    buffer.append("PROFESOR :" + res.getString(4) + "\n\n")
                }
                showDialog("Dato", buffer.toString())
            }
        )
    }
































}