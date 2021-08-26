package com.ceiba.propuesta_requerimiento.servicio;

import com.ceiba.propuesta_requerimiento.modelo.entidad.PropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.puerto.repositorio.RepositorioPropuestaRequerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;

public class ServicioCrearPropuestaRequerimiento {

    private static final String EL_REQUERIMIENTO_YA_EXISTE_EN_LA_PROPUESTA = "El Requerimiento ya se encuentra asociado a la Propuesta";
    private static final String LA_PROPUESTA_PROPUESTA_NO_EXISTE = "La Propuesta no existe en el sistema";
    private static final String EL_REQUERIMIENTO_NO_EXISTE = "El Requerimiento no existe en el sistema";

    private final RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento;
    private final RepositorioPropuesta repositorioPropuesta;
    private final RepositorioRequerimiento repositorioRequerimiento;

    public ServicioCrearPropuestaRequerimiento(RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento,
    		RepositorioPropuesta repositorioPropuesta,
    		RepositorioRequerimiento repositorioRequerimiento) {
        this.repositorioPropuestaRequerimiento = repositorioPropuestaRequerimiento;
        this.repositorioPropuesta = repositorioPropuesta;
        this.repositorioRequerimiento = repositorioRequerimiento;
    }

    public Long ejecutar(PropuestaRequerimiento propuestaRequerimiento) {
    	validarExistenciaPrevia(propuestaRequerimiento);
    	validarExistenciaPropuesta(propuestaRequerimiento.getPropuestaId());
    	validarExistenciaRequerimiento(propuestaRequerimiento.getRequerimientoId());
        return this.repositorioPropuestaRequerimiento.crear(propuestaRequerimiento);
    }
    
    private void validarExistenciaPrevia(PropuestaRequerimiento propuestaRequerimiento) {
    	boolean existe = this.repositorioPropuestaRequerimiento.existe(propuestaRequerimiento.getPropuestaId(), propuestaRequerimiento.getRequerimientoId());
    	if(existe) {
    		throw new ExcepcionDuplicidad(EL_REQUERIMIENTO_YA_EXISTE_EN_LA_PROPUESTA);
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
