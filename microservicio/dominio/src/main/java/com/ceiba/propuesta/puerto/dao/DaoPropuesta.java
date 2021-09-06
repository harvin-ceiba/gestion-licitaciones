package com.ceiba.propuesta.puerto.dao;

import com.ceiba.propuesta.modelo.dto.DtoPropuesta;

import java.util.List;

public interface DaoPropuesta {

	/**
     * Permite listar Propuestas
     * @return las Propuestas
     */
    List<DtoPropuesta> listar();
    
    /**
     * Permite listar Propuestas de una Licitacion
     * @return las Propuestas
     */
    List<DtoPropuesta> listarPorIdLicitacion(Long licitacionId);
    
    /**
     * Permite buscar una Propuesta por Id
     * @return la Propuesta
     */
    DtoPropuesta buscarPorId(Long id);
    
}
