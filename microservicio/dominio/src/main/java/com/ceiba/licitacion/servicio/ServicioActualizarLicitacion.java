package com.ceiba.licitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.licitacion.modelo.entidad.Licitacion;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;

public class ServicioActualizarLicitacion {

    private static final String LA_LICITACION_YA_EXISTE_EN_EL_SISTEMA = "La licitaci�n ya existe en el sistema";

    private final RepositorioLicitacion repositorioLicitacion;

    public ServicioActualizarLicitacion(RepositorioLicitacion repositorioLicitacion) {
        this.repositorioLicitacion = repositorioLicitacion;
    }

    public void ejecutar(Licitacion licitacion) {
        validarExistenciaPrevia(licitacion);
        this.repositorioLicitacion.actualizar(licitacion);
    }

    private void validarExistenciaPrevia(Licitacion licitacion) {
        boolean existe = this.repositorioLicitacion.existeExcluyendoId(licitacion.getId(), licitacion.getCodigo());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_LICITACION_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
