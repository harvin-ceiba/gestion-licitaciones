package com.ceiba.propuesta.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.propuesta.comando.ComandoPropuesta;
import com.ceiba.propuesta.comando.fabrica.FabricaPropuesta;
import com.ceiba.propuesta.modelo.entidad.Propuesta;
import com.ceiba.propuesta.servicio.ServicioCrearPropuesta;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPropuesta implements ManejadorComandoRespuesta<ComandoPropuesta, ComandoRespuesta<Long>> {

    private final FabricaPropuesta fabricaPropuesta;
    private final ServicioCrearPropuesta servicioCrearPropuesta;

    public ManejadorCrearPropuesta(FabricaPropuesta fabricaPropuesta, ServicioCrearPropuesta servicioCrearPropuesta) {
        this.fabricaPropuesta = fabricaPropuesta;
        this.servicioCrearPropuesta = servicioCrearPropuesta;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPropuesta comandoPropuesta) {
        Propuesta propuesta = this.fabricaPropuesta.crear(comandoPropuesta);
        return new ComandoRespuesta<>(this.servicioCrearPropuesta.ejecutar(propuesta));
    }
}
