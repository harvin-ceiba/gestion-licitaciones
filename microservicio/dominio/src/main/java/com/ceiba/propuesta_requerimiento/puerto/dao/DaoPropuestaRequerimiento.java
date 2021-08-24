package com.ceiba.propuesta_requerimiento.puerto.dao;

import com.ceiba.propuesta_requerimiento.modelo.dto.DtoPropuestaRequerimiento;

import java.util.List;

public interface DaoPropuestaRequerimiento {

    /**
     * Permite listar los Requerimientos de la Propuesta
     * @return los Requerimientos
     */
    List<DtoPropuestaRequerimiento> listar(Long propuestaId);
    
}
