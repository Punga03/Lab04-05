package com.example.mysqliteexample.Models;

public class Admin {
    private String user;
    private String password;
    private String rol;

    Admin(){
        this.user = "";
        this.password = "";
        this.rol="";

    }
    public Admin(String user, String password, String rol){
        this.user = user;
        this.password = password;
        this.rol = rol;

    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

