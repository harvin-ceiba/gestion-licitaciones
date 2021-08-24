package com.ceiba.propuesta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;

public class ServicioEliminarPropuesta {

    private static final String LA_PROPUESTA_NO_EXISTE_EN_EL_SISTEMA = "La propuesta no existe en el sistema";

    private final RepositorioPropuesta repositorioPropuesta;

    public ServicioEliminarPropuesta(RepositorioPropuesta repositorioPropuesta) {
        this.repositorioPropuesta = repositorioPropuesta;
    }

    public void ejecutar(Long id) {
    	validarExistenciaPrevia(id);
        this.repositorioPropuesta.eliminar(id);
    }
    
    private void validarExistenciaPrevia(Long id) {
    	boolean existe = this.repositorioPropuesta.existe(id);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_PROPUESTA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
