package com.ceiba.licitacion_requerimiento.servicio;

import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

public class ServicioEliminarLicitacionRequerimiento extends ServicioGenericoLicitacionRequerimiento {
	
    public ServicioEliminarLicitacionRequerimiento(
    		RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento,
    		RepositorioLicitacion repositorioLicitacion,
    		RepositorioRequerimiento repositorioRequerimiento) {
    	
        super(repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
    }

    public void ejecutar(Long licitacionId, Long requerimientoId) {
    	validarExistenciaPrevia(licitacionId, requerimientoId);
    	validarExistenciaLicitacion(licitacionId);
    	validarExistenciaRequerimiento(requerimientoId);
        this.repositorioLicitacionRequerimiento.eliminar(licitacionId, requerimientoId);
    }
    
}
