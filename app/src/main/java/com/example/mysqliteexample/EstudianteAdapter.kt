package com.example.mysqliteexample

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mysqliteexample.Models.AlumnoConNota
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.activity_list_view.view.*
import kotlinx.android.synthetic.main.item_est_calificado.view.*
import kotlinx.android.synthetic.main.item_superhero.view.*


class EstudianteAdapter(val superhero:List<AlumnoConNota>):RecyclerView.Adapter<EstudianteAdapter.HeroHolder>(){



    override fun getItemCount(): Int =superhero.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_est_calificado,parent,false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
       holder.render(superhero[position])
    }
    class HeroHolder(val view: View):RecyclerView.ViewHolder(view){
        fun render(alumno: AlumnoConNota){
            view.tvCarrera.text=alumno.carrera
            view.tvNombreEst.text=alumno.nombre
            view.tvCedula.text=alumno.cedula
            view.tvNota.text="Nota Obtenida: "+alumno.nota.toString()
            Picasso.get().load("https://us.123rf.com/450wm/hvostik/hvostik1607/hvostik160700078/61014335-estudiante-graduado-avatar-estudiante-icono-del-estudiante-estilo-de-dise%C3%B1o-plano-graduaci%C3%B3n-de-educ.jpg").into(view.ivEstudiante)
            view.setOnClickListener{
                Toast.makeText(view.context,"Seleccionado a ${alumno.nombre}",Toast.LENGTH_LONG).show()

                //Redirigir al formulario para calificar

                var intent = Intent(view.context, CalificarActivity::class.java)
                    intent.putExtra("obj",alumno)

                intent = Intent(view.context, CalificarActivity::class.java)
                view.context.startActivity(intent)
            }
        }

    }
}