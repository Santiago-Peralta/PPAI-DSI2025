package control;

import boundary.InterfazCierreInspeccion;
import boundary.InterfazNotificacionMail;
import boundary.PantallaCCRS;
import entity.Usuario;
import entity.Estado;
import java.time.LocalDateTime;
import entity.Sesion;
import entity.Empleado;
import java.util.List;
import java.util.ArrayList;
import entity.OrdenDeInspeccion;
import entity.MotivoTipo;
import java.util.Comparator;

public class GestorCierreInspeccion {
    private Empleado empleadoLogueado;
    private LocalDateTime fechaHoraActual;
    private List<String> mails = new ArrayList<>();
    private String observacionCierre;
    private Sesion sesion;
    private InterfazCierreInspeccion pantallaCierreInspeccion;
    private InterfazNotificacionMail pantallaMail;
    private PantallaCCRS pantallaCCRS;
    private Usuario usuarioLogueado;
    private List<String> listOrdenesInspeccion = new ArrayList<>();
    private Estado estadoCompletamenteRealizado;
    private OrdenDeInspeccion ordenInspeccionSeleccionada;
    private String observacionOrdenCierre ;
    private List<MotivoTipo> listSeleccionMotivo = new ArrayList<>();
    private List<String> listComentarioParaMotivo = new ArrayList<>();
    private Estado estadoCerrado;
    private Estado estadoFueraDeServicio;
    private List<MotivoTipo> listMotivoTipo = new ArrayList<>();
    private List<String> listMailsResponsables = new ArrayList<>();
    private List<OrdenDeInspeccion> listaDeTodasLasOrdenes = new ArrayList<>();
    private List<Estado> listaTodosLosEstados = new ArrayList<>();
    private List<MotivoTipo> listaTodosLosMotivos = new ArrayList<>();
    private List<Empleado> listaDeEmpleados = new ArrayList<>();

    // Constructor con añadidos
    public GestorCierreInspeccion(
            Empleado empleadoLogueado,
            LocalDateTime fechaHoraActual,
            String observacionCierre,
            Sesion sesion,
            InterfazCierreInspeccion pantallaCierreInspeccion,
            InterfazNotificacionMail pantallaMail,
            PantallaCCRS pantallaCCRS,
            Usuario usuarioLogueado
    ) {
        this.empleadoLogueado = empleadoLogueado;
        this.fechaHoraActual = fechaHoraActual;
        this.observacionCierre = observacionCierre;
        this.sesion = sesion;
        this.pantallaCierreInspeccion = pantallaCierreInspeccion;
        this.pantallaMail = pantallaMail;
        this.pantallaCCRS = pantallaCCRS;
        this.usuarioLogueado = usuarioLogueado;
    }

    // Setters para nuevas listas
    public void setListaDeTodasLasOrdenes(List<OrdenDeInspeccion> listaDeTodasLasOrdenes) {
        this.listaDeTodasLasOrdenes = listaDeTodasLasOrdenes;
    }

    public void setListaTodosLosEstados(List<Estado> listaTodosLosEstados) {
        this.listaTodosLosEstados = listaTodosLosEstados;
    }

    public void setListaTodosLosMotivos(List<MotivoTipo> listaTodosLosMotivos) {
        this.listaTodosLosMotivos = listaTodosLosMotivos;
    }

