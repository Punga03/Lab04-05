package com.example.mysqliteexample

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_carrera.*
import kotlinx.android.synthetic.main.activity_ciclo.*
import kotlinx.android.synthetic.main.activity_cursos.*


class Carrera : AppCompatActivity() {

    internal var dbHelper = DatabaseHelperCarrera(this)

    fun showToast(text: String){
        Toast.makeText(this@Carrera, text, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrera)

        handleInserts()
        handleUpdates()
        handleDeletes()
        handleViewing()
        handleSearch()
    }

    fun showDialog(title : String,Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    fun clearEditTexts(){
        idCarrera.setText("")
        idNombre.setText("")
        idTitulo.setText("")
        idAnno.setText("")
        idCICLO.setText("")
    }

    fun handleInserts() {
        insertBtnCarrera.setOnClickListener {
            try {
                dbHelper.insertData(
                    idCarrera.text.toString(),
                    idNombre.text.toString(),
                    idTitulo.text.toString(),
                    idAnno.text.toString(),
                    idCICLO.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleUpdates() {
        updateBtnCarrera.setOnClickListener {
            try {
                val isUpdate = dbHelper.updateData(
                    idCarrera.text.toString(),
                    idNombre.text.toString(),
                    idTitulo.text.toString(),
                    idAnno.text.toString(),
                    idCICLO.text.toString()
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
        deleteBtnCarrera.setOnClickListener {
            try {
                dbHelper.deleteData(idCarrera.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleViewing() {
        viewBtnCarrera.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.allData
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }

                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("CODIGO :" + res.getString(0) + "\n")
                    buffer.append("NOMBRE :" + res.getString(1) + "\n")
                    buffer.append("TITULO :" + res.getString(2) + "\n")
                    buffer.append("ANNO :" + res.getString(3) + "\n")
                    buffer.append("CICLO :" + res.getString(4) + "\n\n")
                }
                showDialog("Data Listing", buffer.toString())
            }
        )
    }

    fun handleSearch()  {
        btnSearchCarrera.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.searchData(idCarrera.text.toString())
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }
                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("CODIGO :" + res.getString(0) + "\n")
                    buffer.append("NOMBRE :" + res.getString(1) + "\n")
                    buffer.append("TITULO :" + res.getString(2) + "\n")
                    buffer.append("ANNO :" + res.getString(3) + "\n")
                    buffer.append("CICLO :" + res.getString(4) + "\n\n")
                }
                showDialog("Dato", buffer.toString())
            }
        )
    }




}









