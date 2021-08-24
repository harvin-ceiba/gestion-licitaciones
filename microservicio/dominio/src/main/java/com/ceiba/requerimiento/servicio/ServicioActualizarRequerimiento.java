package com.ceiba.requerimiento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.requerimiento.modelo.entidad.Requerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

public class ServicioActualizarRequerimiento {

    private static final String EL_REQUERIMIENTO_NO_EXISTE_EN_EL_SISTEMA = "El requerimiento no existe en el sistema";
    private static final String EL_NOMBRE_DEL_REQUERIMIENTO_YA_EXISTE_EN_EL_SISTEMA = "El requerimiento ya existe en el sistema";

    private final RepositorioRequerimiento repositorioRequerimiento;

    public ServicioActualizarRequerimiento(RepositorioRequerimiento repositorioRequerimiento) {
        this.repositorioRequerimiento = repositorioRequerimiento;
    }

    public void ejecutar(Requerimiento requerimiento) {
    	validarExistenciaId(requerimiento.getId());
        validarExistenciaPrevia(requerimiento);
        this.repositorioRequerimiento.actualizar(requerimiento);
    }
    
    private void validarExistenciaId(Long id) {
        boolean existe = this.repositorioRequerimiento.existe(id);
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_REQUERIMIENTO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPrevia(Requerimiento requerimiento) {
        boolean existe = this.repositorioRequerimiento.existeExcluyendoId(requerimiento.getId(), requerimiento.getDescripcion());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_NOMBRE_DEL_REQUERIMIENTO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
