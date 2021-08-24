package com.ceiba.licitacion.servicio;

import com.ceiba.licitacion.modelo.entidad.Licitacion;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearLicitacion {

    private static final String LA_LICITACION_YA_EXISTE_EN_EL_SISTEMA = "La licitación ya existe en el sistema";

    private final RepositorioLicitacion repositorioLicitacion;

    public ServicioCrearLicitacion(RepositorioLicitacion repositorioLicitacion) {
        this.repositorioLicitacion = repositorioLicitacion;
    }

    public Long ejecutar(Licitacion licitacion) {
        validarExistenciaPrevia(licitacion);
        return this.repositorioLicitacion.crear(licitacion);
    }

    private void validarExistenciaPrevia(Licitacion licitacion) {
        boolean existe = this.repositorioLicitacion.existeCodigo(licitacion.getCodigo());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_LICITACION_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
