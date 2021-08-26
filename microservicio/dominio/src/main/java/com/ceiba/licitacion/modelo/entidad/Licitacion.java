package com.ceiba.licitacion.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.*;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Licitacion {
	
    private static final String SE_DEBE_INGRESAR_EL_CODIGO = "Se debe ingresar el codigo de la Licitacion";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre de la Licitacion";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la descripcion de la Licitacion";
    private static final String SE_DEBE_INGRESAR_EL_PRESUPUESTO = "Se debe ingresar el presupuesto de la Licitacion";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIAL = "Se debe ingresar la fecha inicial de la Licitacion";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_FINAL = "Se debe ingresar la fecha final de la Licitacion";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO = "Se debe ingresar el estado de la Licitacion";
    
    private static final String CODIGO_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A = "El codigo debe tener una longitud menor o igual a %s";
    private static final String NOMBRE_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A = "El nombre debe tener una longitud menor o igual a %s";
    private static final int LONGITUD_MAXIMA_CODIGO = 25;
    private static final int LONGITUD_MAXIMA_NOMBRE = 125;
    
    private static final String PRESUPUESTO_DEBE_SER_UN_VALOR_NUMERICO = "El presupuesto debe ser un valor numerico";
    private static final String PRESUPUESTO_DEBE_SER_UN_VALOR_POSITIVO = "El presupuesto debe ser un valor positivo";
    private static final String FECHA_INICIAL_DEBE_SER_MENOR_A_FECHA_FINAL = "La fecha inicial debe ser menor a la fecha final";
    
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
		
        validarObligatorio(codigo, SE_DEBE_INGRESAR_EL_CODIGO);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
        validarObligatorio(presupuesto, SE_DEBE_INGRESAR_EL_PRESUPUESTO);
        validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_LA_FECHA_INICIAL);
        validarObligatorio(fechaFin, SE_DEBE_INGRESAR_LA_FECHA_FINAL);
        validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO);
        
        validarLongitudMaxima(codigo, LONGITUD_MAXIMA_CODIGO, String.format(CODIGO_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A, LONGITUD_MAXIMA_CODIGO));
        validarLongitudMaxima(nombre, LONGITUD_MAXIMA_NOMBRE, String.format(NOMBRE_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A, LONGITUD_MAXIMA_NOMBRE));
        
        validarNumericoDouble(String.valueOf(presupuesto), PRESUPUESTO_DEBE_SER_UN_VALOR_NUMERICO);
        validarPositivo(presupuesto, PRESUPUESTO_DEBE_SER_UN_VALOR_POSITIVO);
        validarMenor(fechaInicio.toEpochDay(), fechaFin.toEpochDay(), FECHA_INICIAL_DEBE_SER_MENOR_A_FECHA_FINAL);
        
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
