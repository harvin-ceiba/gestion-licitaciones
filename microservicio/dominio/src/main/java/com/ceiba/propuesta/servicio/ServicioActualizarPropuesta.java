package com.ceiba.propuesta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.propuesta.modelo.entidad.Propuesta;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;

public class ServicioActualizarPropuesta {

    private static final String LA_PROPUESTA_NO_EXISTE_EN_EL_SISTEMA = "La propuesta no existe en el sistema";
    private static final String LA_PROPUESTA_SE_ENCUENTRA_ASOCIADA_A_LICITACION = "La propuesta ya se encuentra asociada a la Licitaci�n";

    private final RepositorioPropuesta repositorioPropuesta;

    public ServicioActualizarPropuesta(RepositorioPropuesta repositorioPropuesta) {
        this.repositorioPropuesta = repositorioPropuesta;
    }

    public void ejecutar(Propuesta propuesta) {
    	validarExistenciaPrevia(propuesta.getId());
    	validarExistenciaPreviaEnLicitacion(propuesta);
        this.repositorioPropuesta.actualizar(propuesta);
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
