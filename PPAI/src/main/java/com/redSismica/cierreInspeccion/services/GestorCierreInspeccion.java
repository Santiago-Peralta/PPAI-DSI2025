package com.redSismica.cierreInspeccion.services;

import com.redSismica.cierreInspeccion.entity.OrdenDeInspeccion;
import com.redSismica.cierreInspeccion.entity.Estado;
import com.redSismica.cierreInspeccion.entity.EstacionSismologica;
import com.redSismica.cierreInspeccion.entity.Sismografo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GestorCierreInspeccion {

    // Simulación de una base de datos o repositorio de órdenes
    private List<OrdenDeInspeccion> repositorioOrdenes = new ArrayList<>();

    public GestorCierreInspeccion() {
        // Crear Estados
        Estado estadoRealizada = new Estado("No se que va", "Completamente Realizada");
        Estado estadoSismografo = new Estado("No se que va", "Sismografo"); // Cambiar por supuesto estado sismografo??
        Estado estadoRechazada = new Estado("No se que va", "Completamente Rechazada");
        Estado estadoCerrada = new Estado("No se que va", "Cerrada");

        // Crear Sismografos
        Sismografo sismografo1 = new Sismografo(LocalDate.of(2023, 1, 15), 1, 10, estadoSismografo, null);
        Sismografo sismografo2 = new Sismografo(LocalDate.of(2024, 1, 15), 2, 20, estadoSismografo, null); 

        // Crear Estaciones
        EstacionSismologica estacion1 = new EstacionSismologica(1, "Documento", LocalDateTime.now(), -31, 64, "Estacion Central", 45678, sismografo1);
        EstacionSismologica estacion2 = new EstacionSismologica(2, "Documento", LocalDateTime.now(), -2, 64, "Estacion Oeste", 1239, sismografo2);

        // Añadir órdenes de inspección a la simulación
        // addOrden(new OrdenDeInspeccion(101, LocalDateTime.now().minusDays(5), LocalDateTime.now().minusDays(1),
        //                              null, null, estadoRealizada, estacion1));
        // addOrden(new OrdenDeInspeccion(102, LocalDateTime.now().minusDays(4), LocalDateTime.now().minusHours(12),
        //                              null, null, estadoRealizada, estacion2));
        // addOrden(new OrdenDeInspeccion(103, LocalDateTime.now().minusDays(2), LocalDateTime.now().minusHours(6),
        //                              null, null, estadoRealizada, estacion1));
        // addOrden(new OrdenDeInspeccion(104, LocalDateTime.now().minusDays(1), null, // Esta no está finalizada
        //                              null, null, estadoRechazada, estacion2));
        // addOrden(new OrdenDeInspeccion(105, LocalDateTime.now().minusDays(10), LocalDateTime.now().minusDays(8),
        //                              LocalDateTime.now().minusDays(7), "Cierre automático", estadoCerrada, estacion1));
    }

    private void addOrden(OrdenDeInspeccion orden) {
        repositorioOrdenes.add(orden);
    }

    // Metodo para obtener una orden por su numeroOrden
    public Optional<OrdenDeInspeccion> getOrdenById(Integer numeroOrden) {
        return repositorioOrdenes.stream()
                .filter(o -> o.getNumeroOrden() == numeroOrden)
                .findFirst();
    }

    public List<OrdenDeInspeccion> buscarOrdenesFinalizadas() {
        return repositorioOrdenes.stream()
                .filter(OrdenDeInspeccion::sosCompletamenteRealizada)
                .collect(Collectors.toList());
    }

    public void cerrarOrdenInspeccion(Integer numeroOrden) throws Exception {
        Optional<OrdenDeInspeccion> ordenOpt = repositorioOrdenes.stream()
                .filter(orden -> orden.getNumeroOrden() == numeroOrden)
                .findFirst();

        if (ordenOpt.isPresent()) {
            OrdenDeInspeccion orden = ordenOpt.get();
            if (orden.sosCompletamenteRealizada()) { // Solo cierra si esta finalizada
                // Estado estadoCerrada = estadoRepository.findByNombreEstado("Cerrada");
                // orden.setEstado(estadoCerrada);
                // ordenRepository.save(orden);

                // Para la simulacion, la removemos para que no aparezca mas en "finalizadas"
                repositorioOrdenes.removeIf(o -> o.getNumeroOrden() == numeroOrden);
                System.out.println("Orden de Inspeccion " + numeroOrden + " cerrada (simulado) y removida del listado de finalizadas.");
            } else {
                throw new Exception("La orden " + numeroOrden + " no esta en estado 'Completamente Realizada' y no puede ser cerrada.");
            }
        } else {
            throw new Exception("Orden de Inspeccion con ID " + numeroOrden + " no encontrada.");
        }
    }
}