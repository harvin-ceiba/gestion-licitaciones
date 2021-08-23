package com.ceiba.licitacion.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.licitacion.modelo.dto.DtoLicitacion;
import com.ceiba.licitacion.puerto.dao.DaoLicitacion;

@Component
public class ManejadorListarLicitaciones {

    private final DaoLicitacion daoLicitacion;

    public ManejadorListarLicitaciones(DaoLicitacion daoLicitacion){
        this.daoLicitacion = daoLicitacion;
    }

    public List<DtoLicitacion> listar(){ 
    	return this.daoLicitacion.listar(); 
    }
    
    public DtoLicitacion buscarPorId(Long id) {
    	return this.daoLicitacion.buscarPorId(id);
    }
}
