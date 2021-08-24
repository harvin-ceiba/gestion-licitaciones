package com.ceiba.propuesta_requerimiento.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.propuesta_requerimiento.comando.ComandoPropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.modelo.entidad.PropuestaRequerimiento;

@Component
public class FabricaPropuestaRequerimiento {

    public PropuestaRequerimiento crear(ComandoPropuestaRequerimiento comandoPropuestaRequerimiento) {
        return new PropuestaRequerimiento(
        		comandoPropuestaRequerimiento.getId(),
        		comandoPropuestaRequerimiento.getPropuestaId(),
        		comandoPropuestaRequerimiento.getRequerimientoId()
        );
    }

}
