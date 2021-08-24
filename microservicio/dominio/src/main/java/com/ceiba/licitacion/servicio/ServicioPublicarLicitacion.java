package com.ceiba.licitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;

public class ServicioPublicarLicitacion {

    private static final String LA_LICITACION_NO_EXISTE = "La licitación que intenta publicar no existe";

    private final RepositorioLicitacion repositorioLicitacion;

    public ServicioPublicarLicitacion(RepositorioLicitacion repositorioLicitacion) {
        this.repositorioLicitacion = repositorioLicitacion;
    }

    public void ejecutar(Long id) {
    	validarExistenciaPrevia(id);
        this.repositorioLicitacion.publicar(id);
    }

    private void validarExistenciaPrevia(Long idPropuesta) {
    	boolean existe = this.repositorioLicitacion.existeId(idPropuesta);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_LICITACION_NO_EXISTE);
        }
    }
}
