package com.ceiba.licitacion_requerimiento.puerto.repositorio;

import com.ceiba.licitacion_requerimiento.modelo.entidad.LicitacionRequerimiento;

public interface RepositorioLicitacionRequerimiento {
    
	/**
     * Permite crear un Requerimiento a una Licitacion
     * @param licitacionRequerimiento
     * @return el id generado
     */
    Long crear(LicitacionRequerimiento licitacionRequerimiento);

    /**
     * Permite actualizar un Requerimiento de la Licitacion
     * @param licitacionRequerimiento
     */
    void actualizar(LicitacionRequerimiento licitacionRequerimiento);

    /**
     * Permite eliminar un Requerimiento de una Licitacion
     * @param id
     */
    void eliminar(Long licitacionId, Long requerimientoId);

    /**
     * Permite validar si existe un Requerimiento específico en una Licitacion
     * @param requerimientoId
     * @return si existe o no
     */
    boolean existe(Long licitacionId, Long requerimientoId);

}
