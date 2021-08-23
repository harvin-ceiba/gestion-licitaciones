package com.ceiba.requerimiento.modelo.entidad;

import lombok.Getter;

@Getter
public class Requerimiento {
	
	private Long id;
	private String descripcion;
	private int estado;

	public Requerimiento(Long id, String descripcion, int estado) {
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
}
