package com.ceiba.propuesta_requerimiento.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.propuesta_requerimiento.comando.ComandoPropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.comando.fabrica.FabricaPropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.modelo.entidad.PropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.servicio.ServicioCrearPropuestaRequerimiento;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPropuestaRequerimiento implements ManejadorComandoRespuesta<ComandoPropuestaRequerimiento, ComandoRespuesta<Long>> {

    private final FabricaPropuestaRequerimiento fabricaPropuestaRequerimiento;
    private final ServicioCrearPropuestaRequerimiento servicioCrearPropuestaRequerimiento;

    public ManejadorCrearPropuestaRequerimiento(
    		FabricaPropuestaRequerimiento fabricaPropuestaRequerimiento, 
    		ServicioCrearPropuestaRequerimiento servicioCrearPropuestaRequerimiento) {
        this.fabricaPropuestaRequerimiento = fabricaPropuestaRequerimiento;
        this.servicioCrearPropuestaRequerimiento = servicioCrearPropuestaRequerimiento;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPropuestaRequerimiento comandoPropuestaRequerimiento) {
        PropuestaRequerimiento propuestaRequerimiento = this.fabricaPropuestaRequerimiento.crear(comandoPropuestaRequerimiento);
        return new ComandoRespuesta<>(this.servicioCrearPropuestaRequerimiento.ejecutar(propuestaRequerimiento));
    }
}
