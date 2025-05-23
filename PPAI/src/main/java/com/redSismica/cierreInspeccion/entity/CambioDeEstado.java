package com.redSismica.cierreInspeccion.entity;

import java.time.LocalDateTime;

public class CambioDeEstado {
    private LocalDateTime fechaHoraFin;
    private LocalDateTime fechaHoraInicio;
    private Estado estado;
    private MotivoFueraServicio motivoFueraServicio;
    private Empleado responsableInspeccion;

    public CambioDeEstado(LocalDateTime fechaHoraFin, LocalDateTime fechaHoraInicio, Estado estado, MotivoFueraServicio motivoFueraServicio, Empleado responsableInspeccion) {
        this.fechaHoraFin = fechaHoraFin;
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
        this.motivoFueraServicio = motivoFueraServicio;
        this.responsableInspeccion = responsableInspeccion;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public MotivoFueraServicio getMotivoFueraServicio() {
        return motivoFueraServicio;
    }

    public void setMotivoFueraServicio(MotivoFueraServicio motivoFueraServicio) {
        this.motivoFueraServicio = motivoFueraServicio;
    }
    
    public Empleado getResponsableInspeccion() {
        return responsableInspeccion;
    }

    public void setResponsableInspeccion(Empleado responsableInspeccion) {
        this.responsableInspeccion = responsableInspeccion;
    }


    // Metodos Unicos
    public boolean sosActual() {
        return this.fechaHoraFin == null;
    }
    
    public boolean esEstadoActual() {
        return this.fechaHoraFin == null;
    }

    public void crearMotivoFueraServicio(String comentario, MotivoTipo motivoTipo) {
        this.motivoFueraServicio = new MotivoFueraServicio(comentario, motivoTipo);
    }
    

}

//Completo