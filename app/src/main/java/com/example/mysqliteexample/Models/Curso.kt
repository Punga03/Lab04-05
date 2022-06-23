package com.example.mysqliteexample.Models

import java.io.Serializable

class Curso: Serializable {

    var codigo:Int=0
    var nombre:String=""
    var creditos:Int=0
    var horasSemanales:Int=0

    internal constructor(codigo:Int,nombre:String,creditos:Int,horasSemanales:Int){

        this.codigo=codigo
        this.nombre=nombre
        this.creditos=creditos
        this.horasSemanales=horasSemanales
    }
}