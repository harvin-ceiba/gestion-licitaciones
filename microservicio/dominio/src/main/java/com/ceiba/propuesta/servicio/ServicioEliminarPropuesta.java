package com.ceiba.propuesta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;

public class ServicioEliminarPropuesta {

	private static final String LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA = "La Licitacion no existe en el sistema";
    private static final String LA_PROPUESTA_NO_EXISTE_EN_EL_SISTEMA = "La propuesta no existe en el sistema";

    private final RepositorioLicitacion repositorioLicitacion;
    private final RepositorioPropuesta repositorioPropuesta;

    public ServicioEliminarPropuesta(RepositorioPropuesta repositorioPropuesta, RepositorioLicitacion repositorioLicitacion) {
        this.repositorioPropuesta = repositorioPropuesta;
        this.repositorioLicitacion = repositorioLicitacion;
    }

    public void ejecutar(Long licitacionId, Long idPropuesta) {
    	validarExistenciaLicitacion(licitacionId);
    	validarExistenciaPrevia(idPropuesta);
        this.repositorioPropuesta.eliminar(idPropuesta);
    }
    
    private void validarExistenciaLicitacion(Long licitacionId) {
        boolean existe = this.repositorioLicitacion.existe(licitacionId);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
    
    private void validarExistenciaPrevia(Long idPropuesta) {
    	boolean existe = this.repositorioPropuesta.existe(idPropuesta);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_PROPUESTA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
