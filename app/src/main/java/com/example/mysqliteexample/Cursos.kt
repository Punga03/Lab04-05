package com.example.mysqliteexample

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cursos.*
import kotlinx.android.synthetic.main.activity_main.btnSearch
import kotlinx.android.synthetic.main.activity_main.deleteBtn
import kotlinx.android.synthetic.main.activity_main.insertBtn
import kotlinx.android.synthetic.main.activity_main.updateBtn
import kotlinx.android.synthetic.main.activity_main.viewBtn

class Cursos : AppCompatActivity() {

    internal var dbHelper = DatabaseHelperCursos(this)

    fun showToast(text: String){
        Toast.makeText(this@Cursos, text, Toast.LENGTH_LONG).show()
    }

    fun showDialog(title : String,Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    fun clearEditTexts(){

        codigo.setText("")
        nombre.setText("")
        creditosTxt.setText("")
        idHoras.setText("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cursos)

        handleInserts()
        handleUpdates()
        handleDeletes()
        handleViewing()
        handleSearch()

    }

    fun handleInserts() {
        insertBtn.setOnClickListener {
            try {
                dbHelper.insertData(nombre.text.toString(),creditosTxt.text.toString(),idHoras.text.toString()
                  )
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleUpdates() {
        updateBtn.setOnClickListener {
            try {
                val isUpdate = dbHelper.updateData(codigo.text.toString(),
                    nombre.text.toString(),
                    creditosTxt.text.toString(),
                    idHoras.text.toString())
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
        deleteBtn.setOnClickListener {
            try {
                dbHelper.deleteData(codigo.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleViewing() {
        viewBtn.setOnClickListener(
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
                    buffer.append("CREDITOS :" + res.getString(2) + "\n")
                    buffer.append("HORASSEMANALES :" + res.getString(3) + "\n")
                }
                showDialog("Data Listing", buffer.toString())
            }
        )
    }

    fun handleSearch()  {
        btnSearch.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.searchData(codigo.text.toString())
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }
                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("CODIGO :" + res.getString(0) + "\n")
                    buffer.append("NOMBRE :" + res.getString(1) + "\n")
                    buffer.append("CREDITOS :" + res.getString(2) + "\n")
                    buffer.append("HORASSEMANALES :" + res.getString(3) + "\n")
                }
                showDialog("Dato", buffer.toString())
            }
        )
    }
}