package com.example.mysqliteexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysqliteexample.Models.SuperHero
import kotlinx.android.synthetic.main.activity_list_view.*

class listView : AppCompatActivity() {
    val superheroes = listOf(
        SuperHero("JuanDi","ClarkKent","DcComics","https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"),
        SuperHero("Superman","ClarkKent","DcComics","https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"),
        SuperHero("Superman","ClarkKent","DcComics","https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"),
        SuperHero("Superman","ClarkKent","DcComics","https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg")
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