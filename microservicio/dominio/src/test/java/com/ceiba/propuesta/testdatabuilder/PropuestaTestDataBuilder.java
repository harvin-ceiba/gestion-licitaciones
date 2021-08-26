package com.ceiba.propuesta.testdatabuilder;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ceiba.propuesta.modelo.entidad.Propuesta;

public class PropuestaTestDataBuilder {
	
	private static final Long VALOR_LICITACION_ID = 1L;
	private static final double VALOR_PROPUESTA = 10000000D;
	private static final double VALOR_PUNTAJE = 0D;
	private static final int VALOR_ESTADO = 0;

	private Long id;
	private Long licitacionId;
	private String nombre;
	private String descripcion;
	private String nombreCliente;
	private double valor;
	private double puntaje;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaPublicacion;
	private int estado;

    public PropuestaTestDataBuilder() {
    	licitacionId = VALOR_LICITACION_ID;
    	nombre = UUID.randomUUID().toString();
    	descripcion = UUID.randomUUID().toString();
    	nombreCliente = UUID.randomUUID().toString();
    	valor = VALOR_PROPUESTA;
    	puntaje = VALOR_PUNTAJE;
    	estado = VALOR_ESTADO;
    }
    
    public Propuesta build() {
        return new Propuesta(id, licitacionId, nombre, descripcion, nombreCliente, valor, puntaje, fechaCreacion, fechaPublicacion, estado);
        		
    }
	
}
