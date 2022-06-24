package com.example.mysqliteexample

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profesor.*

class Profesor : AppCompatActivity() {

    internal var dbHelper = DatabaseHelperProfesor(this)

    fun showToast(text: String){
        Toast.makeText(this@Profesor, text, Toast.LENGTH_LONG).show()
    }

    fun showDialog(title : String,Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    fun clearEditTexts(){
        cedulaP.setText("")
        nameP.setText("")
        telefonoP.setText("")
        emailP.setText("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profesor)


        handleInserts()
        handleUpdates()
        handleDeletes()
        handleViewing()
        handleSearch()
    }

    fun handleInserts() {
        insertBtnP.setOnClickListener {
            try {
                dbHelper.insertData(cedulaP.text.toString(), nameP.text.toString(),telefonoP.text.toString(),
                    emailP.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleUpdates() {
        updateBtnP.setOnClickListener {
            try {
                val isUpdate = dbHelper.updateData(cedulaP.text.toString(),
                    nameP.text.toString(),
                    telefonoP.text.toString(),
                    emailP.text.toString()
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
        deleteBtnP.setOnClickListener {
            try {
                dbHelper.deleteData(cedulaP.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleViewing() {
        viewBtnP.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.allData
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }

                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("CEDULA :" + res.getString(0) + "\n")
                    buffer.append("NOMBRE :" + res.getString(1) + "\n")
                    buffer.append("TELEFONO :" + res.getString(2) + "\n")
                    buffer.append("EMAIL :" + res.getString(3) + "\n\n")
                }
                showDialog("Data Listing", buffer.toString())
            }
        )
    }

    fun handleSearch()  {
        btnSearchP.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.searchData(cedulaP.text.toString())
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }
                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("CEDULA :" + res.getString(0) + "\n")
                    buffer.append("NOMBRE :" + res.getString(1) + "\n")
                    buffer.append("TELEFONO :" + res.getString(2) + "\n")
                    buffer.append("EMAIL :" + res.getString(3) + "\n\n")
                }
                showDialog("Dato", buffer.toString())
            }
        )
    }

}