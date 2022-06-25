package com.example.mysqliteexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysqliteexample.Models.SuperHero
import kotlinx.android.synthetic.main.activity_list_view.*

class listViewPrincipal : AppCompatActivity() {
    val superheroes = listOf(

        SuperHero("MenuAlumno","Menu Alumnos","DcComics","https://img.freepik.com/free-vector/graduate-student-icon-graduation-gown_48369-11319.jpg?w=2000"),
        SuperHero("MenuProfesor","Menu Profesor","DcComics","https://cdn-icons-png.flaticon.com/512/4205/4205906.png"),
        SuperHero("MenuAdministrador","Menu Administrador","DcComics","https://cdn.icon-icons.com/icons2/1859/PNG/512/boss3_117888.png"),

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        initRecycler()
    }
    fun initRecycler (){
        rvSuperHero.layoutManager=LinearLayoutManager(this)
        val adapter= MenuAdapter(superheroes)
        rvSuperHero.adapter=adapter

    }
}