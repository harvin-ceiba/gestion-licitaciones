package com.ceiba.licitacion_requerimiento.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoLicitacionRequerimiento {
	
	private Long id;
	private Long licitacionId;
	private Long requerimientoId;
	private double pesoPorcentual;
	
}
