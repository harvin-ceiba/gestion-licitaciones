package com.ceiba.licitacion.comando.manejador;

import com.ceiba.licitacion.servicio.ServicioEliminarLicitacion;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarLicitacion implements ManejadorComando<Long> {

    private final ServicioEliminarLicitacion servicioEliminarLicitacion;

    public ManejadorEliminarLicitacion(ServicioEliminarLicitacion servicioEliminarLicitacion) {
        this.servicioEliminarLicitacion = servicioEliminarLicitacion;
    }

    public void ejecutar(Long idLicitacion) {
        this.servicioEliminarLicitacion.ejecutar(idLicitacion);
    }
}
