package com.ceiba.licitacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.licitacion.comando.ComandoLicitacion;
import com.ceiba.licitacion.modelo.entidad.Licitacion;

@Component
public class FabricaLicitacion {

    public Licitacion crear(ComandoLicitacion comandoLicitacion) {
        return new Licitacion(
        	comandoLicitacion.getId(),
        	comandoLicitacion.getCodigo(),
        	comandoLicitacion.getNombre(),
        	comandoLicitacion.getDescripcion(),
        	comandoLicitacion.getPresupuesto(),
        	comandoLicitacion.getFechaInicio(), 
        	comandoLicitacion.getFechaFin(), 
        	comandoLicitacion.getEstado()
        );
    }

}
