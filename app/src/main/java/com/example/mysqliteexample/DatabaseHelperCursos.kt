package com.example.mysqliteexample

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

/**
 * Let's start by creating our database CRUD helper class
 * based on the SQLiteHelper.
 */
class DatabaseHelperCursos(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    /**
     * Our onCreate() method.
     * Called when the database is created for the first time. This is
     * where the creation of tables and the initial population of the tables
     * should happen.
     */
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_NAME2 (CODIGO INTEGER PRIMARY KEY " +
                "AUTOINCREMENT, NOMBRE TEXT,CREDITOS TEXT, HORASSEMANALES TEXT )")
    }

    /**
     * Let's create Our onUpgrade method
     * Called when the database needs to be upgraded. The implementation should
     * use this method to drop tables, add tables, or do anything else it needs
     * to upgrade to the new schema version.
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2)
        onCreate(db)
    }

    /**
     * Let's create our insertData() method.
     * It Will insert data to SQLIte database.
     */
    fun insertData(nombre: String, creditos: String, horas: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
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