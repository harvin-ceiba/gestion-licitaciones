package com.ceiba.requerimiento.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMaxima;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.Getter;

@Getter
public class Requerimiento {
	
	private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la descripcion del requerimiento";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO = "Se debe ingresar el estado de la Licitacion";
    
    private static final String DESCRIPCION_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A = "La descripcion debe tener una longitud menor o igual a %s";
    private static final int LONGITUD_MAXIMA_DESCRIPCION = 125;
	
	private Long id;
	private String descripcion;
	private int estado;

	public Requerimiento(Long id, String descripcion, int estado) {
		validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
        validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO);
        validarLongitudMaxima(descripcion, LONGITUD_MAXIMA_DESCRIPCION, String.format(DESCRIPCION_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A, LONGITUD_MAXIMA_DESCRIPCION));
        
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
}
