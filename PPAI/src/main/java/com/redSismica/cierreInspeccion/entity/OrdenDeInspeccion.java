package com.redSismica.cierreInspeccion.entity;

import java.time.LocalDateTime;

public class OrdenDeInspeccion {
    private int numeroOrden;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFinalizacion;
    private LocalDateTime fechaHoraCierre;
    private String observacionCierre;
    private Estado estado;
    private EstacionSismologica estacionSismologica;
    private Empleado empleado;

    public OrdenDeInspeccion(int numeroOrden, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinalizacion,
                             LocalDateTime fechaHoraCierre, String observacionCierre, Estado estado,
                             EstacionSismologica estacionSismologica, Empleado empleado) {
        this.numeroOrden = numeroOrden;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
        this.fechaHoraCierre = fechaHoraCierre;
        this.observacionCierre = observacionCierre;
        this.estado = estado;
        this.estacionSismologica = estacionSismologica;
        this.empleado = empleado;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFinalizacion() {
        return fechaHoraFinalizacion;
    }

    public void setFechaHoraFinalizacion(LocalDateTime fechaHoraFinalizacion) {
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
    }

    public LocalDateTime getFechaHoraCierre() {
        return fechaHoraCierre;
    }

    public void setFechaHoraCierre(LocalDateTime fechaHoraCierre) {
        this.fechaHoraCierre = fechaHoraCierre;
    }

    public String getObservacionCierre() {
        return observacionCierre;
    }

    public void setObservacionCierre(String observacionCierre) {
        this.observacionCierre = observacionCierre;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public EstacionSismologica getEstacionSismologica() {
        return estacionSismologica;
    }

    public void setEstacionSismologica(EstacionSismologica estacionSismologica) {
        this.estacionSismologica = estacionSismologica;
    }


    // Metodos unicos
    public boolean sosCompletamenteRealizado() {
        return estado != null && estado.sosCompletamenteRealizado();
    }

    public String obtenerDatosOI() {
        int numero = this.getNumeroOrden();
        String fechaFinal = this.getFechaHoraFinalizacion().toString();
        String nombreEstacion = this.getEstacionSismologica().getNombre();
        int idSismografo = this.getIdentificadorSismografo();

        return String.format("Orden: %d | Finaliza: %s | Estación: %s | Sismógrafo: %d",
                            numero, fechaFinal, nombreEstacion, idSismografo);
    }   

    public int getIdentificadorSismografo() {
        return estacionSismologica.getIdentificadorSismografo();
    }

    // Metodos unicos

    public boolean sosDeEmpleado(Empleado empleadoX) {
        return empleado.equals(empleadoX);
    }


    public void cerrar(Estado estadoCerrado) {
        setEstado(estadoCerrado);
    }

    public void actualizarSismografo(List<MotivoFueraServicio> motivos, List<String> comentarios, Estado estado, Empleado responsableInspeccion, LocalDateTime ahora) {
        this.estacionSismologica.cerrarServicio(motivos, comentarios, estado, responsableInspeccion, ahora);
    }

    // Completo
}