    public void setListaDeEmpleados(List<Empleado> listaDeEmpleados) {
        this.listaDeEmpleados = listaDeEmpleados;
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

    public List <String> getMails() {
        return mails;
    }

    public void setMails(List <String> mails) {
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

    public void buscarRILogueado() {
        setEmpleadoLogueado(sesion.obtenerRILogueado());
    }

    
    // Métodos con referencias modificadas
    public void buscarOIDeRI() {
        List<OrdenDeInspeccion> ordenesFiltradas = new ArrayList<>();

        for (OrdenDeInspeccion orden : this.listaDeTodasLasOrdenes) {
            if (orden.sosDeEmpleado(this.empleadoLogueado) && orden.sosCompletamenteRealizado()) {
                ordenesFiltradas.add(orden);
            }
        }

        List<OrdenDeInspeccion> ordenadas = ordenarPorFechaDeFin(ordenesFiltradas);

        List<String> listOrdenesInspeccion = new ArrayList<>();
        for (OrdenDeInspeccion orden : ordenadas) {
            listOrdenesInspeccion.add(orden.obtenerDatosOI());
        }
        
        this.pantallaCierreInspeccion.solicitarSeleccionOI(listOrdenesInspeccion);
        setListOrdenesInspeccion(listOrdenesInspeccion);
    }

    public List<OrdenDeInspeccion> ordenarPorFechaDeFin(List<OrdenDeInspeccion> lista) {
        lista.sort(Comparator.comparing(OrdenDeInspeccion::getFechaHoraFinalizacion));
        return lista;
    }
    
    
    public void tomarSeleccionOI(String seleccion, List <OrdenDeInspeccion> listaDeTodasLasOrdenes) {
        for (int i = 0; i < this.listOrdenesInspeccion.size();i ++){
            if (this.listOrdenesInspeccion.get(i).equals(seleccion)){
                this.setOrdenInspeccionSeleccionada(listaDeTodasLasOrdenes.get(i));
                break;
            }
        }
    }

    public void pedirObservacionOrdenCierre() {
        this.pantallaCierreInspeccion.pedirObservacionOrdenCierre();
    }

    public void tomarObservacionOrdenCierre(String observacion) {
        this.observacionOrdenCierre = observacion;
    }

    public void habilitarActualizarSismografo(){
        List<String> listaAuxiliar = new ArrayList<>();
        for (MotivoTipo motivo : this.listaTodosLosMotivos) {
                listaAuxiliar.add(motivo.getDescripcion());
            }
        setListMotivoTipo(this.listaTodosLosMotivos);
        this.pantallaCierreInspeccion.solicitarSeleccionMotivo(listaAuxiliar);
    }

    public void tomarSeleccionMotivo(List<String> seleccionados) {
        for (String seleccionado : seleccionados){
            MotivoTipo filtrado;
            filtrado = listMotivoTipo.stream()
                    .filter(motivo -> motivo.getDescripcion().equals(seleccionado))
                    .findFirst()
                    .orElse(null);

            if (filtrado != null) { this.listSeleccionMotivo.add(filtrado);}
    }
        for (String seleccionado : seleccionados){
            this.pantallaCierreInspeccion.solicitarComentario(seleccionado);
        }
    }

    public void tomarComentario(String comentario) {
        this.listComentarioParaMotivo.add(comentario);
    }

    public void obtenerConfirmacionOI(){
        //pantallaCierreInspeccion.solicitarConfirmacionCierre();
    }
    public void tomarConfirmacionOI(boolean confirmacion, List <Estado> listaTodosLosEstados) {
        if (confirmacion) {
            validarDatosMinimos(listaTodosLosEstados);
        } else {
            //pantallaCierreInspeccion.mostrarError("No se ha confirmado el cierre de la OI");
        }
    }


    public void validarDatosMinimos(List<Estado> listaTodosLosEstados) {
    if (this.observacionOrdenCierre.isEmpty() ||
        this.listSeleccionMotivo.isEmpty() ||
        this.listComentarioParaMotivo.isEmpty()) {
        throw new IllegalStateException("Faltan datos para el cierre de la OI");
    } else {
        this.cerrarOI(listaTodosLosEstados);
    }
}

    public void cerrarOI(List <Estado> listaTodosLosEstados){
    this.setFechaHoraActual(LocalDateTime.now());
    for (Estado estado : listaTodosLosEstados) {
        if (estado.sosAmbitoOI() && estado.sosCerrada()) {
            this.setEstadoCerrado(estado);
            break;
        }
    }
    this.ordenInspeccionSeleccionada.setFechaHoraCierre(this.fechaHoraActual);
    this.ordenInspeccionSeleccionada.cerrar(this.estadoCerrado);
    this.actualizarSismografo(listaTodosLosEstados);
    }

    public void actualizarSismografo(List <Estado> listaTodosLosEstados) {
        for (Estado estado : listaTodosLosEstados) {
            if (estado.sosAmbitoSismografo() && estado.sosFueraDeServicio()) {
                this.setEstadoFueraDeServicio(estado);
                break;
            }
        }

       this.ordenInspeccionSeleccionada.actualizarSismografo(this.listSeleccionMotivo, this.listComentarioParaMotivo, this.estadoFueraDeServicio , this.empleadoLogueado, this.fechaHoraActual);
    }

    public void obtenerMailResponsableReparacion(List<Empleado> listaEmpleados) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.sosResponsableReparacion()) {
                this.listMailsResponsables.add(empleado.getMail());
            }
        }
    }

    public void enviarMailCierreInspeccion() {
    //interfazNotificacionMail.enviarNotificaciones(this.listMailsResponsables)
    }

    public void publicarEnMonitores() {
        //pantallaCCRS.publicarEnMonitores();
    }
    
    public void tomarSeleccionOI(String seleccion) {
        for (int i = 0; i < this.listOrdenesInspeccion.size(); i ++) {
            if (this.listOrdenesInspeccion.get(i).equals(seleccion)) {
                this.setOrdenInspeccionSeleccionada(this.listaDeTodasLasOrdenes.get(i));
                break;
            }
        }
    }


    public void tomarConfirmacionOI(boolean confirmacion) {
        if (confirmacion) {
            validarDatosMinimos();
        } else {
            //pantallaCierreInspeccion.mostrarError("No se ha confirmado el cierre de la OI");
        }
    }

    public void validarDatosMinimos() {
        if (this.observacionOrdenCierre.isEmpty() ||
            this.listSeleccionMotivo.isEmpty() ||
            this.listComentarioParaMotivo.isEmpty()) {
            throw new IllegalStateException("Faltan datos para el cierre de la OI");
        } else {
            this.cerrarOI();
        }
    }

    public void cerrarOI() {
        this.setFechaHoraActual(LocalDateTime.now());
        for (Estado estado : this.listaTodosLosEstados) {
            if (estado.sosAmbitoOI() && estado.sosCerrada()) {
                this.setEstadoCerrado(estado);
                break;
            }
        }
        this.ordenInspeccionSeleccionada.setFechaHoraCierre(this.fechaHoraActual);
        this.ordenInspeccionSeleccionada.cerrar(this.estadoCerrado);
        this.actualizarSismografo();
    }

    public void actualizarSismografo() {
        for (Estado estado : this.listaTodosLosEstados) {
            if (estado.sosAmbitoSismografo() && estado.sosFueraDeServicio()) {
                this.setEstadoFueraDeServicio(estado);
                break;
            }
        }

       this.ordenInspeccionSeleccionada.actualizarSismografo(this.listSeleccionMotivo, this.listComentarioParaMotivo, this.estadoFueraDeServicio , this.empleadoLogueado, this.fechaHoraActual);
    }

    public void obtenerMailResponsableReparacion() {
        for (Empleado empleado : this.listaDeEmpleados) {
            if (empleado.sosResponsableReparacion()) {
                this.listMailsResponsables.add(empleado.getMail());
            }
        }
    }
}