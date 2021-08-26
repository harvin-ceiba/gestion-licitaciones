package com.ceiba.propuesta.servicio;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.validarEntre;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.modelo.dto.DtoLicitacion;
import com.ceiba.licitacion.puerto.dao.DaoLicitacion;
import com.ceiba.licitacion_requerimiento.modelo.dto.DtoLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.dao.DaoLicitacionRequerimiento;
import com.ceiba.propuesta.modelo.dto.DtoPropuesta;
import com.ceiba.propuesta.puerto.dao.DaoPropuesta;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;
import com.ceiba.propuesta_requerimiento.modelo.dto.DtoPropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.puerto.dao.DaoPropuestaRequerimiento;

public class ServicioPublicarPropuesta {

    private static final String LA_PROPUESTA_NO_EXISTE = "La propuesta que intenta publicar no existe";
    private static final String LA_LICITACION_NO_EXISTE = "La licitacion asociada a la propuesta no existe";
    private static final String LA_PROPUESTA_NO_SE_ENCUENTRA_DENTRO_DEL_RANGO_DE_LICITACION = "La propuesta no se encuentra dentro del rango de la licitacion";
    private static final String LA_LICITACION_NO_SE_ENCUENTRA_ACTIVA = "La licitacion no se encuentra activa";
    private static final int VALOR_ESTADO_ACTIVO = 1;
    private static final double PUNTAJE_ASIGNADO_PROPUESTA_VALOR_INFERIOR = 0.25;
    private static final double PUNTAJE_ASIGNADO_PROPUESTA_VALOR_SUPERIOR = 0.20;
    private static final double PESO_PORCENTUAL_REQUISITOS = 0.75;

    private final RepositorioPropuesta repositorioPropuesta;
    private final DaoPropuesta daoPropuesta;
    private final DaoLicitacion daoLicitacion;
    private final DaoPropuestaRequerimiento daoPropuestaRequerimiento;
    private final DaoLicitacionRequerimiento daoLicitacionRequerimiento;

    public ServicioPublicarPropuesta(RepositorioPropuesta repositorioPropuesta, DaoPropuesta daoPropuesta, DaoLicitacion daoLicitacion,
    		DaoPropuestaRequerimiento daoPropuestaRequerimiento, DaoLicitacionRequerimiento daoLicitacionRequerimiento) {
        this.repositorioPropuesta = repositorioPropuesta;
        this.daoPropuesta = daoPropuesta;
        this.daoLicitacion = daoLicitacion;
        this.daoPropuestaRequerimiento = daoPropuestaRequerimiento;
        this.daoLicitacionRequerimiento = daoLicitacionRequerimiento;
    }

    public void ejecutar(Long idPropuesta) {
    	validarExistenciaPrevia(idPropuesta);
    	DtoPropuesta propuestaDto = obtenerPropuesta(idPropuesta);
    	DtoLicitacion licitacionDto = obtenerLicitacion(propuestaDto.getLicitacionId());
    	validarRangoFechasLicitacion(licitacionDto);
    	validarEstadoLicitacion(licitacionDto);
    	double puntaje = calcularPuntaje(licitacionDto, propuestaDto);
        this.repositorioPropuesta.publicar(idPropuesta, puntaje);
    }
    
	private void validarExistenciaPrevia(Long idPropuesta) {
    	boolean existe = this.repositorioPropuesta.existe(idPropuesta);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_PROPUESTA_NO_EXISTE);
        }
    }
    
    private DtoPropuesta obtenerPropuesta(Long idPropuesta) {
    	DtoPropuesta dtoPropuesta = this.daoPropuesta.buscarPorId(idPropuesta);
    	if(dtoPropuesta == null) {
    		throw new ExcepcionValorInvalido(LA_PROPUESTA_NO_EXISTE);
    	}
    	return dtoPropuesta;
    }
    
    private DtoLicitacion obtenerLicitacion(Long idLicitacion) {
    	DtoLicitacion dtoLicitacion = this.daoLicitacion.buscarPorId(idLicitacion);
    	if(dtoLicitacion == null) {
    		throw new ExcepcionValorInvalido(LA_LICITACION_NO_EXISTE);
    	}
    	return dtoLicitacion;
    }
    
    private void validarRangoFechasLicitacion(DtoLicitacion licitacionDto) {
    	validarEntre(
    		Instant.now().toEpochMilli(), 
    		convertirLocalDateToMilliseconds(licitacionDto.getFechaInicio()), 
    		convertirLocalDateToMilliseconds(licitacionDto.getFechaFin().plusDays(1)), 
    		LA_PROPUESTA_NO_SE_ENCUENTRA_DENTRO_DEL_RANGO_DE_LICITACION
    	);
    }
    
    private void validarEstadoLicitacion(DtoLicitacion licitacionDto) {
    	if(licitacionDto.getEstado() != VALOR_ESTADO_ACTIVO) {
    		throw new ExcepcionValorInvalido(LA_LICITACION_NO_SE_ENCUENTRA_ACTIVA);
    	}
    }
    
    private Long convertirLocalDateToMilliseconds(LocalDate localDate) {
    	return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
    
    private double calcularPuntaje(DtoLicitacion licitacionDto, DtoPropuesta propuestaDto) {
    	List<DtoLicitacionRequerimiento> requerimientosLicitacion = this.daoLicitacionRequerimiento.listar(licitacionDto.getId());
    	List<DtoPropuestaRequerimiento> requerimientosPropuesta = this.daoPropuestaRequerimiento.listar(propuestaDto.getId());
    	
    	double puntajeValor = PUNTAJE_ASIGNADO_PROPUESTA_VALOR_SUPERIOR;
    	double valorRequisitosPropuesta = 0D;
    	
    	if(propuestaDto.getValor() <= licitacionDto.getPresupuesto()) {
    		puntajeValor = PUNTAJE_ASIGNADO_PROPUESTA_VALOR_INFERIOR;
    	}
    	
    	for(int i = 0; i < requerimientosLicitacion.size(); i++) {
    		for(int j = 0; i < requerimientosPropuesta.size(); j++) {
        		if(requerimientosLicitacion.get(i).getRequerimientoId().equals(requerimientosPropuesta.get(j).getRequerimientoId())) {
        			valorRequisitosPropuesta += requerimientosLicitacion.get(i).getPesoPorcentual();
        			break;
        		}
        	}
    	}
    	
    	return puntajeValor + valorRequisitosPropuesta*PESO_PORCENTUAL_REQUISITOS;
	}
}
