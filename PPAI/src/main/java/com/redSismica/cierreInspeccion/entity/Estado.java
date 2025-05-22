package com.redSismica.cierreInspeccion.entity;

public class Estado {
    private String ambito;
    private String nombreEstado;

    // Constructor
    public Estado(String ambito, String nombreEstado) {
        this.ambito = ambito;
        this.nombreEstado = nombreEstado;
    }

    // Getters y Setters
    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public boolean sosCompletamenteRealizada() {
        return "Completamente Realizada".equalsIgnoreCase(nombreEstado);
    }
    
    public boolean sosCompletamenteRechazado() {
        return "Completamente Rechazado".equalsIgnoreCase(nombreEstado);
    }

    public boolean sosCerrada() {
        return "Cerrada".equalsIgnoreCase(nombreEstado);
    }
}
