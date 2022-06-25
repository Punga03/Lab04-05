package com.example.mysqliteexample

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mysqliteexample.Models.Alumno
import com.example.mysqliteexample.Models.SuperHero
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_superhero.view.*


class MenuAdapter(val superhero:List<SuperHero>):RecyclerView.Adapter<MenuAdapter.HeroHolder>(){



    override fun getItemCount(): Int =superhero.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
       holder.render(superhero[position])
    }
    class HeroHolder(val view: View):RecyclerView.ViewHolder(view){
        fun render(superhero: SuperHero){
            //view.tvRealname.text=superhero.realName
            view.tvPublisher.text=superhero.publisher
            //view.tvSuperHeroName.text=superhero.superHeroName
            Picasso.get().load(superhero.image).into(view.ivHero)
            view.setOnClickListener{
                Toast.makeText(view.context,"Seleccionado a ${superhero.superHeroName}",Toast.LENGTH_SHORT).show()
                var intent: Intent? =null
                if(superhero.superHeroName=="MenuAlumno"){
                     intent = Intent(view.context, LoginAlumno::class.java)
                }
                if(superhero.superHeroName=="MenuProfesor"){
                    intent = Intent(view.context, LoginProfesor::class.java)
                }
                if(superhero.superHeroName=="MenuAdministrador"){
                    intent = Intent(view.context, LoginAdmin::class.java)
                }
                if (intent != null) {
                    intent.putExtra("obj",superhero)
                }
                view.context.startActivity(intent)
            }
        }
    }
}