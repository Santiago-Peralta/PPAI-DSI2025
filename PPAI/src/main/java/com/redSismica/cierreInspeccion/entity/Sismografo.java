package com.redSismica.cierreInspeccion.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Sismografo {
    private LocalDate fechaAdquisicion;
    private int identificadorSismografo;
    private int nroSerie;
    private Estado estadoActual;
    private List<CambioDeEstado> cambiosDeEstado = new ArrayList<>();

    public Sismografo(LocalDate fechaAdquisicion, int identificadorSismografo,int nroSerie,Estado estadoActual,CambioDeEstado cambiosDeEstado) {
        this.fechaAdquisicion = fechaAdquisicion;
        this.identificadorSismografo = identificadorSismografo;
        this.nroSerie = nroSerie;
        this.estadoActual = estadoActual;
        this.cambiosDeEstado = cambiosDeEstado;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public int getIdentificadorSismografo() {
        return identificadorSismografo;
    }

    public void setIdentificadorSismografo(int identificadorSismografo) {
        this.identificadorSismografo = identificadorSismografo;
    }

    public int getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(int nroSerie) {
        this.nroSerie = nroSerie;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    public CambioDeEstado getCambiosDeEstado() {
        return cambiosDeEstado;
    }

    public void setCambiosDeEstado(CambioDeEstado cambiosDeEstado) {
        this.cambiosDeEstado = cambiosDeEstado;
    }

    public void crearCambioEstado(LocalDateTime fechaHoraFin, LocalDateTime fechaHoraInicio, Estado estado, MotivoFueraServicio motivoFueraServicio, Empleado responsableInspeccion) {
        CambioDeEstado nuevoCambioDeEstado = new CambioDeEstado(fechaHoraFin, null, estado, motivoFueraServicio, responsableInspeccion);
        this.cambiosDeEstado = nuevoCambioDeEstado;
        this.estadoActual = estado;
    }

    public void cerrarServicio(List<MotivoFueraServicio> motivos, Empleado responsableInspeccion, Estado nuevoEstado) {
        LocalDateTime ahora = LocalDateTime.now();
        
        if (!cambiosDeEstado.isEmpty() && cambiosDeEstado.get(cambiosDeEstado.size()-1).sosActual()) {
            cambiosDeEstado.get(cambiosDeEstado.size()-1).setFechaHoraFin(ahora);
        }
        
        CambioDeEstado nuevoCambio = new CambioDeEstado(null, ahora, nuevoEstado, motivos, responsableInspeccion);
        cambiosDeEstado.add(nuevoCambio);
        this.estadoActual = nuevoEstado;
    }

}