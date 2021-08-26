package com.ceiba.propuesta.puerto.repositorio;

import com.ceiba.propuesta.modelo.entidad.Propuesta;

public interface RepositorioPropuesta {
    
	/**
     * Permite crear una Propuesta
     * @param propuesta
     * @return el id generado
     */
    Long crear(Propuesta propuesta);

    /**
     * Permite actualizar una Propuesta
     * @param propuesta
     */
    void actualizar(Propuesta propuesta);
    
    /**
     * Permite eliminar una Propuesta
     * @param id
     */
    void eliminar(Long id);
    
    /**
     * Permite validar si existe una Propuesta
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);

    /**
     * Permite validar si existe una Propuesta de una Licitacion con un nombre
     * @param idLicitacion
     * @param nombre
     * @return si existe o no
     */
    boolean existeIncluyendoIdLicitacion(Long licitacionId, String nombre);

    /**
     * Permite validar si existe una Propuesta de una Licitacion con un codigo excluyendo un id
     * @param idLicitacion
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, Long licitacionId, String nombre);
    
    /**
     * Permite publicar una Propuesta
     * @param propuesta
     */
    void publicar(Long id, double puntaje);

}
