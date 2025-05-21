package main.java.com.redSismica.cierreInspeccion.entity;

import java.time.LocalDateTime;

public class OrdenDeInspeccion {
    private int numeroOrden;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFinalizacion;
    private LocalDateTime fechaHoraCierre;
    private String observacionCierre;
    private Estado estado;
    private EstacionSismologica estacionSismologica;

    public OrdenDeInspeccion(int numeroOrden, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinalizacion,
                             LocalDateTime fechaHoraCierre, String observacionCierre, Estado estado,
                             EstacionSismologica estacionSismologica) {
        this.numeroOrden = numeroOrden;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
        this.fechaHoraCierre = fechaHoraCierre;
        this.observacionCierre = observacionCierre;
        this.estado = estado;
        this.estacionSismologica = estacionSismologica;
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

    public boolean sosCompletamenteRealizada() {
        return estado != null && estado.sosCompletamenteRealizada();
    }

    public String obtenerDatosOI() {
        int numero = this.getNumeroOrden();
        String fechaFinal = this.getFechaHoraFinalizacion().toString();
        String nombreEstacion = this.getEstacionSismologica().getNombre();
        String idSismografo = this.getEstacionSismologica().getIdentificadorSismografo().getIdentificadorSismografo();

        return String.format("Orden: %d | Finaliza: %s | Estación: %s | Sismógrafo: %s",
                            numero, fechaFinal, nombreEstacion, idSismografo);
    }   
}
