package com.example.mysqliteexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysqliteexample.Models.SuperHero
import kotlinx.android.synthetic.main.activity_list_view.*

class listView : AppCompatActivity() {
    val superheroes = listOf(
        SuperHero("Profesor","Mantenimiento Profesores",  "DcComics","https://i.ibb.co/VCNKhvf/585e4bc4cb11b227491c3395.png"),
        SuperHero("Alumno","Mantenimieto Usuarios","DcComics","https://i.ibb.co/BcN0ZD3/Pngtree-character-avatar-of-businessman-with-5339927.png"),
        SuperHero("Carrera","Mantenimiento Carrera","DcComics","https://i.ibb.co/PNw7kmn/teacher-icon-flat-style-vector-20708727.jpg"),
        SuperHero("Ciclo","Mantenimiento Ciclos","DcComics","https://i.ibb.co/5Bd3SHN/teacher-woman-icon-flat-style-vector-13365437.jpg"),
        SuperHero("Grupo","Mantenimiento Grupo","DcComics","https://i.ibb.co/PNw7kmn/teacher-icon-flat-style-vector-20708727.jpg"),
        SuperHero("Curso","Mantenimiento Cursos","DcComics","https://i.ibb.co/5Bd3SHN/teacher-woman-icon-flat-style-vector-13365437.jpg")

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        initRecycler()
    }
    fun initRecycler (){
        rvSuperHero.layoutManager=LinearLayoutManager(this)
        val adapter= HeroAdapter(superheroes)
        rvSuperHero.adapter=adapter

    }
}