package com.ceiba.requerimiento.servicio.testdatabuilder;

import com.ceiba.requerimiento.comando.ComandoRequerimiento;

import java.util.UUID;

public class ComandoRequerimientoTestDataBuilder {
	
	private static final int VALOR_ESTADO = 0;

	private Long id;
	private String descripcion;
	private int estado;	
	
    public ComandoRequerimientoTestDataBuilder() {
    	descripcion = UUID.randomUUID().toString();
    	estado = VALOR_ESTADO;
    }
    
    public ComandoRequerimiento build() {
        return new ComandoRequerimiento(id, descripcion, estado);
    }
}
