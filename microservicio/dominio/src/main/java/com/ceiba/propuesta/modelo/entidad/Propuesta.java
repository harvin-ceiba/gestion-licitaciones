package com.ceiba.propuesta.modelo.entidad;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Propuesta {
	
	//TODO: Falta definir las validaciones
	
	private Long id;
	private Long licitacionId;
	private String nombre;
	private String descripcion;
	private String nombreCliente;
	private double valor;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaPublicacion;
	private int estado;

	public Propuesta(Long id, Long licitacionId, String nombre, String descripcion, String nombreCliente, double valor,
			LocalDateTime fechaCreacion, LocalDateTime fechaPublicacion, int estado) {
		this.id = id;
		this.licitacionId = licitacionId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nombreCliente = nombreCliente;
		this.valor = valor;
		this.fechaCreacion = fechaCreacion;
		this.fechaPublicacion = fechaPublicacion;
		this.estado = estado;
	}
	
	
}
