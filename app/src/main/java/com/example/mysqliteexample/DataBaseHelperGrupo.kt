package com.example.mysqliteexample

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelperGrupo(context: Context) :
    SQLiteOpenHelper(context, DataBaseHelperGrupo.DATABASE_NAME, null, 1) {


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_NAME6 (NUMEROGRUPO INTEGER PRIMARY KEY " +
                ", CICLO TEXT,CURSO TEXT, HORARIO TEXT, PROFESOR TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME6)
        onCreate(db)
    }

    fun insertData(numeroGrupo: String, ciclo: String, curso: String, horario: String, profesor:String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, numeroGrupo)
        contentValues.put(COL_2, ciclo)
        contentValues.put(COL_3, curso)
        contentValues.put(COL_4, horario)
        contentValues.put(COL_5, profesor)
        db.insert(TABLE_NAME6, null, contentValues)
    }

    /**
     * Let's create  a method to update a row with new field values.
     */
    fun updateData(numeroGrupo: String, ciclo: String, curso: String, horario: String, profesor:String):
            Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, numeroGrupo)
        contentValues.put(COL_2, ciclo)
        contentValues.put(COL_3, curso)
        contentValues.put(COL_4, horario)
        contentValues.put(COL_5, profesor)

        db.update(TABLE_NAME6, contentValues, "NUMEROGRUPO = ?", arrayOf(numeroGrupo))
        return true
    }

    /**
     * Let's create a function to delete a given row based on the id.
     */
    fun deleteData(numeroGrupo : String) : Int {
        val db = this.writableDatabase
        return db.delete(DataBaseHelperGrupo.TABLE_NAME6,"NUMEROGRUPO = ?", arrayOf(numeroGrupo))
    }


    /**
     * The below getter property will return a Cursor containing our dataset.
     */
    val allData : Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM " + TABLE_NAME6, null)
            return res
        }


    fun searchData (numeroGrupo: String) : Cursor
    {
        val db = this.writableDatabase
        val querySearch = "SELECT * FROM " + DataBaseHelperGrupo.TABLE_NAME6 + " WHERE NUMEROGRUPO = '"+numeroGrupo+"'"
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
        val TABLE_NAME6 = "grupos_table"
        val COL_1 = "NUMEROGRUPO"
        val COL_2 = "CICLO"
        val COL_3 = "CURSO "
        val COL_4 = "HORARIO "
        val COL_5 = "PROFESOR "
    }
}