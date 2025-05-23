package com.redSismica.cierreInspeccion.controller;

import com.redSismica.cierreInspeccion.boundary.InterfazCierreInspeccion;
import com.redSismica.cierreInspeccion.boundary.InterfazNotificacionMail;
import com.redSismica.cierreInspeccion.boundary.PantallaCCRS;
import com.redSismica.cierreInspeccion.entity.Usuario;
import com.redSismica.cierreInspeccion.entity.Estado;
import java.time.LocalDateTime;
import com.redSismica.cierreInspeccion.entity.Sesion;
import java.util.List;
import java.util.ArrayList;
import com.redSismica.cierreInspeccion.entity.OrdenDeInspeccion;
import com.redSismica.cierreInspeccion.entity.MotivoTipo;
import java.util.Comparator;



public class GestorCierreInspeccion {
    private Empleado empleadoLogueado;
    private LocalDateTime fechaHoraActual;
    private String mails;
    private String observacionCierre;
    private Sesion sesion;
    private InterfazCierreInspeccion pantallaCierreInspeccion;
    private InterfazNotificacionMail pantallaMail;
    private PantallaCCRS pantallaCCRS;
    private Usuario usuarioLogueado;
    private List<String> listOrdenesInspeccion;
    private Estado estadoCompletamenteRealizado;
    private OrdenDeInspeccion ordenInspeccionSeleccionada;
    private String observacionOrdenCierre;
    private List<MotivoTipo> listSeleccionMotivo;
    private List<String> listComentarioParaMotivo;
    private Estado estadoCerrado;
    private Estado estadoFueraDeServicio;
    private List<MotivoTipo> listMotivoTipo;
    private List<String> listMailsResponsables;

    public GestorCierreInspeccion(
            Empleado empleadoLogueado,
            LocalDateTime fechaHoraActual,
            String mails,
            String observacionCierre,
            Sesion sesion,
            InterfazCierreInspeccion pantallaCierreInspeccion,
            InterfazNotificacionMail pantallaMail,
            PantallaCCRS pantallaCCRS,
            Usuario usuarioLogueado,
            List<String> listOrdenesInspeccion,
            Estado estadoCompletamenteRealizado,
            OrdenDeInspeccion ordenInspeccionSeleccionada,
            String observacionOrdenCierre,
            List<MotivoTipo> listSeleccionMotivo,
            List<String> listComentarioParaMotivo,
            Estado estadoCerrado,
            Estado estadoFueraDeServicio,
            List<MotivoTipo> listMotivoTipo,
            List<String> listMailsResponsables
    ) {
        this.empleadoLogueado = empleadoLogueado;
        this.fechaHoraActual = fechaHoraActual;
        this.mails = mails;
        this.observacionCierre = observacionCierre;
        this.sesion = sesion;
        this.pantallaCierreInspeccion = pantallaCierreInspeccion;
        this.pantallaMail = pantallaMail;
        this.pantallaCCRS = pantallaCCRS;
        this.usuarioLogueado = usuarioLogueado;
        this.listOrdenesInspeccion = listOrdenesInspeccion;
        this.estadoCompletamenteRealizado = estadoCompletamenteRealizado;
        this.ordenInspeccionSeleccionada = ordenInspeccionSeleccionada;
        this.observacionOrdenCierre = observacionOrdenCierre;
        this.listSeleccionMotivo = listSeleccionMotivo;
        this.listComentarioParaMotivo = listComentarioParaMotivo;
        this.estadoCerrado = estadoCerrado;
        this.estadoFueraDeServicio = estadoFueraDeServicio;
        this.listMotivoTipo = listMotivoTipo;
        this.listMailsResponsables = listMailsResponsables;
    }

    // Getters y Setters
    public Empleado getEmpleadoLogueado() {
    return empleadoLogueado;
}

public void setEmpleadoLogueado(Empleado empleadoLogueado) {
    this.empleadoLogueado = empleadoLogueado;
}

    public LocalDateTime getFechaHoraActual() {
        return fechaHoraActual;
    }

    public void setFechaHoraActual(LocalDateTime fechaHoraActual) {
        this.fechaHoraActual = fechaHoraActual;
    }

    public String getMails() {
        return mails;
    }

    public void setMails(String mails) {
        this.mails = mails;
    }

    public String getObservacionCierre() {
        return observacionCierre;
    }

