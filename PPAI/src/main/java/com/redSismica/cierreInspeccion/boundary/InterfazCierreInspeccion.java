package main.java.com.redSismica.cierreInspeccion.boundary;

import main.java.com.redSismica.cierreInspeccion.controller.GestorCierreInspeccion;

public class InterfazCierreInspeccion {
    private Button botonCancelarCierre;
    private Button botonConfirmarCierre;
    private JTable grillaOrdenInspeccionFinalizadas; // Asumiendo JTable para una grilla
    private JTable grillaOrdenInspeccionSelec;     // Asumiendo JTable para una grilla
    private Object ordenInspeccionSeleccionada;  // El tipo depende de tu objeto 'OrdenInspeccion'
    private GestorCierreInspeccion gestor;


    public InterfazCierreInspeccion() {
        botonCancelarCierre = new Button("Cancelar Cierre");
        botonConfirmarCierre = new Button("Confirmar Cierre");
        grillaOrdenInspeccionFinalizadas = new JTable();
        grillaOrdenInspeccionSelec = new JTable();
        gestor = new GestorCierreInspeccion();
    }
}
