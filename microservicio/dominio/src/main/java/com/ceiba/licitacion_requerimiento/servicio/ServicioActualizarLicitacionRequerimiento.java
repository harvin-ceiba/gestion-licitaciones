package com.ceiba.licitacion_requerimiento.servicio;

import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion_requerimiento.modelo.entidad.LicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

public class ServicioActualizarLicitacionRequerimiento extends ServicioGenericoLicitacionRequerimiento {
	
    public ServicioActualizarLicitacionRequerimiento(RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento,
    		RepositorioLicitacion repositorioLicitacion,
    		RepositorioRequerimiento repositorioRequerimiento) {
    	
    	super(repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
    }
    
    public void ejecutar(LicitacionRequerimiento licitacionRequerimiento) {
    	validarExistenciaPrevia(licitacionRequerimiento.getLicitacionId(), licitacionRequerimiento.getRequerimientoId());
    	validarExistenciaLicitacion(licitacionRequerimiento.getLicitacionId());
    	validarExistenciaRequerimiento(licitacionRequerimiento.getRequerimientoId());
        this.repositorioLicitacionRequerimiento.actualizar(licitacionRequerimiento);
    }
    
}
