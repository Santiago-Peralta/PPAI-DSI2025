package boundary;

import control.GestorCierreInspeccion;

import java.util.List;


public class InterfazCierreInspeccion {
    GestorCierreInspeccion gestor;
    public InterfazCierreInspeccion() {
    }

    public void setGestor(GestorCierreInspeccion gestor) {
        this.gestor = gestor;
    }

    public void solicitarSeleccionOI( List<String> listaOI){
    }

    public void seleccionarOI(String seleccionada){
        this.gestor.tomarSeleccionOI(seleccionada );
    }

    public void pedirObservacionOrdenCierre(){
    }

    public void ingresarObservacionOrdenCierre(String observacion){
        this.gestor.tomarObservacionOrdenCierre(observacion);
    }

    public void solicitarSeleccionMotivo( List<String> listaMotivos){
    }

    public void tomarSeleccionMotivo(List <String> motivos){
        this.gestor.tomarSeleccionMotivo(motivos);
    }

    public void solicitarComentario(String motivo){
    }

    public void tomarComentario(String comentarioMotivo){
        this.gestor.tomarComentario(comentarioMotivo);
    }


    public void solicitarConfirmacionCierre(){
    }

    public void confirmarCierreOI(){
        this.gestor.tomarConfirmacionOI(true );
    }
}
