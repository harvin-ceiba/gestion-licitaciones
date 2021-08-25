package com.ceiba.propuesta_requerimiento.servicio.testdatabuilder;

import com.ceiba.propuesta_requerimiento.comando.ComandoPropuestaRequerimiento;

public class ComandoPropuestaRequerimientoTestDataBuilder {
	
	private static final Long VALOR_PROPUESTA_ID = 1L;
	private static final Long VALOR_REQUERIMIENTO_ID = 3L;

	private Long id;
	private Long propuestaId;
	private Long requerimientoId;

    public ComandoPropuestaRequerimientoTestDataBuilder() {
    	propuestaId = VALOR_PROPUESTA_ID;
    	requerimientoId = VALOR_REQUERIMIENTO_ID;
    }
    
    public ComandoPropuestaRequerimiento build() {
        return new ComandoPropuestaRequerimiento(id, propuestaId, requerimientoId);
    }
}
