package com.example.mysqliteexample

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ciclo.*
import kotlinx.android.synthetic.main.activity_grupo.*

class Grupo : AppCompatActivity() {

    internal var dbHelper = DataBaseHelperGrupo(this)

    fun showToast(text: String){
        Toast.makeText(this@Grupo, text, Toast.LENGTH_LONG).show()
    }

    fun showDialog(title : String,Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    fun clearEditTexts(){
        numeroGrupo.setText("")
        cicloGrupo.setText("")
        cursoGrupo.setText("")
        horarioGrupo.setText("")
        profesorGrupo.setText("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grupo)

        handleInserts()
        handleUpdates()
        handleDeletes()
        handleViewing()
        handleSearch()
    }

    fun handleInserts() {
        insertBtnGrupo.setOnClickListener {
            try {
                dbHelper.insertData(numeroGrupo.text.toString(),cicloGrupo.text.toString(),
                    cursoGrupo.text.toString(),horarioGrupo.text.toString(),profesorGrupo.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleUpdates() {
        updateBtnGrupo.setOnClickListener {
            try {
                val isUpdate = dbHelper.updateData(
                    numeroGrupo.text.toString(),
                    cicloGrupo.text.toString(),
                    cursoGrupo.text.toString(),
                    horarioGrupo.text.toString(),
                    profesorGrupo.text.toString()
                )
                if (isUpdate == true)
                    showToast("Data Updated Successfully")
                else
                    showToast("Data Not Updated")
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleDeletes(){
        deleteBtnGrupo.setOnClickListener {
            try {
                dbHelper.deleteData(numeroGrupo.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleViewing() {
        viewBtnGrupo.setOnClickListener(
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
        btnSearchGrupo.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.searchData(numeroGrupo.text.toString())
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