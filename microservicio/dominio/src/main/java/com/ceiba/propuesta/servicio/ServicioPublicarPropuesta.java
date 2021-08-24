package com.ceiba.propuesta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;

public class ServicioPublicarPropuesta {

    private static final String LA_PROPUESTA_NO_EXISTE = "La propuesta que intenta publicar no existe";

    private final RepositorioPropuesta repositorioPropuesta;

    public ServicioPublicarPropuesta(RepositorioPropuesta repositorioPropuesta) {
        this.repositorioPropuesta = repositorioPropuesta;
    }

    public void ejecutar(Long idPropuesta) {
    	validarExistenciaPrevia(idPropuesta);
        this.repositorioPropuesta.publicar(idPropuesta);
    }
    
    private void validarExistenciaPrevia(Long idPropuesta) {
    	boolean existe = this.repositorioPropuesta.existe(idPropuesta);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_PROPUESTA_NO_EXISTE);
        }
    }
}
