package com.ceiba.requerimiento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.requerimiento.modelo.entidad.Requerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

public class ServicioActualizarRequerimiento {

    private static final String EL_REQUERIMIETNO_YA_EXISTE_EN_EL_SISTEMA = "El requerimiento ya existe en el sistema";

    private final RepositorioRequerimiento repositorioRequerimiento;

    public ServicioActualizarRequerimiento(RepositorioRequerimiento repositorioRequerimiento) {
        this.repositorioRequerimiento = repositorioRequerimiento;
    }

    public void ejecutar(Requerimiento requerimiento) {
        validarExistenciaPrevia(requerimiento);
        this.repositorioRequerimiento.actualizar(requerimiento);
    }

    private void validarExistenciaPrevia(Requerimiento requerimiento) {
        boolean existe = this.repositorioRequerimiento.existeExcluyendoId(requerimiento.getId(), requerimiento.getDescripcion());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_REQUERIMIETNO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
