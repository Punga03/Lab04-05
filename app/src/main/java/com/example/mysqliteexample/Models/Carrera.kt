package com.example.mysqliteexample.Models

import java.io.Serializable

class Carrera: Serializable {

    var codigo:Int = 0
    var nombreC:String =""
    var titulo:String =""
    var anno:Int = 0
    var ciclo:String =""

    internal constructor(codigo:Int,nombreC:String,titulo:String,anno:Int,ciclo:String){
        this.codigo=codigo
        this.nombreC=nombreC
        this.titulo=titulo
        this.anno=anno
        this.ciclo=ciclo
    }

}