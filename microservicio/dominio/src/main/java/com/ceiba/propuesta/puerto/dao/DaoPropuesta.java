package com.ceiba.propuesta.puerto.dao;

import com.ceiba.propuesta.modelo.dto.DtoPropuesta;

import java.util.List;

public interface DaoPropuesta {

    /**
     * Permite listar Propuestas de una Licitacion
     * @return las Propuestas
     */
    List<DtoPropuesta> listar(Long licitacionId);
    
    /**
     * Permite buscar una Propuesta por Id
     * @return la Propuesta
     */
    DtoPropuesta buscarPorId(Long id);
}
