package com.ceiba.requerimiento.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.requerimiento.servicio.ServicioEliminarRequerimiento;

import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarRequerimiento implements ManejadorComando<Long> {

    private final ServicioEliminarRequerimiento servicioEliminarRequerimiento;

    public ManejadorEliminarRequerimiento(ServicioEliminarRequerimiento servicioEliminarRequerimiento) {
        this.servicioEliminarRequerimiento = servicioEliminarRequerimiento;
    }

    public void ejecutar(Long idRequerimiento) {
        this.servicioEliminarRequerimiento.ejecutar(idRequerimiento);
    }
}
