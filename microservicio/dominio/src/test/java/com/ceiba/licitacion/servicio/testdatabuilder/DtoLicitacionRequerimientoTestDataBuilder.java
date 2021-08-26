package com.ceiba.licitacion.servicio.testdatabuilder;

import com.ceiba.licitacion_requerimiento.modelo.dto.DtoLicitacionRequerimiento;

public class DtoLicitacionRequerimientoTestDataBuilder {
	
	private static final Long VALOR_LICITACION_ID = 1L;
	private static final Long VALOR_REQUERIMIENTO_ID = 1L;
	private static final double VALOR_PESO_PORCENTUAL = 0D;

	private Long id;
	private Long licitacionId;
	private Long requerimientoId;
	private double pesoPorcentual;

    public DtoLicitacionRequerimientoTestDataBuilder() {
    	licitacionId = VALOR_LICITACION_ID;
    	requerimientoId = VALOR_REQUERIMIENTO_ID;
    	pesoPorcentual = VALOR_PESO_PORCENTUAL;
    }
    
    public DtoLicitacionRequerimientoTestDataBuilder withRequerimientoId(Long requerimientoId) {
    	this.requerimientoId = requerimientoId;
    	return this;
    }
    
    public DtoLicitacionRequerimientoTestDataBuilder withPesoPorcentual(double pesoPorcentual) {
        this.pesoPorcentual = pesoPorcentual;
        return this;
    }
    
    public DtoLicitacionRequerimiento build() {
        return new DtoLicitacionRequerimiento(id, licitacionId, requerimientoId, pesoPorcentual);
    }
}
