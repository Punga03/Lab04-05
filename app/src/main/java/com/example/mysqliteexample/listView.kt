package com.example.mysqliteexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysqliteexample.Models.SuperHero
import kotlinx.android.synthetic.main.activity_list_view.*

class listView : AppCompatActivity() {
    val superheroes = listOf(
        SuperHero("Profesor","Mantenimiento Profesores",  "DcComics","https://cdn3.iconfinder.com/data/icons/education-and-school-filled-outline-2/64/Education_FilledOutline23-512.png"),
        SuperHero("Alumno","Mantenimieto Usuarios","DcComics","https://cdn.pixabay.com/photo/2020/07/01/12/58/icon-5359553_1280.png"),
        SuperHero("Carrera","Mantenimiento Carreras","DcComics","https://cdn.iconscout.com/icon/free/png-256/graduation-cap-2548200-2130742.png"),
        SuperHero("Ciclo","Mantenimiento Ciclos","DcComics","https://cdn3.iconfinder.com/data/icons/illustricon-tech-ii/512/calendar-512.png"),
        SuperHero("Grupo","Mantenimiento Grupos","DcComics","https://icon-library.com/images/individual-icon-png/individual-icon-png-10.jpg"),
        SuperHero("Curso","Mantenimiento Cursos","DcComics","https://www.pngkit.com/png/detail/139-1392338_free-icons-png-book-icon-png-round.png")

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