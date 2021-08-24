package com.ceiba.licitacion_requerimiento.puerto.dao;

import com.ceiba.licitacion_requerimiento.modelo.dto.DtoLicitacionRequerimiento;

import java.util.List;

public interface DaoLicitacionRequerimiento {

    /**
     * Permite listar los Requerimientos de la Licitación
     * @return los Requerimientos
     */
    List<DtoLicitacionRequerimiento> listar(Long licitacionId);
    
}
