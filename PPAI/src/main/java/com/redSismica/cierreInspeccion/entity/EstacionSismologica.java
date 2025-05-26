package main.java.com.redSismica.cierreInspeccion.entity;

import java.time.LocalDateTime;

public class EstacionSismologica {
    private int codigoEstacion;
    private String documentoCertificacionAdq;
    private LocalDateTime fechaSolicitudCreacion;
    private int latitud;
    private int longitud;
    private String nombre;
    private int nroCertificacionAdquisicion;

    public EstacionSismologica(int codigoEstacion, String documentoCertificacionAdq, LocalDateTime fechaSolicitudCreacion, int latitud, int longitud, String nombre, int nroCertificacionAdquisicion) {
        this.codigoEstacion = codigoEstacion;
        this.documentoCertificacionAdq = documentoCertificacionAdq;
        this.fechaSolicitudCreacion = fechaSolicitudCreacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
        this.nroCertificacionAdquisicion = nroCertificacionAdquisicion;
    }


    // Setters y Getters
    public int getCodigoEstacion() {
        return codigoEstacion;
    }

    public void setCodigoEstacion(int codigoEstacion) {
        this.codigoEstacion = codigoEstacion;
    }
    
    public String getDocumentoCertificacionAdq() {
        return documentoCertificacionAdq;
    }

    public void setDocumentoCertificacionAdq(String documentoCertificacionAdq) {
        this.documentoCertificacionAdq = documentoCertificacionAdq;
    }
    
    public LocalDateTime getFechaSolicitudCreacion() {
        return fechaSolicitudCreacion;
    }

    public void setFechaSolicitudCreacion(LocalDateTime fechaSolicitudCreacion) {
        this.fechaSolicitudCreacion = fechaSolicitudCreacion;
    }
    
    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroCertificacionAdquisicion() {
        return nroCertificacionAdquisicion;
    }

    public void setNroCertificacionAdquisicion(int nroCertificacionAdquisicion) {
        this.nroCertificacionAdquisicion = nroCertificacionAdquisicion;
    }

    // Faltan metodos (todos). Preguntar por metodo getSismografo() -> para mi falta atributo Sismografo sismografo que hace referencia al numero del sismografo

    public void getIdentificadorSismografo() {

    }
}
