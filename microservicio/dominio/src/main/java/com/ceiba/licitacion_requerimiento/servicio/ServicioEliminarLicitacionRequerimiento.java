package com.ceiba.licitacion_requerimiento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

public class ServicioEliminarLicitacionRequerimiento {
	
    private static final String EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION = "El Requerimiento no se encuentra asociado a la Licitación";
    private static final String LA_LICITACION_PROPUESTA_NO_EXISTE = "La Licitación no existe en el sistema";
    private static final String EL_REQUERIMIENTO_NO_EXISTE = "El Requerimiento no existe en el sistema";

    private final RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento;
    private final RepositorioLicitacion repositorioLicitacion;
    private final RepositorioRequerimiento repositorioRequerimiento;

    public ServicioEliminarLicitacionRequerimiento(
    		RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento,
    		RepositorioLicitacion repositorioLicitacion,
    		RepositorioRequerimiento repositorioRequerimiento) {
        this.repositorioLicitacionRequerimiento = repositorioLicitacionRequerimiento;
        this.repositorioLicitacion = repositorioLicitacion;
        this.repositorioRequerimiento = repositorioRequerimiento;
    }

    public void ejecutar(Long licitacionId, Long requerimientoId) {
    	validarExistenciaLicitacion(licitacionId);
    	validarExistenciaRequerimiento(requerimientoId);
    	validarExistenciaPrevia(licitacionId, requerimientoId);
        this.repositorioLicitacionRequerimiento.eliminar(licitacionId, requerimientoId);
    }
    
    private void validarExistenciaLicitacion(Long licitacionId) {
        boolean existe = this.repositorioLicitacion.existeId(licitacionId);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_LICITACION_PROPUESTA_NO_EXISTE);
        }
    }
    
    private void validarExistenciaRequerimiento(Long requerimientoId) {
        boolean existe = this.repositorioRequerimiento.existe(requerimientoId);
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_REQUERIMIENTO_NO_EXISTE);
        }
    }
    
    private void validarExistenciaPrevia(Long licitacionId, Long requerimientoId) {
        boolean existe = this.repositorioLicitacionRequerimiento.existe(licitacionId, requerimientoId);
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION);
        }
    }

}
