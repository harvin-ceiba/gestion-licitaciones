package com.ceiba.propuesta.servicio;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import static com.ceiba.dominio.ValidadorArgumento.validarEntre;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.modelo.dto.DtoLicitacion;
import com.ceiba.licitacion.puerto.dao.DaoLicitacion;
import com.ceiba.propuesta.modelo.dto.DtoPropuesta;
import com.ceiba.propuesta.puerto.dao.DaoPropuesta;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;

public class ServicioPublicarPropuesta {

    private static final String LA_PROPUESTA_NO_EXISTE = "La propuesta que intenta publicar no existe";
    private static final String LA_LICITACION_NO_EXISTE = "La licitacion asociada a la propuesta no existe";
    private static final String LA_PROPUESTA_NO_SE_ENCUENTRA_DENTRO_DEL_RANGO_DE_LICITACION = "La propuesta no se encuentra dentro del rango de la licitacion";
    private static final String LA_LICITACION_NO_SE_ENCUENTRA_ACTIVA = "La licitacion no se encuentra activa";
    private static final int VALOR_ESTADO_ACTIVO = 1;

    private final RepositorioPropuesta repositorioPropuesta;
    private final DaoPropuesta daoPropuesta;
    private final DaoLicitacion daoLicitacion;

    public ServicioPublicarPropuesta(RepositorioPropuesta repositorioPropuesta, DaoPropuesta daoPropuesta, DaoLicitacion daoLicitacion) {
        this.repositorioPropuesta = repositorioPropuesta;
        this.daoPropuesta = daoPropuesta;
        this.daoLicitacion = daoLicitacion;
    }

    public void ejecutar(Long idPropuesta) {
    	validarExistenciaPrevia(idPropuesta);
    	DtoPropuesta propuestaDto = obtenerPropuesta(idPropuesta);
    	DtoLicitacion licitacionDto = obtenerLicitacion(propuestaDto.getLicitacionId());
    	validarRangoFechasLicitacion(licitacionDto);
    	validarEstadoLicitacion(licitacionDto);
        this.repositorioPropuesta.publicar(idPropuesta);
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
}
