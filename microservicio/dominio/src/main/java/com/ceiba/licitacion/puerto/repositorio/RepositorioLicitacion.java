package com.ceiba.licitacion.puerto.repositorio;

import com.ceiba.licitacion.modelo.entidad.Licitacion;

public interface RepositorioLicitacion {
    
	/**
     * Permite crear una Licitacion
     * @param licitacion
     * @return el id generado
     */
    Long crear(Licitacion licitacion);

    /**
     * Permite actualizar una licitacion
     * @param licitacion
     */
    void actualizar(Licitacion licitacion);

    /**
     * Permite eliminar una licitacion
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una licitacion con un codigo
     * @param codigo
     * @return si existe o no
     */
    boolean existe(String codigo);

    /**
     * Permite validar si existe una licitacion con un codigo excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String codigo);

}
