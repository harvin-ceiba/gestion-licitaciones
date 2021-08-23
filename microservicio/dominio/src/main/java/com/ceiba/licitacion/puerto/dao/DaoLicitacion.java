package com.ceiba.licitacion.puerto.dao;

import com.ceiba.licitacion.modelo.dto.DtoLicitacion;

import java.util.List;

public interface DaoLicitacion {

    /**
     * Permite listar licitaciones
     * @return las licitaciones
     */
    List<DtoLicitacion> listar();
    
    /**
     * Permite buscar una Licitación por Id
     * @return la Licitación
     */
    DtoLicitacion buscarPorId(Long id);
}
