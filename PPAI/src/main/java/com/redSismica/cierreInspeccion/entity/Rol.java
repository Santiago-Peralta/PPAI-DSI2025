package com.redSismica.cierreInspeccion.entity;

public class Rol {
    private String descripcionRol;
    private String nombre;

    public Rol(String descripcionRol, String nombre) {
        this.descripcionRol = descripcionRol;
        this.nombre = nombre;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    //Metodos unicos
    public boolean sosResponsableReparacion() {
        return "Responsable Reparacion".equalsIgnoreCase(nombre);
    }
    public String getNombreRol() {
        return nombre;
    }
    }

// Completo 
