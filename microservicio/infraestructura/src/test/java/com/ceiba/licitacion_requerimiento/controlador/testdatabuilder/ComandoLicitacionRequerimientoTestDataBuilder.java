package com.ceiba.licitacion_requerimiento.controlador.testdatabuilder;

import com.ceiba.licitacion_requerimiento.comando.ComandoLicitacionRequerimiento;

public class ComandoLicitacionRequerimientoTestDataBuilder {
	
	private static final Long VALOR_LICITACION_ID = 1L;
	private static final Long VALOR_REQUERIMIENTO_ID = 3L;
	private static final double VALOR_PESO_PORCENTUAL = 0D;

	private Long id;
	private Long licitacionId;
	private Long requerimientoId;
	private double pesoPorcentual;

    public ComandoLicitacionRequerimientoTestDataBuilder() {
    	licitacionId = VALOR_LICITACION_ID;
    	requerimientoId = VALOR_REQUERIMIENTO_ID;
    	pesoPorcentual = VALOR_PESO_PORCENTUAL;
    }
    
    public ComandoLicitacionRequerimientoTestDataBuilder withPesoPorcentualId(double pesoPorcentual) {
        this.pesoPorcentual = pesoPorcentual;
        return this;
    }
    
    public ComandoLicitacionRequerimiento build() {
        return new ComandoLicitacionRequerimiento(id, licitacionId, requerimientoId, pesoPorcentual);
    }
}
