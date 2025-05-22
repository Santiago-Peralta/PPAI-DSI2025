package com.redSismica.cierreInspeccion.entity;

import java.time.LocalDateTime;

public class Sesion {
    private LocalDateTime fechaHoraFin;
    private LocalDateTime fechaHoraInicio;
    private Usuario usuario;


    public Sesion(LocalDateTime fechaHoraFin, LocalDateTime fechaHoraInicio, Usuario usuario) {
        this.fechaHoraFin = fechaHoraFin;
        this.fechaHoraInicio = fechaHoraInicio;
        this.usuario = usuario;
    }

    // Setters y Getters

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String obtenerRILogueado() {
        if (this.fechaHoraFin == null) {
            return this.usuario.getNombreUsuario();
        } else {
            return null;
        }
    }
}
