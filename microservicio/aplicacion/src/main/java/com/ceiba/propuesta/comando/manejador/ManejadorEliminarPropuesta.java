package com.ceiba.propuesta.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.propuesta.servicio.ServicioEliminarPropuesta;

import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPropuesta implements ManejadorComando<Long> {

    private final ServicioEliminarPropuesta servicioEliminarPropuesta;

    public ManejadorEliminarPropuesta(ServicioEliminarPropuesta servicioEliminarPropuesta) {
        this.servicioEliminarPropuesta = servicioEliminarPropuesta;
    }

    public void ejecutar(Long id) {
        this.servicioEliminarPropuesta.ejecutar(id);
    }
}
