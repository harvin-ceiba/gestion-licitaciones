package com.ceiba.licitacion_requerimiento.servicio.testdatabuilder;

import com.ceiba.licitacion_requerimiento.modelo.entidad.LicitacionRequerimiento;

public class LicitacionRequerimientoTestDataBuilder {
	
	private static final Long VALOR_LICITACION_ID = 1L;
	private static final Long VALOR_REQUERIMIENTO_ID = 1L;
	private static final double VALOR_PESO_PORCENTUAL = 25D;

	private Long id;
	private Long licitacionId;
	private Long requerimientoId;
	private double pesoPorcentual;

    public LicitacionRequerimientoTestDataBuilder() {
    	licitacionId = VALOR_LICITACION_ID;
    	requerimientoId = VALOR_REQUERIMIENTO_ID;
    	pesoPorcentual = VALOR_PESO_PORCENTUAL;
    }
    
    public LicitacionRequerimientoTestDataBuilder withPesoPorcentualId(double pesoPorcentual) {
        this.pesoPorcentual = pesoPorcentual;
        return this;
    }
    
    public LicitacionRequerimiento build() {
        return new LicitacionRequerimiento(id, licitacionId, requerimientoId, pesoPorcentual);
    }
}
