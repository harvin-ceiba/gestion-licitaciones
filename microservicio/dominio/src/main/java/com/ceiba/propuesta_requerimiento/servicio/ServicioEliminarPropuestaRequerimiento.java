package com.ceiba.propuesta_requerimiento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;
import com.ceiba.propuesta_requerimiento.puerto.repositorio.RepositorioPropuestaRequerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

public class ServicioEliminarPropuestaRequerimiento {
	
    private static final String EL_REQUERIMIENTO_NO_EXISTE_EN_LA_PROPUESTA = "El Requerimiento no se encuentra asociado a la Propuesta";
    private static final String LA_PROPUESTA_PROPUESTA_NO_EXISTE = "La Propuesta no existe en el sistema";
    private static final String EL_REQUERIMIENTO_NO_EXISTE = "El Requerimiento no existe en el sistema";

    private final RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento;
    private final RepositorioPropuesta repositorioPropuesta;
    private final RepositorioRequerimiento repositorioRequerimiento;

    public ServicioEliminarPropuestaRequerimiento(
    		RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento,
    		RepositorioPropuesta repositorioPropuesta,
    		RepositorioRequerimiento repositorioRequerimiento) {
        this.repositorioPropuestaRequerimiento = repositorioPropuestaRequerimiento;
        this.repositorioPropuesta = repositorioPropuesta;
        this.repositorioRequerimiento = repositorioRequerimiento;
    }

    public void ejecutar(Long propuestaId, Long requerimientoId) {
    	validarExistenciaPrevia(propuestaId, requerimientoId);
    	validarExistenciaPropuesta(propuestaId);
    	validarExistenciaRequerimiento(requerimientoId);
        this.repositorioPropuestaRequerimiento.eliminar(propuestaId, requerimientoId);
    }
    
    private void validarExistenciaPrevia(Long propuestaId, Long requerimientoId) {
    	boolean existe = this.repositorioPropuestaRequerimiento.existe(propuestaId, requerimientoId);
    	if(!existe) {
    		throw new ExcepcionValorInvalido(EL_REQUERIMIENTO_NO_EXISTE_EN_LA_PROPUESTA);
    	}
    }
    
    private void validarExistenciaPropuesta(Long propuestaId) {
        boolean existe = this.repositorioPropuesta.existe(propuestaId);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_PROPUESTA_PROPUESTA_NO_EXISTE);
        }
    }
    
    private void validarExistenciaRequerimiento(Long requerimientoId) {
        boolean existe = this.repositorioRequerimiento.existe(requerimientoId);
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_REQUERIMIENTO_NO_EXISTE);
        }
    }
    

}
