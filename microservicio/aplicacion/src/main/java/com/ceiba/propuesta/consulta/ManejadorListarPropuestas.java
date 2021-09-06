package com.ceiba.propuesta.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.propuesta.modelo.dto.DtoPropuesta;
import com.ceiba.propuesta.puerto.dao.DaoPropuesta;

@Component
public class ManejadorListarPropuestas {

    private final DaoPropuesta daoPropuesta;

    public ManejadorListarPropuestas(DaoPropuesta daoPropuesta){
        this.daoPropuesta = daoPropuesta;
    }
    
    public List<DtoPropuesta> listar(){ 
    	return this.daoPropuesta.listar(); 
    }

    public List<DtoPropuesta> listarPorIdLicitacion(Long idLicitacion){ 
    	return this.daoPropuesta.listarPorIdLicitacion(idLicitacion); 
    }
    
    public DtoPropuesta buscarPorId(Long id) {
    	return this.daoPropuesta.buscarPorId(id);
    }
    
}
