package com.ceiba.requerimiento.servicio.testdatabuilder;

import java.util.UUID;

import com.ceiba.requerimiento.modelo.entidad.Requerimiento;

public class RequerimientoTestDataBuilder {
	
	private static final int VALOR_ESTADO = 1;

	private Long id;
	private String descripcion;
	private int estado;	
	
    public RequerimientoTestDataBuilder() {
    	descripcion = UUID.randomUUID().toString();
    	estado = VALOR_ESTADO;
    }
    
    public Requerimiento build() {
        return new Requerimiento(id, descripcion, estado);
    }
	
}
