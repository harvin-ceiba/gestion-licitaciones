package com.ceiba.requerimiento.puerto.repositorio;

import com.ceiba.requerimiento.modelo.entidad.Requerimiento;

public interface RepositorioRequerimiento {
    
	/**
     * Permite crear un Requerimiento
     * @param requerimiento
     * @return el id generado
     */
    Long crear(Requerimiento requerimiento);

    /**
     * Permite actualizar un Requerimiento
     * @param requerimiento
     */
    void actualizar(Requerimiento requerimiento);

    /**
     * Permite eliminar un requerimiento
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un requerimiento con una descripcion
     * @param descripcion
     * @return si existe o no
     */
    boolean existe(String descripcion);

    /**
     * Permite validar si existe un requerimiento con una descripcion excluyendo un id
     * @param descripcion
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String descripcion);

}
