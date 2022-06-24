package com.example.mysqliteexample

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DatabaseHelperCursos(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_NAME2 (CODIGO INTEGER PRIMARY KEY " +
                ", NOMBRE TEXT,CREDITOS TEXT, HORASSEMANALES TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2)
        onCreate(db)
    }

    fun insertData(codigo: String, nombre: String, creditos: String, horas: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, codigo)
        contentValues.put(COL_2, nombre)
        contentValues.put(COL_3, creditos)
        contentValues.put(COL_4, horas)
        db.insert(TABLE_NAME2, null, contentValues)
    }

    /**
     * Let's create  a method to update a row with new field values.
     */
    fun updateData(codigo: String, nombre: String, creditos: String, horas: String):
            Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, codigo)
        contentValues.put(COL_2, nombre)
        contentValues.put(COL_3, creditos)
        contentValues.put(COL_4, horas)
        db.update(TABLE_NAME2, contentValues, "CODIGO = ?", arrayOf(codigo))
        return true
    }

    /**
     * Let's create a function to delete a given row based on the id.
     */
    fun deleteData(codigo : String) : Int {
        val db = this.writableDatabase
        return db.delete(DatabaseHelperCursos.TABLE_NAME2,"CODIGO = ?", arrayOf(codigo))
    }


    /**
     * The below getter property will return a Cursor containing our dataset.
     */
    val allData : Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM " + TABLE_NAME2, null)
            return res
        }


    fun searchData (codigo: String) :Cursor
    {
        val db = this.writableDatabase
        val querySearch = "SELECT * FROM " + DatabaseHelperCursos.TABLE_NAME2 + " WHERE CODIGO = '"+codigo+"'"
        val res = db.rawQuery(querySearch, null)
        return res
    }



    /**
     * Let's create a companion object to hold our static fields.
     * A Companion object is an object that is common to all instances of a givenf
     * class.
     */

    companion object {
        val DATABASE_NAME = "stars.db"
        val TABLE_NAME2 = "cursos_table"
        val COL_1 = "CODIGO"
        val COL_2 = "NOMBRE"
        val COL_3 = "CREDITOS "
        val COL_4 = "HORASSEMANALES "
    }

}
//end