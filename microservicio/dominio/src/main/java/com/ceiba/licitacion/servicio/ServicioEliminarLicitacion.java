package com.ceiba.licitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;

public class ServicioEliminarLicitacion {
	
    private static final String LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA = "La licitación no existe en el sistema";

    private final RepositorioLicitacion repositorioLicitacion;

    public ServicioEliminarLicitacion(RepositorioLicitacion repositorioLicitacion) {
        this.repositorioLicitacion = repositorioLicitacion;
    }

    public void ejecutar(Long id) {
    	validarExistenciaId(id);
        this.repositorioLicitacion.eliminar(id);
    }
    
    private void validarExistenciaId(Long idPropuesta) {
    	boolean existe = this.repositorioLicitacion.existe(idPropuesta);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
