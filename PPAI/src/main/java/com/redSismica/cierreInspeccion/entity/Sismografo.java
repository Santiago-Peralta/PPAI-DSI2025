package main.java.com.redSismica.cierreInspeccion.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Sismografo {
    private LocalDate fechaAdquisicion;
    private int identificadorSismografo;
    private int nroSerie;
    private Estado estadoActual;
    private CambioDeEstado cambiosDeEstado;

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

    // Falta metodo cerrarServicio()
}
