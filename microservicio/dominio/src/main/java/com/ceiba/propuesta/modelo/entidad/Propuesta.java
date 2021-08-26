package com.ceiba.propuesta.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMaxima;
import static com.ceiba.dominio.ValidadorArgumento.validarNumericoDouble;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Propuesta {
	
	private static final String SE_DEBE_INGRESAR_LA_LICITACION = "Se debe ingresar el identificador de la Licitacion";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre de la propuesta";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la descripcion de la propuesta";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE = "Se debe ingresar el nombre del cliente";
    private static final String SE_DEBE_INGRESAR_EL_VALOR = "Se debe ingresar el valor de la propuesta";
    
    private static final String NOMBRE_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A = "El nombre debe tener una longitud menor o igual a %s";
    private static final String NOMBRE_DEL_CLIENTE_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A = "El nombre de cliente debe tener una longitud menor o igual a %s";
    private static final int LONGITUD_MAXIMA_NOMBRE = 125;
    private static final int LONGITUD_MAXIMA_NOMBRE_DEL_CLIENTE = 125;
    
    private static final String VALOR_DEBE_SER_NUMERICO = "El valor de la propuesta debe ser numerico";
    private static final String VALOR_DEBE_SER_NUMERO_POSITIVO = "El valor de la propuesta debe ser un numero positivo";
	    
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
		
		validarObligatorio(licitacionId, SE_DEBE_INGRESAR_LA_LICITACION);
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
		validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
		validarObligatorio(nombreCliente, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE);
		validarObligatorio(valor, SE_DEBE_INGRESAR_EL_VALOR);
		
        validarLongitudMaxima(nombre, LONGITUD_MAXIMA_NOMBRE, 
        		String.format(NOMBRE_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A, LONGITUD_MAXIMA_NOMBRE));
        validarLongitudMaxima(nombreCliente, LONGITUD_MAXIMA_NOMBRE_DEL_CLIENTE, 
        		String.format(NOMBRE_DEL_CLIENTE_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A, LONGITUD_MAXIMA_NOMBRE_DEL_CLIENTE));
        
        validarNumericoDouble(String.valueOf(valor), VALOR_DEBE_SER_NUMERICO);
        validarPositivo(valor, VALOR_DEBE_SER_NUMERO_POSITIVO);
		 
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
