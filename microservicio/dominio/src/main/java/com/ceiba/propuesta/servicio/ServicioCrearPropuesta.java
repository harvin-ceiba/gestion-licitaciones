package com.ceiba.propuesta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.propuesta.modelo.entidad.Propuesta;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;

public class ServicioCrearPropuesta {

    private static final String LA_PROPUESTA_YA_EXISTE_EN_EL_SISTEMA = "La propuesta ya existe en el sistema";

    private final RepositorioPropuesta repositorioPropuesta;

    public ServicioCrearPropuesta(RepositorioPropuesta repositorioPropuesta) {
        this.repositorioPropuesta = repositorioPropuesta;
    }

    public Long ejecutar(Propuesta propuesta) {
        validarExistenciaPrevia(propuesta);
        return this.repositorioPropuesta.crear(propuesta);
    }

    private void validarExistenciaPrevia(Propuesta propuesta) {
        boolean existe = this.repositorioPropuesta.existe(propuesta.getLicitacionId(), propuesta.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_PROPUESTA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
