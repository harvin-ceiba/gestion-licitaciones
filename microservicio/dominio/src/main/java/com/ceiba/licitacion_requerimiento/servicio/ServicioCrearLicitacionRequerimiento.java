package com.ceiba.licitacion_requerimiento.servicio;

import com.ceiba.licitacion_requerimiento.modelo.entidad.LicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearLicitacionRequerimiento {

    private static final String EL_REQUERIMIENTO_YA_EXISTE_EN_LA_LICITACION = "El Requerimiento ya se encuentra asociado a la Licitación";

    private final RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento;

    public ServicioCrearLicitacionRequerimiento(RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento) {
        this.repositorioLicitacionRequerimiento = repositorioLicitacionRequerimiento;
    }

    public Long ejecutar(LicitacionRequerimiento licitacionRequerimiento) {
        validarExistenciaPrevia(licitacionRequerimiento);
        return this.repositorioLicitacionRequerimiento.crear(licitacionRequerimiento);
    }

    private void validarExistenciaPrevia(LicitacionRequerimiento licitacionRequerimiento) {
        boolean existe = this.repositorioLicitacionRequerimiento.existe(licitacionRequerimiento.getLicitacionId(), licitacionRequerimiento.getRequerimientoId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_REQUERIMIENTO_YA_EXISTE_EN_LA_LICITACION);
        }
    }
}