    public void setObservacionCierre(String observacionCierre) {
        this.observacionCierre = observacionCierre;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public InterfazCierreInspeccion getPantallaCierreInspeccion() {
        return pantallaCierreInspeccion;
    }

    public void setPantallaCierreInspeccion(InterfazCierreInspeccion pantallaCierreInspeccion) {
        this.pantallaCierreInspeccion = pantallaCierreInspeccion;
    }

    public InterfazNotificacionMail getPantallaMail() {
        return pantallaMail;
    }

    public void setPantallaMail(InterfazNotificacionMail pantallaMail) {
        this.pantallaMail = pantallaMail;
    }

    public PantallaCCRS getPantallaCCRS() {
        return pantallaCCRS;
    }

    public void setPantallaCCRS(PantallaCCRS pantallaCCRS) {
        this.pantallaCCRS = pantallaCCRS;
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public List<String> getListOrdenesInspeccion() {
        return listOrdenesInspeccion;
    }

    public void setListOrdenesInspeccion(List<String> listOrdenesInspeccion) {
        this.listOrdenesInspeccion = listOrdenesInspeccion;
    }

    public Estado getEstadoCompletamenteRealizado() {
        return estadoCompletamenteRealizado;
    }

    public void setEstadoCompletamenteRealizado(Estado estadoCompletamenteRealizado) {
        this.estadoCompletamenteRealizado = estadoCompletamenteRealizado;
    }

    public OrdenDeInspeccion getOrdenInspeccionSeleccionada() {
        return ordenInspeccionSeleccionada;
    }

    public void setOrdenInspeccionSeleccionada(OrdenDeInspeccion ordenInspeccionSeleccionada) {
        this.ordenInspeccionSeleccionada = ordenInspeccionSeleccionada;
    }

    public String getObservacionOrdenCierre() {
        return observacionOrdenCierre;
    }

    public void setObservacionOrdenCierre(String observacionOrdenCierre) {
        this.observacionOrdenCierre = observacionOrdenCierre;
    }

    public List<MotivoTipo> getListSeleccionMotivo() {
        return listSeleccionMotivo;
    }

    public void setListSeleccionMotivo(List<MotivoTipo> listSeleccionMotivo) {
        this.listSeleccionMotivo = listSeleccionMotivo;
    }

    public List<String> getListComentarioParaMotivo() {
        return listComentarioParaMotivo;
    }

    public void setListComentarioParaMotivo(List<String> listComentarioParaMotivo) {
        this.listComentarioParaMotivo = listComentarioParaMotivo;
    }

    public Estado getEstadoCerrado() {
        return estadoCerrado;
    }

    public void setEstadoCerrado(Estado estadoCerrado) {
        this.estadoCerrado = estadoCerrado;
    }

    public Estado getEstadoFueraDeServicio() {
        return estadoFueraDeServicio;
    }

    public void setEstadoFueraDeServicio(Estado estadoFueraDeServicio) {
        this.estadoFueraDeServicio = estadoFueraDeServicio;
    }

    public List<MotivoTipo> getListMotivoTipo() {
        return listMotivoTipo;
    }

    public void setListMotivoTipo(List<MotivoTipo> listMotivoTipo) {
        this.listMotivoTipo = listMotivoTipo;
    }

    public List<String> getListMailsResponsables() {
        return listMailsResponsables;
    }

    public void setListMailsResponsables(List<String> listMailsResponsables) {
        this.listMailsResponsables = listMailsResponsables;
    }

    public Empleado buscarRILogueado() {
        this.empleadoLogueado = sesion.obtenerRILogueado();
        return empleadoLogueado;
    }

//    public void buscarOIDeRI(Empleado empleadoLogueado, List<OrdenDeInspeccion> listaDeTodasLasOrdenes) {
//        for (int i = 0; i < listaDeTodasLasOrdenes.length(); i++) {
//            boolean esDeEmpleado esCompletamenteRealizado;
//            esDeEmpleado = listaDeTodasLasOrdenes[i].sosDeEmpleado(empleadoLogueado);
//            esCompletamenteRealizado = listaDeTodasLasOrdenes[i].sosCompletamenteRealizado();
//            if (esDeEmpleado && estadoCompletamenteRealizado) {
//                listOrdenesInspeccion.add(listaDeTodasLasOrdenes[i].obtenerDatosOI());
//            }
//        }
//    }

//    public List<String> buscarOIDeRI(Empleado empleadoLogueado, List<OrdenDeInspeccion> listaDeTodasLasOrdenes) {
//        List<OrdenDeInspeccion> ordenesFiltradas = new ArrayList<>();
//
//        // Filtrar las órdenes que son del empleado y están completamente realizadas
//        for (OrdenDeInspeccion orden : listaDeTodasLasOrdenes) {
//            if (orden.sosDeEmpleado(empleadoLogueado) && orden.sosCompletamenteRealizado()) {
//                ordenesFiltradas.add(orden);
//            }
//        }
//
//        // Ordenar por fecha de finalización
//        ordenesFiltradas.sort(Comparator.comparing(OrdenDeInspeccion::getFechaHoraFinalizacion));
//
//        // Armar la lista final con los datos de cada orden
//        List<String> listOrdenesInspeccion = new ArrayList<>();
//        for (OrdenDeInspeccion orden : ordenesFiltradas) {
//            listOrdenesInspeccion.add(orden.obtenerDatosOI());
//        }
//
//        return listOrdenesInspeccion;
//    }


    public List<String> buscarOIDeRI(Empleado empleadoLogueado, List<OrdenDeInspeccion> listaDeTodasLasOrdenes) {
        List<OrdenDeInspeccion> ordenesFiltradas = new ArrayList<>();

        for (OrdenDeInspeccion orden : listaDeTodasLasOrdenes) {
            if (orden.sosDeEmpleado(empleadoLogueado) && orden.sosCompletamenteRealizado()) {
                ordenesFiltradas.add(orden);
            }
        }

        List<OrdenDeInspeccion> ordenadas = ordenarPorFechaDeFin(ordenesFiltradas);

        List<String> listOrdenesInspeccion = new ArrayList<>();
        for (OrdenDeInspeccion orden : ordenadas) {
            listOrdenesInspeccion.add(orden.obtenerDatosOI());
        }

        return listOrdenesInspeccion;
    }

    public List<OrdenDeInspeccion> ordenarPorFechaDeFin(List<OrdenDeInspeccion> lista) {
        lista.sort(Comparator.comparing(OrdenDeInspeccion::getFechaHoraFinalizacion));
        return lista;
    }


}