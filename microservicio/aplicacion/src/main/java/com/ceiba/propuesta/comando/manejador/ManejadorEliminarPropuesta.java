package com.ceiba.propuesta.comando.manejador;

import com.ceiba.propuesta.servicio.ServicioEliminarPropuesta;

import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPropuesta {

    private final ServicioEliminarPropuesta servicioEliminarPropuesta;

    public ManejadorEliminarPropuesta(ServicioEliminarPropuesta servicioEliminarPropuesta) {
        this.servicioEliminarPropuesta = servicioEliminarPropuesta;
    }

    public void ejecutar(Long idLicitacion, Long idPropuesta) {
        this.servicioEliminarPropuesta.ejecutar(idLicitacion, idPropuesta);
    }
}
