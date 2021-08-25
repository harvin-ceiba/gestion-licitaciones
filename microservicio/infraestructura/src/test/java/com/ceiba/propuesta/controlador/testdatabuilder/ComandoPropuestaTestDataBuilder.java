package com.ceiba.propuesta.controlador.testdatabuilder;

import com.ceiba.propuesta.comando.ComandoPropuesta;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoPropuestaTestDataBuilder {
	
	private static final Long VALOR_LICITACION_ID = 1L;
	private static final double VALOR_PROPUESTA = 10000000;
	private static final int VALOR_ESTADO = 0;

	private Long id;
	private Long licitacionId;
	private String nombre;
	private String descripcion;
	private String nombreCliente;
	private double valor;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaPublicacion;
	private int estado;

    public ComandoPropuestaTestDataBuilder() {
    	licitacionId = VALOR_LICITACION_ID;
    	nombre = UUID.randomUUID().toString();
    	descripcion = UUID.randomUUID().toString();
    	nombreCliente = UUID.randomUUID().toString();
    	valor = VALOR_PROPUESTA;
    	estado = VALOR_ESTADO;
    }
    
    public ComandoPropuesta build() {
        return new ComandoPropuesta(id, licitacionId, nombre, descripcion, nombreCliente, valor, fechaCreacion, fechaPublicacion, estado);
        		
    }
}
