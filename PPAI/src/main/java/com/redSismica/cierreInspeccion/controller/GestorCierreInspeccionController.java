package com.redSismica.cierreInspeccion.controller;

import com.redSismica.cierreInspeccion.entity.OrdenDeInspeccion;
import com.redSismica.cierreInspeccion.services.GestorCierreInspeccion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller // @Controller para devolver vistas
public class GestorCierreInspeccionController {

    private final GestorCierreInspeccion gestorCierreInspeccion;

    // La orden seleccionada actual se mantendrá aquí.
    private OrdenDeInspeccion ordenSeleccionadaActual = null;


    public GestorCierreInspeccionController(GestorCierreInspeccion gestorCierreInspeccion) {
        this.gestorCierreInspeccion = gestorCierreInspeccion;
    }

    @GetMapping("/cierre-inspeccion")
    public String mostrarInterfazCierreInspeccion(Model model) {
        List<OrdenDeInspeccion> ordenesFinalizadas = gestorCierreInspeccion.buscarOrdenesFinalizadas();
        model.addAttribute("grillaOrdenInspeccionFinalizadas", ordenesFinalizadas);

        // La "grillaOrdenInspeccionSelec" y "Orden de Inspección Seleccionada" se basan en la ordenSeleccionadaActual
        model.addAttribute("ordenInspeccionSeleccionada", ordenSeleccionadaActual);
        if (ordenSeleccionadaActual != null) {
            model.addAttribute("grillaOrdenInspeccionSelec", List.of(ordenSeleccionadaActual));
        } else {
            model.addAttribute("grillaOrdenInspeccionSelec", new ArrayList<>());
        }

        return "cierreInspeccion"; // Esto buscará src/main/resources/templates/cierreInspeccion.html
    }

    @PostMapping("/cierre-inspeccion/seleccionar")
    public String seleccionarOrden(@RequestParam("idOrden") Integer idOrden, RedirectAttributes redirectAttributes) {
        // Ahora buscamos por numeroOrden
        Optional<OrdenDeInspeccion> ordenOpt = gestorCierreInspeccion.getOrdenById(idOrden);

        if (ordenOpt.isPresent()) {
            this.ordenSeleccionadaActual = ordenOpt.get();
        } else {
            redirectAttributes.addFlashAttribute("error", "La orden seleccionada no fue encontrada.");
        }
        return "redirect:/cierre-inspeccion"; // Redirige para refrescar la página
    }

    @PostMapping("/cierre-inspeccion/confirmar")
    public String confirmarCierre(RedirectAttributes redirectAttributes) {
        if (ordenSeleccionadaActual == null) {
            redirectAttributes.addFlashAttribute("error", "No hay ninguna orden seleccionada para cerrar.");
            return "redirect:/cierre-inspeccion";
        }

        try {
            gestorCierreInspeccion.cerrarOrdenInspeccion(ordenSeleccionadaActual.getNumeroOrden());
            redirectAttributes.addFlashAttribute("mensaje", "Orden " + ordenSeleccionadaActual.getNumeroOrden() + " cerrada exitosamente.");
            this.ordenSeleccionadaActual = null; // Limpiar la selección después del cierre
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al cerrar la orden: " + e.getMessage());
        }
        return "redirect:/cierre-inspeccion";
    }

    @PostMapping("/cierre-inspeccion/cancelar")
    public String cancelarCierre() {
        this.ordenSeleccionadaActual = null; // Limpiar la selección
        return "redirect:/cierre-inspeccion"; // Redirige para refrescar la página
    }
}