package com.ceiba.propuesta_requerimiento.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.propuesta_requerimiento.modelo.dto.DtoPropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.puerto.dao.DaoPropuestaRequerimiento;

@Component
public class ManejadorListarPropuestaRequerimientos {

    private final DaoPropuestaRequerimiento daoPropuestaRequerimiento;

    public ManejadorListarPropuestaRequerimientos(DaoPropuestaRequerimiento daoPropuestaRequerimiento){
        this.daoPropuestaRequerimiento = daoPropuestaRequerimiento;
    }

    public List<DtoPropuestaRequerimiento> listar(Long idPropuesta){ 
    	return this.daoPropuestaRequerimiento.listar(idPropuesta); 
    }
    
}
