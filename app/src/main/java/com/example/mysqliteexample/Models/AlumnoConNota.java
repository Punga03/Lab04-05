package com.example.mysqliteexample.Models;

public class AlumnoConNota extends Alumno{
private int nota;

    public AlumnoConNota(String cedula, String nombre, int telefono, String email, String fechaNacimiento, String carrera, String clave, String rol, int nota) {
        super(cedula, nombre, telefono, email, fechaNacimiento, carrera, clave, rol);
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "AlumnoConNota{" +
                "nota=" + nota +
                '}';
    }
}
