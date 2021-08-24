package com.ceiba.propuesta.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.propuesta.servicio.ServicioPublicarPropuesta;

@Component
public class ManejadorPublicarPropuesta implements ManejadorComando<Long> {

    private final ServicioPublicarPropuesta servicioPublicarPropuesta;

    public ManejadorPublicarPropuesta(ServicioPublicarPropuesta servicioPublicarPropuesta) {
        this.servicioPublicarPropuesta = servicioPublicarPropuesta;
    }

    public void ejecutar(Long idPropuesta) {
        this.servicioPublicarPropuesta.ejecutar(idPropuesta);
    }

}
