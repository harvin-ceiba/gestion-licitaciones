package com.ceiba.licitacion_requerimiento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;

public class ServicioEliminarLicitacionRequerimiento {
	
    private static final String EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION = "El Requerimiento no se encuentra asociado a la Licitación";

    private final RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento;

    public ServicioEliminarLicitacionRequerimiento(RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento) {
        this.repositorioLicitacionRequerimiento = repositorioLicitacionRequerimiento;
    }

    public void ejecutar(Long licitacionId, Long requerimientoId) {
    	validarExistenciaPrevia(licitacionId, requerimientoId);
        this.repositorioLicitacionRequerimiento.eliminar(licitacionId, requerimientoId);
    }
    
    private void validarExistenciaPrevia(Long licitacionId, Long requerimientoId) {
        boolean existe = this.repositorioLicitacionRequerimiento.existe(licitacionId, requerimientoId);
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION);
        }
    }

}
