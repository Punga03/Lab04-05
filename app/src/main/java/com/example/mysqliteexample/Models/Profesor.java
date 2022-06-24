package com.example.mysqliteexample.Models;

public class Profesor {

    private String cedula;
    private String nombre;
    private String telefono;
    private String email;
    private String clave;
    private String rol;

    Profesor(){
        this.cedula ="";
        this.nombre ="";
        this.telefono = "";
        this.email = "";
        this.clave = "";
        this.rol="";
    }

    public Profesor(String cedula, String nombre, String telefono, String email, String clave, String rol) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
