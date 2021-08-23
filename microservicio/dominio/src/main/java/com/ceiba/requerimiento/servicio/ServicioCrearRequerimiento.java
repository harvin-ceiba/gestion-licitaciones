package com.ceiba.requerimiento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.requerimiento.modelo.entidad.Requerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

public class ServicioCrearRequerimiento {

    private static final String EL_REQUERIMIENTO_YA_EXISTE_EN_EL_SISTEMA = "El requerimiento ya existe en el sistema";

    private final RepositorioRequerimiento repositorioRequerimiento;

    public ServicioCrearRequerimiento(RepositorioRequerimiento repositorioRequerimiento) {
        this.repositorioRequerimiento = repositorioRequerimiento;
    }

    public Long ejecutar(Requerimiento requerimiento) {
        validarExistenciaPrevia(requerimiento);
        return this.repositorioRequerimiento.crear(requerimiento);
    }

    private void validarExistenciaPrevia(Requerimiento requerimiento) {
        boolean existe = this.repositorioRequerimiento.existe(requerimiento.getDescripcion());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_REQUERIMIENTO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
