package com.ceiba.propuesta.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.propuesta.comando.ComandoPropuesta;
import com.ceiba.propuesta.modelo.entidad.Propuesta;

@Component
public class FabricaPropuesta {

    public Propuesta crear(ComandoPropuesta comandoPropuesta) {
    	return new Propuesta(
    		comandoPropuesta.getId(), 
    		comandoPropuesta.getLicitacionId(), 
    		comandoPropuesta.getNombre(), 
    		comandoPropuesta.getDescripcion(), 
    		comandoPropuesta.getNombreCliente(), 
    		comandoPropuesta.getValor(), 
    		comandoPropuesta.getFechaCreacion(), 
    		comandoPropuesta.getFechaPublicacion(), 
    		comandoPropuesta.getEstado()
    	);
    }

}
