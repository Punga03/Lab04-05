package com.example.mysqliteexample

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //In Kotlin `var` is used to declare a mutable variable. On the other hand
    //`internal` means a variable is visible within a given module.
    internal var dbHelper = DatabaseHelper(this)

    /**
     * Let's create a function to show Toast message
     */
    fun showToast(text: String){
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_LONG).show()
    }

    /**
     * Let's create a function to show an alert dialog with data dialog.
     */
    fun showDialog(title : String,Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    /**
     * Let's create a method to clear our edittexts
     */
    fun clearEditTexts(){
        nameA.setText("")
        telefonoA.setText("")
        emailA.setText("")
        idTxt.setText("")
        fecha.setText("")
        carreraA.setText("")
    }

    /**
     * Let's override our onCreate method.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        handleInserts()
        handleUpdates()
        handleDeletes()
        handleViewing()
        handleSearch()
    }

    /**
     * When our handleInserts button is clicked.
     */
    fun handleInserts() {
        insertBtn.setOnClickListener {
            try {
                dbHelper.insertData(idTxt.text.toString(), nameA.text.toString(),telefonoA.text.toString(),
                    emailA.text.toString(),fecha.text.toString(),carreraA.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    /**
     * When our handleUpdates data button is clicked
     */
    fun handleUpdates() {
        updateBtn.setOnClickListener {
            try {
                val isUpdate = dbHelper.updateData(idTxt.text.toString(),
                    nameA.text.toString(),
                    telefonoA.text.toString(),
                    emailA.text.toString(),
                    fecha.text.toString(),
                    carreraA.text.toString()
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

    /**
     * When our handleDeletes button is clicked
     */
    fun handleDeletes(){
        deleteBtn.setOnClickListener {
            try {
                dbHelper.deleteData(idTxt.text.toString())
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    /**
     * When our View All is clicked
     */
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
                    buffer.append("ID :" + res.getString(0) + "\n")
                    buffer.append("NAME :" + res.getString(1) + "\n")
                    buffer.append("TELEFONO :" + res.getString(2) + "\n")
                    buffer.append("EMAIL :" + res.getString(3) + "\n")
                    buffer.append("FECHANACIMIENTO :" + res.getString(4) + "\n")
                    buffer.append("CARRERA :" + res.getString(5) + "\n\n")
                }
                showDialog("Data Listing", buffer.toString())
            }
        )
    }


    fun handleSearch()  {
        btnSearch.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.searchData(idTxt.text.toString())
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }
                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n")
                    buffer.append("NAME :" + res.getString(1) + "\n")
                    buffer.append("TELEFONO :" + res.getString(2) + "\n")
                    buffer.append("EMAIL :" + res.getString(3) + "\n")
                    buffer.append("FECHANACIMIENTO :" + res.getString(4) + "\n")
                    buffer.append("CARRERA :" + res.getString(5) + "\n")
                }
                showDialog("Dato", buffer.toString())
            }
        )
    }
}