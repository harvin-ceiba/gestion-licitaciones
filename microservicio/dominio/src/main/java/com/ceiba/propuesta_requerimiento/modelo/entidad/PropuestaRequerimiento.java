package com.ceiba.propuesta_requerimiento.modelo.entidad;

import lombok.Getter;

@Getter
public class PropuestaRequerimiento {
	
	private Long id;
	private Long propuestaId;
	private Long requerimientoId;
	
	public PropuestaRequerimiento(Long id, Long propuestaId, Long requerimientoId) {
		this.id = id;
		this.propuestaId = propuestaId;
		this.requerimientoId = requerimientoId;
	}
	
}
