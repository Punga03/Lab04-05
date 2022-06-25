package com.example.mysqliteexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysqliteexample.Models.Alumno
import com.example.mysqliteexample.Models.AlumnoConNota
import com.example.mysqliteexample.Models.SuperHero
import kotlinx.android.synthetic.main.activity_list_view.*

class listViewEstudiantes : AppCompatActivity() {
    val superheroes = listOf(
        AlumnoConNota("117360079","Aaron Gutierrez",87305787,
            "aaron@gmail.com","02/03/99","Ing.Sistemas","aaron123","alumno",0),
     AlumnoConNota("789789","Yoschua Villegas",89453215,
        "yoschua@gmail.com","04/10/2002","Ing.Sistemas","yoschua123","alumno",0),

     AlumnoConNota("898989","Jesus Sanchez",78985621,
        "jesus@gmail.com","10/12/2001","Ing.Sistemas","jesus123","alumno",0)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        initRecycler()
    }

    fun initRecycler (){
        rvSuperHero.layoutManager=LinearLayoutManager(this)
        val adapter= EstudianteAdapter(superheroes)
        rvSuperHero.adapter=adapter
    }

    override fun onResume() {
        super.onResume()
        updateView()
    }
    fun updateView(){
        rvSuperHero.adapter?.notifyItemRangeChanged(1,3)
    }

}