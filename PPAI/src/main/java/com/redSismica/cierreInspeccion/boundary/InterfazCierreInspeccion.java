package com.redSismica.cierreInspeccion.boundary;

import com.redSismica.cierreInspeccion.entity.OrdenDeInspeccion;
import com.redSismica.cierreInspeccion.services.GestorCierreInspeccion; // Este import es correcto si tu Gestor está en 'services'

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional; // Necesitamos Optional para cuando busquemos por ID

@RestController
@RequestMapping("/api/cierreInspeccion") // Recomendado para APIs REST para evitar conflictos con rutas de Thymeleaf
public class InterfazCierreInspeccion {

    private final GestorCierreInspeccion gestor;

    // Constructor con inyección de dependencias
    @Autowired
    public InterfazCierreInspeccion(GestorCierreInspeccion gestor) {
        this.gestor = gestor;
    }

    // --- Métodos ajustados para usar la lógica existente en GestorCierreInspeccion ---

    // Obtener lista de órdenes finalizadas
    // Coincide con gestor.buscarOrdenesFinalizadas()
    @GetMapping("/ordenesFinalizadas")
    public List<OrdenDeInspeccion> getOrdenesFinalizadas() {
        return gestor.buscarOrdenesFinalizadas();
    }

    // Para seleccionar una orden (por numeroOrden) y posiblemente devolverla
    // Esto sería para un frontend que envía el numeroOrden y quiere los detalles.
    // Usaremos el método getOrdenById del gestor.
    @GetMapping("/seleccionarOrden/{numeroOrden}") // Usamos PathVariable para el ID en la URL
    public Optional<OrdenDeInspeccion> seleccionarOrdenPorNumero(@PathVariable Integer numeroOrden) {
        return gestor.getOrdenById(numeroOrden);
    }

    // Confirmar cierre de una orden (por numeroOrden)
    // Coincide con gestor.cerrarOrdenInspeccion(Integer numeroOrden)
    // El frontend debería enviar el numeroOrden de la orden a cerrar.
    @PostMapping("/cerrarOrden/{numeroOrden}")
    public String confirmarCerrar(@PathVariable Integer numeroOrden) {
        try {
            gestor.cerrarOrdenInspeccion(numeroOrden);
            return "Orden " + numeroOrden + " cerrada exitosamente.";
        } catch (Exception e) {
            // Manejo de errores más detallado en una API real
            return "Error al cerrar la orden " + numeroOrden + ": " + e.getMessage();
        }
    }

    // --- Métodos que tu GestorCierreInspeccion actual NO tiene ---
    // Si necesitas estas funcionalidades, deberás agregarlas al GestorCierreInspeccion.
    // Los dejo comentados para que entiendas la relación.

    /*
    // Si tu gestor tuviera un método para "obtener todas las órdenes seleccionadas" (aunque la lógica actual es solo una)
    @GetMapping("/ordenesSeleccionadas")
    public List<OrdenDeInspeccion> getOrdenesSeleccionadas() {
        // Necesitarías una lista en el gestor que mantenga "órdenes seleccionadas"
        // return gestor.obtenerOrdenesSeleccionadas(); // Este método no existe en tu Gestor actual
        return null; // O una lista vacía si no tienes esa lógica.
    }

    // Si tu gestor tuviera un método para "cancelar la selección" o "cancelar una operación de cierre en curso"
    @PostMapping("/cancelarCerrar")
    public void cancelarCerrar() {
        // gestor.cancelarCerrar(); // Este método no existe en tu Gestor actual
    }

    // Si tu gestor tuviera un método para devolver la única orden "seleccionada" en ese momento
    @GetMapping("/ordenSeleccionada")
    public OrdenDeInspeccion getOrdenSeleccionada() {
        // return gestor.obtenerOrdenSeleccionada(); // Este método no existe en tu Gestor actual
        return null; // O manejar Optional.empty()
    }
    */
}