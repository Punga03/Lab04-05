package com.example.mysqliteexample.Models;
import java.io.Serializable;

public class Alumno implements Serializable{

    private String cedula;
    private String nombre;
    private int telefono;
    private String email;
    private String fechaNacimiento;
    private String carrera;
    private String clave;
    private String rol;

    Alumno(){
        this.cedula="";
        this.nombre="";
        this.telefono=0;
        this.email="";
        this.fechaNacimiento="";
        this.carrera="";
        this.clave="";
        this.rol="";
    }

    public Alumno(String cedula, String nombre, int telefono, String email, String fechaNacimiento, String carrera, String clave, String rol) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.carrera = carrera;
        this.clave = clave;
        this.rol = rol;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
