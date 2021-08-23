package com.ceiba.licitacion.servicio;

import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;

public class ServicioEliminarLicitacion {

    private final RepositorioLicitacion repositorioLicitacion;

    public ServicioEliminarLicitacion(RepositorioLicitacion repositorioLicitacion) {
        this.repositorioLicitacion = repositorioLicitacion;
    }

    public void ejecutar(Long id) {
        this.repositorioLicitacion.eliminar(id);
    }
}
