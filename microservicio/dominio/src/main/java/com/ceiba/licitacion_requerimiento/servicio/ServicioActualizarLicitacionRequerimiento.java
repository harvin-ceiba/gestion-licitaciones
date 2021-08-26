package com.ceiba.licitacion_requerimiento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion_requerimiento.modelo.entidad.LicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

public class ServicioActualizarLicitacionRequerimiento {
	
	private static final String EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION = "El Requerimiento no se encuentra asociado a la Licitación";
	private static final String LA_LICITACION_NO_EXISTE = "La Licitación no existe en el sistema";
	private static final String EL_REQUERIMIENTO_NO_EXISTE = "El Requerimiento no existe en el sistema";

	private final RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento;
	private final RepositorioLicitacion repositorioLicitacion;
	private final RepositorioRequerimiento repositorioRequerimiento;

    public ServicioActualizarLicitacionRequerimiento(RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento,
    		RepositorioLicitacion repositorioLicitacion,
    		RepositorioRequerimiento repositorioRequerimiento) {
        this.repositorioLicitacionRequerimiento = repositorioLicitacionRequerimiento;
        this.repositorioLicitacion = repositorioLicitacion;
        this.repositorioRequerimiento = repositorioRequerimiento;
    }
    
    public void ejecutar(LicitacionRequerimiento licitacionRequerimiento) {
    	validarExistenciaPrevia(licitacionRequerimiento);
    	validarExistenciaLicitacion(licitacionRequerimiento.getLicitacionId());
    	validarExistenciaRequerimiento(licitacionRequerimiento.getRequerimientoId());
        this.repositorioLicitacionRequerimiento.actualizar(licitacionRequerimiento);
    }
    
    private void validarExistenciaPrevia(LicitacionRequerimiento licitacionRequerimiento) {
    	boolean existe = this.repositorioLicitacionRequerimiento.existe(licitacionRequerimiento.getLicitacionId(), licitacionRequerimiento.getRequerimientoId());
    	if(!existe) {
    		throw new ExcepcionValorInvalido(EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION);
    	}
    }
    
    private void validarExistenciaLicitacion(Long licitacionId) {
        boolean existe = this.repositorioLicitacion.existeId(licitacionId);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_LICITACION_NO_EXISTE);
        }
    }
    
    private void validarExistenciaRequerimiento(Long requerimientoId) {
        boolean existe = this.repositorioRequerimiento.existe(requerimientoId);
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_REQUERIMIENTO_NO_EXISTE);
        }
    }
    

}
