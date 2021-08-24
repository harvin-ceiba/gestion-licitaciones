package com.ceiba.propuesta_requerimiento.puerto.repositorio;

import com.ceiba.propuesta_requerimiento.modelo.entidad.PropuestaRequerimiento;

public interface RepositorioPropuestaRequerimiento {
    
	/**
     * Permite crear un Requerimiento a una Propuesta
     * @param propuestaRequerimiento
     * @return el id generado
     */
    Long crear(PropuestaRequerimiento propuestaRequerimiento);

    /**
     * Permite eliminar un Requerimiento de una Propuesta
     * @param id
     */
    void eliminar(Long propuestaId, Long requerimientoId);

    /**
     * Permite validar si existe un Requerimiento específico en una Propuesta
     * @param requerimientoId
     * @return si existe o no
     */
    boolean existe(Long propuestaId, Long requerimientoId);

}
