package com.ceiba.propuesta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.propuesta.modelo.entidad.Propuesta;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;

public class ServicioActualizarPropuesta {

	private static final String LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA = "La Licitacion no existe en el sistema";
    private static final String LA_PROPUESTA_NO_EXISTE_EN_EL_SISTEMA = "La propuesta no existe en el sistema";
    private static final String LA_PROPUESTA_SE_ENCUENTRA_ASOCIADA_A_LICITACION = "La propuesta ya se encuentra asociada a la Licitacion";

    private final RepositorioLicitacion repositorioLicitacion;
    private final RepositorioPropuesta repositorioPropuesta;

    public ServicioActualizarPropuesta(RepositorioPropuesta repositorioPropuesta, RepositorioLicitacion repositorioLicitacion) {
        this.repositorioPropuesta = repositorioPropuesta;
        this.repositorioLicitacion = repositorioLicitacion;
    }

    public void ejecutar(Propuesta propuesta) {
    	validarExistenciaLicitacion(propuesta.getLicitacionId());
    	validarExistenciaPrevia(propuesta.getId());
    	validarExistenciaPreviaEnLicitacion(propuesta);
        this.repositorioPropuesta.actualizar(propuesta);
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

    private void validarExistenciaPreviaEnLicitacion(Propuesta propuesta) {
        boolean existe = this.repositorioPropuesta.existeExcluyendoId(propuesta.getId(), propuesta.getLicitacionId(), propuesta.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_PROPUESTA_SE_ENCUENTRA_ASOCIADA_A_LICITACION);
        }
    }
}
