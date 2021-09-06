package com.ceiba.licitacion.controlador.testdatabuilder;

import com.ceiba.licitacion.comando.ComandoLicitacion;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.UUID;

public class ComandoLicitacionTestDataBuilder {
	
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

    public ComandoLicitacionTestDataBuilder() {
    	codigo = VALOR_CODIGO;
    	nombre = UUID.randomUUID().toString();
    	descripcion = UUID.randomUUID().toString();
    	presupuesto = VALOR_PRESUPUESTO;
    	fechaInicio = VALOR_FECHA_INICIAL;
    	fechaFin = VALOR_FECHA_FINAL;
    	estado = VALOR_ESTADO;
    }
    
    public ComandoLicitacionTestDataBuilder withCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }
    
    public ComandoLicitacion build() {
        return new ComandoLicitacion(id, codigo, nombre, descripcion, presupuesto, fechaInicio, fechaFin, estado);
    }
}
