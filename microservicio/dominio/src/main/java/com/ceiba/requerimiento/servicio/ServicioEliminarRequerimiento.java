package com.ceiba.requerimiento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

public class ServicioEliminarRequerimiento {

    private static final String EL_REQUERIMIENTO_NO_EXISTE_EN_EL_SISTEMA = "El requerimiento no existe en el sistema";

    private final RepositorioRequerimiento repositorioRequerimiento;

    public ServicioEliminarRequerimiento(RepositorioRequerimiento repositorioRequerimiento) {
        this.repositorioRequerimiento = repositorioRequerimiento;
    }

    public void ejecutar(Long id) {
    	validarExistenciaId(id);
        this.repositorioRequerimiento.eliminar(id);
    }
    
    private void validarExistenciaId(Long id) {
        boolean existe = this.repositorioRequerimiento.existe(id);
        if(!existe) {
            throw new ExcepcionValorInvalido(EL_REQUERIMIENTO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
