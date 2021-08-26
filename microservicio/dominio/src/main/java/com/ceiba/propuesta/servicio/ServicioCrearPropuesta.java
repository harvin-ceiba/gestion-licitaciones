package com.ceiba.propuesta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.propuesta.modelo.entidad.Propuesta;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;

public class ServicioCrearPropuesta {

	private static final String LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA = "La Licitación no existe en el sistema";
    private static final String LA_PROPUESTA_YA_EXISTE_EN_EL_SISTEMA = "La propuesta ya existe en el sistema";

    private final RepositorioLicitacion repositorioLicitacion;
    private final RepositorioPropuesta repositorioPropuesta;

    public ServicioCrearPropuesta(RepositorioPropuesta repositorioPropuesta, RepositorioLicitacion repositorioLicitacion) {
        this.repositorioPropuesta = repositorioPropuesta;
        this.repositorioLicitacion = repositorioLicitacion;
    }

    public Long ejecutar(Propuesta propuesta) {
    	validarExistenciaLicitacion(propuesta.getLicitacionId());
        validarExistenciaPrevia(propuesta);
        return this.repositorioPropuesta.crear(propuesta);
    }
    
    private void validarExistenciaLicitacion(Long licitacionId) {
        boolean existe = this.repositorioLicitacion.existe(licitacionId);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPrevia(Propuesta propuesta) {
        boolean existe = this.repositorioPropuesta.existe(propuesta.getLicitacionId(), propuesta.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_PROPUESTA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
