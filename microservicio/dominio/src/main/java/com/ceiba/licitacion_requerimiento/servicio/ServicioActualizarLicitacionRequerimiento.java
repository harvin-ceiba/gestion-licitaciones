package com.ceiba.licitacion_requerimiento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion_requerimiento.modelo.entidad.LicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;

public class ServicioActualizarLicitacionRequerimiento {
	
    private static final String EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION = "El Requerimiento no se encuentra asociado a la Licitaci�n";

    private final RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento;

    public ServicioActualizarLicitacionRequerimiento(RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento) {
        this.repositorioLicitacionRequerimiento = repositorioLicitacionRequerimiento;
    }

    public void ejecutar(LicitacionRequerimiento licitacionRequerimiento) {
    	validarExistenciaPrevia(licitacionRequerimiento);
        this.repositorioLicitacionRequerimiento.actualizar(licitacionRequerimiento);
    }
    
    private void validarExistenciaPrevia(LicitacionRequerimiento licitacionRequerimiento) {
        boolean existe = this.repositorioLicitacionRequerimiento.existe(licitacionRequerimiento.getLicitacionId(), licitacionRequerimiento.getRequerimientoId());
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION);
        }
    }

}
