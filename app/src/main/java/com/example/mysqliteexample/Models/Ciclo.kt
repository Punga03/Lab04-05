package com.example.mysqliteexample.Models

import java.io.Serializable

class Ciclo: Serializable {

    var anno:Int =0
    var numero:Int =0
    var fechaInicio:String=""
    var fechaFinalizacion:String=""

    internal constructor(anno:Int,numero:Int,fechaInicio:String, fechaFinalizacion:String){
        this.anno =anno
        this.numero= numero
        this.fechaInicio=fechaInicio
        this.fechaFinalizacion=fechaFinalizacion
    }

}