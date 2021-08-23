package com.ceiba.requerimiento.servicio;

import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

public class ServicioEliminarRequerimiento {

    private final RepositorioRequerimiento repositorioRequerimiento;

    public ServicioEliminarRequerimiento(RepositorioRequerimiento repositorioRequerimiento) {
        this.repositorioRequerimiento = repositorioRequerimiento;
    }

    public void ejecutar(Long id) {
        this.repositorioRequerimiento.eliminar(id);
    }
}
