package com.example.mysqliteexample.Models

class Profesor: java.io.Serializable {

    var cedula:Int = 0
    var nombre:String = ""
    var telefono:String = ""
    var email:String = ""

    internal constructor(cedula:Int,nombre:String,telefono:String,email:String){

        this.cedula=cedula
        this.nombre=nombre
        this.telefono=telefono
        this.email=email
    }
}