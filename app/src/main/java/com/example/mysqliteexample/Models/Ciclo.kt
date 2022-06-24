package com.example.mysqliteexample.Models

import java.io.Serializable

class Ciclo: Serializable {

    var anno:Int =0
    var numero:Int =0
    var fechaFinalizacion:Int =0

    internal constructor(anno:Int,numero:Int,fechaFinalizacion:Int){
        this.anno =anno
        this.numero= numero
        this.fechaFinalizacion=fechaFinalizacion
    }

}