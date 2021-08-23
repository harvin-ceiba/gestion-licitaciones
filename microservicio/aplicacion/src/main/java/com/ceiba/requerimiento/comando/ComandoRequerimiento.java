package com.ceiba.requerimiento.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoRequerimiento{

	private Long id;
	private String descripcion;
	private int estado;

}
