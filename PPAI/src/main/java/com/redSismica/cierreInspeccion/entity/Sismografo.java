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
        this.cambiosDeEstado = (cambiosDeEstado != null) ? new ArrayList<>() : cambiosDeEstado.getCambiosDeEstado();
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

    public List<CambioDeEstado> getCambiosDeEstado() {
        return new ArrayList<>(cambiosDeEstado);
    }

    public void setCambiosDeEstado(CambioDeEstado cambiosDeEstado) {
        this.cambiosDeEstado = (cambiosDeEstado != null) ? new ArrayList<>() : cambiosDeEstado.getCambiosDeEstado();
    }

    public void crearCambioEstado(Estado estado, LocalDateTime fechaHoraActual , Empleado responsableInspeccion, List<MotivoTipo> motivosFueraServicio , List <String> comentarios) {
        CambioDeEstado nuevoCambio = new CambioDeEstado(null , fechaHoraActual, estado , null, responsableInspeccion);
        for (int i = 0; i < motivosFueraServicio.size(); i++) {
            nuevoCambio.crearMotivoFueraServicio( comentarios.get(i) ,motivosFueraServicio.get(i))
        }
        this.cambiosDeEstado.add(nuevoCambio);
    }

    public void cerrarServicio(List<MotivoTipo> motivos, List<String> comentarios, Estado nuevoEstado, Empleado responsableInspeccion, LocalDateTime ahora) {
        for (CambioDeEstado cambioEstado : this.cambiosDeEstado){
            if (cambioEstado.sosActual()){
                cambioEstado.setFechaHoraFin(ahora);

            }
        }
        this.setEstadoActual(nuevoEstado);
        this.crearCambioEstado(nuevoEstado, ahora, responsableInspeccion, motivos, comentarios);
    }
}