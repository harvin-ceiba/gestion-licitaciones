package com.ceiba.propuesta.testdatabuilder;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.UUID;

import com.ceiba.licitacion.modelo.dto.DtoLicitacion;

public class DtoLicitacionTestDataBuilder {
	
	private static final String VALOR_CODIGO = "001";
	private static final int VALOR_ESTADO = 0;
	private static final double VALOR_PRESUPUESTO = 10000000;
	private static final LocalDate VALOR_FECHA_INICIAL = YearMonth.now().atDay(1);
	private static final LocalDate VALOR_FECHA_FINAL = YearMonth.now().atEndOfMonth();
	
	private Long id;
	private String codigo;
	private String nombre;
	private String descripcion;
	private double presupuesto;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int estado;
	
	public DtoLicitacionTestDataBuilder() {
    	codigo = VALOR_CODIGO;
    	nombre = UUID.randomUUID().toString();
    	descripcion = UUID.randomUUID().toString();
    	presupuesto = VALOR_PRESUPUESTO;
    	fechaInicio = VALOR_FECHA_INICIAL;
    	fechaFin = VALOR_FECHA_FINAL;
    	estado = VALOR_ESTADO;
    }
	
	public DtoLicitacionTestDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public DtoLicitacionTestDataBuilder withFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
		return this;
	}
	
	public DtoLicitacionTestDataBuilder withFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
		return this;
	}
	
	public DtoLicitacionTestDataBuilder withEstado(int estado) {
		this.estado = estado;
		return this;
	}
	
	public DtoLicitacion build() {
		return new DtoLicitacion(id, codigo, nombre, descripcion, presupuesto, fechaInicio, fechaFin, estado);
	}
	
}
