package com.example.mysqliteexample

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelperProfesor(context: Context) :
    SQLiteOpenHelper(context, DatabaseHelper.DATABASE_NAME, null, 1)  {


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE ${DatabaseHelperProfesor.TABLE_NAME3} (CEDULA INTEGER PRIMARY KEY " +", NOMBRE TEXT,TELEFONO TEXT, EMAIL TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseHelperProfesor.TABLE_NAME3)
        onCreate(db)
    }

    fun insertData(cedula:String, nombre: String, telefono: String, email: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DatabaseHelperCursos.COL_1, cedula)
        contentValues.put(DatabaseHelperCursos.COL_2, nombre)
        contentValues.put(DatabaseHelperCursos.COL_3, telefono)
        contentValues.put(DatabaseHelperCursos.COL_4, email)
        db.insert(DatabaseHelperProfesor.TABLE_NAME3, null, contentValues)
    }

    fun updateData(cedula:String, nombre: String, telefono: String, email: String):
            Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DatabaseHelperCursos.COL_1, cedula)
        contentValues.put(DatabaseHelperCursos.COL_2, nombre)
        contentValues.put(DatabaseHelperCursos.COL_3, telefono)
        contentValues.put(DatabaseHelperCursos.COL_4, email)
        db.update(DatabaseHelperProfesor.TABLE_NAME3, contentValues, "CODIGO = ?", arrayOf(cedula))
        return true
    }

    fun deleteData(cedula : String) : Int {
        val db = this.writableDatabase
        return db.delete(DatabaseHelperProfesor.TABLE_NAME3,"CEDULA = ?", arrayOf(cedula))
    }

    val allData : Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM " + DatabaseHelperProfesor.TABLE_NAME3, null)
            return res
        }

    fun searchData (codigo: String) :Cursor
    {
        val db = this.writableDatabase
        val querySearch = "SELECT * FROM " + DatabaseHelperProfesor.TABLE_NAME3 + " WHERE CODIGO = '"+codigo+"'"
        val res = db.rawQuery(querySearch, null)
        return res
    }

    companion object {
        val DATABASE_NAME = "stars.db"
        val TABLE_NAME3 = "profesores_table"
        val COL_1 = "CEDULA"
        val COL_2 = "NOMBRE"
        val COL_3 = "TELEFONO "
        val COL_4 = "EMAIL "
    }
}