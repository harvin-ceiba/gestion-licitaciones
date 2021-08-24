package com.ceiba.licitacion_requerimiento.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.licitacion_requerimiento.comando.ComandoLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.modelo.entidad.LicitacionRequerimiento;

@Component
public class FabricaLicitacionRequerimiento {

    public LicitacionRequerimiento crear(ComandoLicitacionRequerimiento comandoLicitacionRequerimiento) {
        return new LicitacionRequerimiento(
        	comandoLicitacionRequerimiento.getId(),
        	comandoLicitacionRequerimiento.getLicitacionId(),
        	comandoLicitacionRequerimiento.getRequerimientoId(),
        	comandoLicitacionRequerimiento.getPesoPorcentual()
        );
    }

}
