package com.example.mysqliteexample

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelperCarrera(context: Context) :
    SQLiteOpenHelper(context, DatabaseHelperCarrera.DATABASE_NAME, null, 1) {


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE ${DatabaseHelperCarrera.TABLE_NAME5} (CODIGO PRIMARY KEY " +
                ", NOMBRE TEXT,TITULO TEXT, ANNO TEXT,CICLO TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseHelperCarrera.TABLE_NAME5)
        onCreate(db)
    }
    fun insertData( nombre: String, titulo: String, fechaf: String, anno:String, ciclo:String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, nombre)
        contentValues.put(COL_3, titulo)
        contentValues.put(COL_4, anno)
        contentValues.put(COL_5, ciclo)
        db.insert(TABLE_NAME5, null, contentValues)
    }

    fun updateData(codigo: String, nombre: String, titulo: String, anno:String, ciclo:String):
            Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, codigo)
        contentValues.put(COL_2, nombre)
        contentValues.put(COL_3, titulo)
        contentValues.put(COL_4, anno)
        contentValues.put(COL_5, ciclo)
        db.update(TABLE_NAME5, contentValues, "CODIGO = ?", arrayOf(codigo))
        return true
    }

    fun deleteData(codigo : String) : Int {
        val db = this.writableDatabase
        return db.delete(DatabaseHelperCarrera.TABLE_NAME5,"CODIGO = ?", arrayOf(codigo))
    }

    val allData : Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM " + TABLE_NAME5, null)
            return res
        }

    fun searchData (codigo: String) : Cursor
    {
        val db = this.writableDatabase
        val querySearch = "SELECT * FROM " + DatabaseHelperCarrera.TABLE_NAME5 + " WHERE CODIGO = '"+codigo+"'"
        val res = db.rawQuery(querySearch, null)
        return res
    }

    companion object {
        val DATABASE_NAME = "stars.db"
        val TABLE_NAME5 = "carrera_table"
        val COL_1 = "CODIGO"
        val COL_2 = "NOMBRE"
        val COL_3 = "TITULO "
        val COL_4 = "ANNO"
        val COL_5 = "CICLO "
    }
}