package com.ceiba.propuesta.servicio;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.modelo.dto.DtoLicitacion;
import com.ceiba.licitacion.puerto.dao.DaoLicitacion;
import com.ceiba.propuesta.modelo.dto.DtoPropuesta;
import com.ceiba.propuesta.puerto.dao.DaoPropuesta;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;
import com.ceiba.propuesta.testdatabuilder.DtoLicitacionTestDataBuilder;
import com.ceiba.propuesta.testdatabuilder.DtoPropuestaTestDataBuilder;

public class ServicioPublicarPropuestaTest {

    private static final String LA_PROPUESTA_NO_EXISTE = "La propuesta que intenta publicar no existe";
    private static final String LA_LICITACION_NO_EXISTE = "La licitacion asociada a la propuesta no existe";
    private static final String LA_PROPUESTA_NO_SE_ENCUENTRA_DENTRO_DEL_RANGO_DE_LICITACION = "La propuesta no se encuentra dentro del rango de la licitacion";
    private static final String LA_LICITACION_NO_SE_ENCUENTRA_ACTIVA = "La licitacion no se encuentra activa";
    
    private static final Long VALOR_ID_PROPUESTA = 1L;
    private static final int VALOR_ESTADO_ACTIVO = 1;
    private static final int VALOR_ESTADO_INACTIVO = 0;
    
    private static final LocalDate VALOR_FECHA_INICIO_FUERA_RANGO = LocalDate.of(2021, 7, 1);
    private static final LocalDate VALOR_FECHA_FIN_FUERA_RANGO = LocalDate.of(2021, 7, 31);
    
    @Test
    public void validarPublicacionPropuestaTest() {
		// arrange
    	DtoPropuesta dtoPropuesta = new DtoPropuestaTestDataBuilder().withId(VALOR_ID_PROPUESTA).build();
    	DtoLicitacion dtoLicitacion = new DtoLicitacionTestDataBuilder().withEstado(VALOR_ESTADO_ACTIVO).build();
    	
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        DaoPropuesta daoPropuesta = Mockito.mock(DaoPropuesta.class);
        DaoLicitacion daoLicitacion = Mockito.mock(DaoLicitacion.class);
        
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoPropuesta.buscarPorId(Mockito.anyLong())).thenReturn(dtoPropuesta);
        Mockito.when(daoLicitacion.buscarPorId(Mockito.anyLong())).thenReturn(dtoLicitacion);
        
