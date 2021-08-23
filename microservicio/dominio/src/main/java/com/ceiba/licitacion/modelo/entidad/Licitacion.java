package com.ceiba.licitacion.modelo.entidad;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Licitacion {
	
	private Long id;
	private String codigo;
	private String nombre;
	private String descripcion;
	private double presupuesto;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int estado;
	
	public Licitacion(Long id, String codigo, String nombre, String descripcion, double presupuesto,
			LocalDate fechaInicio, LocalDate fechaFin, int estado) {
		
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.presupuesto = presupuesto;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}
	
	
}
