package com.ceiba.licitacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.licitacion.servicio.ServicioPublicarLicitacion;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorPublicarLicitacion implements ManejadorComando<Long> {

    private final ServicioPublicarLicitacion servicioPublicarLicitacion;

    public ManejadorPublicarLicitacion(ServicioPublicarLicitacion servicioPublicarLicitacion) {
        this.servicioPublicarLicitacion = servicioPublicarLicitacion;
    }

    public void ejecutar(Long id) {
        this.servicioPublicarLicitacion.ejecutar(id);
    }

}
