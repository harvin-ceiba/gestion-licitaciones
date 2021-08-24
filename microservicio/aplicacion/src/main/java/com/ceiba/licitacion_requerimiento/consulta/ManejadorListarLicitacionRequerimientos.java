package com.ceiba.licitacion_requerimiento.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.licitacion_requerimiento.modelo.dto.DtoLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.dao.DaoLicitacionRequerimiento;

@Component
public class ManejadorListarLicitacionRequerimientos {

    private final DaoLicitacionRequerimiento daoLicitacionRequerimiento;

    public ManejadorListarLicitacionRequerimientos(DaoLicitacionRequerimiento daoLicitacionRequerimiento){
        this.daoLicitacionRequerimiento = daoLicitacionRequerimiento;
    }

    public List<DtoLicitacionRequerimiento> listar(Long idLicitacion){ 
    	return this.daoLicitacionRequerimiento.listar(idLicitacion); 
    }
    
}
