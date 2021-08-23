package com.ceiba.requerimiento.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoRequerimiento {
	
	private Long id;
	private String descripcion;
	private int estado;	
	
}