package com.ceiba.propuesta.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.propuesta.comando.ComandoPropuesta;
import com.ceiba.propuesta.comando.fabrica.FabricaPropuesta;
import com.ceiba.propuesta.modelo.entidad.Propuesta;
import com.ceiba.propuesta.servicio.ServicioActualizarPropuesta;

import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPropuesta implements ManejadorComando<ComandoPropuesta> {

    private final FabricaPropuesta fabricaPropuesta;
    private final ServicioActualizarPropuesta servicioActualizarPropuesta;

    public ManejadorActualizarPropuesta(FabricaPropuesta fabricaPropuesta, ServicioActualizarPropuesta servicioActualizarPropuesta) {
        this.fabricaPropuesta = fabricaPropuesta;
        this.servicioActualizarPropuesta = servicioActualizarPropuesta;
    }

    public void ejecutar(ComandoPropuesta comandoPropuesta) {
        Propuesta propuesta = this.fabricaPropuesta.crear(comandoPropuesta);
        this.servicioActualizarPropuesta.ejecutar(propuesta);
    }
}
