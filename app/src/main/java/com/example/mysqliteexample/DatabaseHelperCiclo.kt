package com.example.mysqliteexample

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelperCiclo(context: Context) :
    SQLiteOpenHelper(context, DatabaseHelperCiclo.DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE ${DatabaseHelperCiclo.TABLE_NAME4} (ID INTEGER PRIMARY KEY " +
                "AUTOINCREMENT, NUMERO TEXT,FECHAINICIO TEXT, FECHAFINAL TEXT,ANNO TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseHelperCiclo.TABLE_NAME4)
        onCreate(db)
    }
    fun insertData(numero: String, fecha: String, fechaf: String, anno:String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, numero)
        contentValues.put(COL_3, fecha)
        contentValues.put(COL_4, fechaf)
        contentValues.put(COL_5, anno)
        db.insert(TABLE_NAME4, null, contentValues)
    }

    fun updateData(id: String, numero: String, fecha: String, fechaf: String, anno:String):
            Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, id)
        contentValues.put(COL_2, numero)
        contentValues.put(COL_3, fecha)
        contentValues.put(COL_4, fechaf)
        contentValues.put(COL_5, anno)
        db.update(TABLE_NAME4, contentValues, "ID = ?", arrayOf(id))
        return true
    }

    fun deleteData(id : String) : Int {
        val db = this.writableDatabase
        return db.delete(DatabaseHelperCiclo.TABLE_NAME4,"ID = ?", arrayOf(id))
    }

    val allData : Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM " + TABLE_NAME4, null)
            return res
        }

    fun searchData (id: String) : Cursor
    {
        val db = this.writableDatabase
        val querySearch = "SELECT * FROM " + DatabaseHelperCiclo.TABLE_NAME4 + " WHERE ID = '"+id+"'"
        val res = db.rawQuery(querySearch, null)
        return res
    }

    companion object {
        val DATABASE_NAME = "stars.db"
        val TABLE_NAME4 = "ciclos_table"
        val COL_1 = "ID"
        val COL_2 = "NUMERO"
        val COL_3 = "FECHAINICIO "
        val COL_4 = "FECHAFINAL "
        val COL_5 = "ANNO "
    }

}