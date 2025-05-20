package com.example.ejemplo.models;

public class Usuario {

    private String nombre;
    private String apellido;

    private String telefono;
    private String email;
    private String password;

    // Constructor
    public Usuario(String nombre, String apellido , String telefono, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;

        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }

    public String getTelefono() { return telefono; }
    public String getUsername() { return email; }
    public String getPassword() { return password; }
}
