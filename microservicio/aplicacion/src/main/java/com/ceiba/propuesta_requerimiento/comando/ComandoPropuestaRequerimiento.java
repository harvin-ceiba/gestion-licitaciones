package com.ceiba.propuesta_requerimiento.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPropuestaRequerimiento{

	private Long id;
	private Long propuestaId;
	private Long requerimientoId;

}
