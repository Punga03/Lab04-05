package com.example.mysqliteexample.Models

class Alumno: java.io.Serializable {

    var cedula:Int = 0
    var nombre:String = ""
    var telefono:Int = 0
    var email:String = ""
    var fechaNacimiento:String = ""
    var carrera:String = ""

    internal constructor(cedula:Int,nombre:String, telefono:Int,email:String,fechaNacimiento:String,carrera:String){
        this.cedula=cedula
        this.nombre=nombre
        this.telefono=telefono
        this.email=email
        this.fechaNacimiento=fechaNacimiento
        this.carrera=carrera
    }
}