package com.example.academia;

public class Modelo {
    private String Nombre;
    private String Descripcion;
    private String Precio;
    private String Horas;
    private String Requisitos;

    private int img;

    public Modelo(){
    }

    public Modelo(String nombre, String descripcion, String precio, String horas, String requisitos) {
        Nombre = nombre;
        Descripcion = descripcion;
        Precio = precio;
        Horas = horas;
        Requisitos = requisitos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getHoras() {
        return Horas;
    }

    public void setHoras(String horas) {
        Horas = horas;
    }

    public String getRequisitos() {
        return Requisitos;
    }

    public void setRequisitos(String requisitos) {
        Requisitos = requisitos;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
