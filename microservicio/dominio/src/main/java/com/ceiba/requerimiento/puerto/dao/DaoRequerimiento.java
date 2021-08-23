package com.ceiba.requerimiento.puerto.dao;

import com.ceiba.requerimiento.modelo.dto.DtoRequerimiento;

import java.util.List;

public interface DaoRequerimiento {

    /**
     * Permite listar Requerimientos
     * @return los Requerimientos
     */
    List<DtoRequerimiento> listar();
}
