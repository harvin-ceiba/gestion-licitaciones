package com.ceiba.licitacion_requerimiento.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.*;

import lombok.Getter;

@Getter
public class LicitacionRequerimiento {
	
	private static final String PESO_PORCENTUAL_DEBE_TENER_UN_VALOR_MAXIMO_DE = "El peso porcentual debe tener un valor máximo de %s";
	private static final int VALOR_MAXIMO_PESO_PORCENTUAL = 100;
	    
    private static final String PESO_PORCENTUAL_DEBE_SER_UN_VALOR_NUMERICO = "El peso porcentual debe ser un valor numérico";
    private static final String PESO_PORCENTUAL_DEBE_SER_UN_VALOR_POSITIVO = "El peso porcentual debe ser un valor positivo";
	
	private Long id;
	private Long licitacionId;
	private Long requerimientoId;
	private double pesoPorcentual;
	
	public LicitacionRequerimiento(Long id, Long licitacionId, Long requerimientoId, double pesoPorcentual) {
		validarMayor(String.valueOf(pesoPorcentual), String.valueOf(VALOR_MAXIMO_PESO_PORCENTUAL), String.format(PESO_PORCENTUAL_DEBE_TENER_UN_VALOR_MAXIMO_DE, VALOR_MAXIMO_PESO_PORCENTUAL));
        validarNumericoDouble(String.valueOf(pesoPorcentual), PESO_PORCENTUAL_DEBE_SER_UN_VALOR_NUMERICO);
        validarPositivo(pesoPorcentual, PESO_PORCENTUAL_DEBE_SER_UN_VALOR_POSITIVO);
        
		this.id = id;
		this.licitacionId = licitacionId;
		this.requerimientoId = requerimientoId;
		this.pesoPorcentual = pesoPorcentual;
	}
	
}
