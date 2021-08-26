package com.ceiba.propuesta_requerimiento.servicio.testdatabuilder;

import com.ceiba.propuesta_requerimiento.modelo.entidad.PropuestaRequerimiento;

public class PropuestaRequerimientoTestDataBuilder {
	
	private static final Long VALOR_PROPUESTA_ID = 1L;
	private static final Long VALOR_REQUERIMIENTO_ID = 1L;

	private Long id;
	private Long propuestaId;
	private Long requerimientoId;

    public PropuestaRequerimientoTestDataBuilder() {
    	propuestaId = VALOR_PROPUESTA_ID;
    	requerimientoId = VALOR_REQUERIMIENTO_ID;
    }
    
    public PropuestaRequerimiento build() {
        return new PropuestaRequerimiento(id, propuestaId, requerimientoId);
    }
	
}
