package com.ceiba.licitacion_requerimiento.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoLicitacionRequerimiento{

	private Long id;
	private Long licitacionId;
	private Long requerimientoId;
	private double pesoPorcentual;

}
