package com.example.mysqliteexample

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DatabaseHelper(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY " +
                ",NAME TEXT,TELEFONO TEXT,EMAIL TEXT, FECHANACIMIENTO TEXT, CARRERA TEXT)")

        db.execSQL("CREATE TABLE ${DatabaseHelperCursos.TABLE_NAME2} (CODIGO INTEGER PRIMARY KEY " +
                "AUTOINCREMENT, NOMBRE TEXT,CREDITOS TEXT,  HORASSEMANALES TEXT)")

        db.execSQL("CREATE TABLE ${DatabaseHelperProfesor.TABLE_NAME3} (CEDULA INTEGER PRIMARY KEY " +"" +
                ", NOMBRE TEXT,TELEFONO TEXT, EMAIL TEXT )")

        db.execSQL("CREATE TABLE ${DatabaseHelperCiclo.TABLE_NAME4} (ID INTEGER PRIMARY KEY " +
                "AUTOINCREMENT, NUMERO TEXT,FECHAINICIO TEXT, FECHAFINAL TEXT,ANNO TEXT )")

        db.execSQL("CREATE TABLE ${DatabaseHelperCarrera.TABLE_NAME5} (CODIGO PRIMARY KEY " +
                ", NOMBRE TEXT,TITULO TEXT, ANNO TEXT,CICLO TEXT )")
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun insertData(id:String, name: String, surname: String, marks: String, fecha:String, carrera:String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, id)
        contentValues.put(COL_2, name)
        contentValues.put(COL_3, surname)
        contentValues.put(COL_4, marks)
        contentValues.put(COL_5, fecha)
        contentValues.put(COL_6, carrera)
        db.insert(TABLE_NAME, null, contentValues)
    }

    /**
     * Let's create  a method to update a row with new field values.
     */
    fun updateData(id: String, name: String, surname: String, marks: String, fecha:String, carrera:String):
            Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, id)
        contentValues.put(COL_2, name)
        contentValues.put(COL_3, surname)
        contentValues.put(COL_4, marks)
        contentValues.put(COL_5, fecha)
        contentValues.put(COL_6, carrera)
        db.update(TABLE_NAME, contentValues, "ID = ?", arrayOf(id))
        return true
    }

    /**
     * Let's create a function to delete a given row based on the id.
     */
    fun deleteData(id : String) : Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME,"ID = ?", arrayOf(id))
    }

    /**
     * The below getter property will return a Cursor containing our dataset.
     */
    val allData : Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
            return res
        }

    fun searchData (id: String) :Cursor
    {
        val db = this.writableDatabase
        val querySearch = "SELECT * FROM " + TABLE_NAME + " WHERE ID = '"+id+"'"
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
        val TABLE_NAME = "star_table"
        val COL_1 = "ID"
        val COL_2 = "NAME"
        val COL_3 = "TELEFONO"
        val COL_4 = "EMAIL"
        val COL_5 = "FECHANACIMIENTO"
        val COL_6 = "CARRERA"
    }

}

//end