        ServicioPublicarPropuesta servicioPublicarPropuesta = new ServicioPublicarPropuesta(repositorioPropuesta, daoPropuesta, daoLicitacion);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioPublicarPropuesta.ejecutar(VALOR_ID_PROPUESTA));
    }
    
    @Test
    public void validarPublicacionPropuestaNoExistenteTest() {
    	// arrange
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        DaoPropuesta daoPropuesta = Mockito.mock(DaoPropuesta.class);
        DaoLicitacion daoLicitacion = Mockito.mock(DaoLicitacion.class);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(false);
        ServicioPublicarPropuesta servicioPublicarPropuesta = new ServicioPublicarPropuesta(repositorioPropuesta, daoPropuesta, daoLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioPublicarPropuesta.ejecutar(VALOR_ID_PROPUESTA), ExcepcionValorInvalido.class, LA_PROPUESTA_NO_EXISTE);
    }
    
    @Test
    public void validarPublicacionPropuestaNoExistenteAlObtenerInformacionLicitacionTest() {
    	// arrange
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        DaoPropuesta daoPropuesta = Mockito.mock(DaoPropuesta.class);
        DaoLicitacion daoLicitacion = Mockito.mock(DaoLicitacion.class);

        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoPropuesta.buscarPorId(Mockito.anyLong())).thenReturn(null);
        ServicioPublicarPropuesta servicioPublicarPropuesta = new ServicioPublicarPropuesta(repositorioPropuesta, daoPropuesta, daoLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioPublicarPropuesta.ejecutar(VALOR_ID_PROPUESTA), ExcepcionValorInvalido.class, LA_PROPUESTA_NO_EXISTE);
    }
    
    @Test
    public void validarPublicacionPropuestaConLicitacionNoExistenteTest() {
    	// arrange
    	DtoPropuesta dtoPropuesta = new DtoPropuestaTestDataBuilder().withId(VALOR_ID_PROPUESTA).build();

        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        DaoPropuesta daoPropuesta = Mockito.mock(DaoPropuesta.class);
        DaoLicitacion daoLicitacion = Mockito.mock(DaoLicitacion.class);

        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoPropuesta.buscarPorId(Mockito.anyLong())).thenReturn(dtoPropuesta);
        Mockito.when(daoLicitacion.buscarPorId(Mockito.anyLong())).thenReturn(null);
        ServicioPublicarPropuesta servicioPublicarPropuesta = new ServicioPublicarPropuesta(repositorioPropuesta, daoPropuesta, daoLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioPublicarPropuesta.ejecutar(VALOR_ID_PROPUESTA), ExcepcionValorInvalido.class, LA_LICITACION_NO_EXISTE);
    }
    
    @Test
    public void validarPublicacionPropuestaFueraDeRangoDeLicitacionTest() {
    	// arrange
    	DtoPropuesta dtoPropuesta = new DtoPropuestaTestDataBuilder().withId(VALOR_ID_PROPUESTA).build();
    	DtoLicitacion dtoLicitacion = new DtoLicitacionTestDataBuilder().withEstado(VALOR_ESTADO_ACTIVO)
    			.withFechaInicio(VALOR_FECHA_INICIO_FUERA_RANGO)
    			.withFechaFin(VALOR_FECHA_FIN_FUERA_RANGO)
    			.build();
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        DaoPropuesta daoPropuesta = Mockito.mock(DaoPropuesta.class);
        DaoLicitacion daoLicitacion = Mockito.mock(DaoLicitacion.class);

        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoPropuesta.buscarPorId(Mockito.anyLong())).thenReturn(dtoPropuesta);
        Mockito.when(daoLicitacion.buscarPorId(Mockito.anyLong())).thenReturn(dtoLicitacion);
        ServicioPublicarPropuesta servicioPublicarPropuesta = new ServicioPublicarPropuesta(repositorioPropuesta, daoPropuesta, daoLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioPublicarPropuesta.ejecutar(VALOR_ID_PROPUESTA), 
        		ExcepcionValorInvalido.class, LA_PROPUESTA_NO_SE_ENCUENTRA_DENTRO_DEL_RANGO_DE_LICITACION);
    }
    
    @Test
    public void validarPublicacionConLicitacionInactivaTest() {
		// arrange
    	DtoPropuesta dtoPropuesta = new DtoPropuestaTestDataBuilder().withId(VALOR_ID_PROPUESTA).build();
    	DtoLicitacion dtoLicitacion = new DtoLicitacionTestDataBuilder().withEstado(VALOR_ESTADO_INACTIVO).build();
    	
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        DaoPropuesta daoPropuesta = Mockito.mock(DaoPropuesta.class);
        DaoLicitacion daoLicitacion = Mockito.mock(DaoLicitacion.class);
        
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoPropuesta.buscarPorId(Mockito.anyLong())).thenReturn(dtoPropuesta);
        Mockito.when(daoLicitacion.buscarPorId(Mockito.anyLong())).thenReturn(dtoLicitacion);
        
        ServicioPublicarPropuesta servicioPublicarPropuesta = new ServicioPublicarPropuesta(repositorioPropuesta, daoPropuesta, daoLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioPublicarPropuesta.ejecutar(VALOR_ID_PROPUESTA), 
        		ExcepcionValorInvalido.class, LA_LICITACION_NO_SE_ENCUENTRA_ACTIVA);
    }

}
