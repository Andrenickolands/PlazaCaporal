package com.example.ejemplo.models;

public class ProductoModel {

    private String nombre;
    private String descripcion;
    private double precio;
    private String categoria;
    private String imagen;

    public ProductoModel(String nombre, String descripcion, double precio, String categoria,  String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.imagen = imagen;
    }

    public String getNombre(){return nombre;}

    public String getDescripcion(){return descripcion;}

    public Double getPrecio(){return precio;}

    public String getCategoria(){return categoria;}

    public String getImagen(){return imagen;}
}
