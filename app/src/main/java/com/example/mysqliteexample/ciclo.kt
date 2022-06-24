package com.example.mysqliteexample

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ciclo.*
import kotlinx.android.synthetic.main.activity_cursos.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnSearch
import kotlinx.android.synthetic.main.activity_profesor.*

class ciclo : AppCompatActivity() {

    internal var dbHelper = DatabaseHelperCiclo(this)

    fun showToast(text: String){
        Toast.makeText(this@ciclo, text, Toast.LENGTH_LONG).show()
    }

    fun showDialog(title : String,Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    fun clearEditTexts(){
        idCiclo.setText("")
        idNumero.setText("")
        idFechaI.setText("")
        idFechaF.setText("")
        idANNO.setText("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo)

        handleInserts()
        handleUpdates()
        handleDeletes()
        handleViewing()
        handleSearch()
    }

    fun handleInserts() {
        insertBtnCiclo.setOnClickListener {
            try {
                dbHelper.insertData(idNumero.text.toString(),idFechaI.text.toString(),
                    idFechaF.text.toString(),idANNO.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleUpdates() {
        updateBtnCiclo.setOnClickListener {
            try {
                val isUpdate = dbHelper.updateData(idCiclo.text.toString(),
                    idNumero.text.toString(),
                    idFechaI.text.toString(),
                    idFechaF.text.toString(),
                    idANNO.text.toString()
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
        deleteBtnCiclo.setOnClickListener {
            try {
                dbHelper.deleteData(idCiclo.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleViewing() {
        viewBtnCiclo.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.allData
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }

                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n")
                    buffer.append("NUMERO :" + res.getString(1) + "\n")
                    buffer.append("FECHAINICIO :" + res.getString(2) + "\n")
                    buffer.append("FECHAFINAL :" + res.getString(3) + "\n")
                    buffer.append("ANNO :" + res.getString(4) + "\n\n")
                }
                showDialog("Data Listing", buffer.toString())
            }
        )
    }

    fun handleSearch()  {
        btnSearchCiclo.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.searchData(idCiclo.text.toString())
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }
                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n")
                    buffer.append("NUMERO :" + res.getString(1) + "\n")
                    buffer.append("FECHAINICIO :" + res.getString(2) + "\n")
                    buffer.append("FECHAFINAL :" + res.getString(3) + "\n")
                    buffer.append("ANNO :" + res.getString(4) + "\n\n")
                }
                showDialog("Dato", buffer.toString())
            }
        )
    }



}