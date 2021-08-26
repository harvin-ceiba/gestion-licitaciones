package com.ceiba.licitacion_requerimiento.servicio;

import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion_requerimiento.modelo.entidad.LicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.servicio.testdatabuilder.LicitacionRequerimientoTestDataBuilder;

public class ServicioCrearLicitacionRequerimientoTest {
	
	private static final String EL_REQUERIMIENTO_YA_EXISTE_EN_LA_LICITACION = "El Requerimiento ya se encuentra asociado a la Licitación";
    private static final String LA_LICITACION_NO_EXISTE = "La Licitación no existe en el sistema";
    private static final String EL_REQUERIMIENTO_NO_EXISTE = "El Requerimiento no existe en el sistema";
    
	private static final String PESO_PORCENTUAL_DEBE_TENER_UN_VALOR_MAXIMO_DE = "El peso porcentual debe tener un valor máximo de %s";
    private static final String PESO_PORCENTUAL_DEBE_SER_UN_VALOR_POSITIVO = "El peso porcentual debe ser un valor positivo";
    
	private static final double VALOR_MAXIMO_PESO_PORCENTUAL = 100D;
	private static final double VALOR_PESO_PORCENTUAL_SUPERIOR_A_CIEN = 150D;
    private static final double VALOR_PESO_PORCENTUAL_NEGATIVO = -10D;

	@Test
    public void validarCreacionLicitacionRequerimientoTest() {
		// arrange
        LicitacionRequerimiento licitacionRequerimiento = new LicitacionRequerimientoTestDataBuilder().build();
        
        RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento = Mockito.mock(RepositorioLicitacionRequerimiento.class);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioLicitacionRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(true);
        
        ServicioCrearLicitacionRequerimiento servicioCrearLicitacionRequerimiento = new ServicioCrearLicitacionRequerimiento(
        		repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
        
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioCrearLicitacionRequerimiento.ejecutar(licitacionRequerimiento));
	}
	
	
	@Test
    public void validarCreacionLicitacionRequerimientoConPesoPorcentualSuperiorACienTest() {
		// arrange
		LicitacionRequerimientoTestDataBuilder licitacionRequerimientoBuilder = new LicitacionRequerimientoTestDataBuilder()
        		.withPesoPorcentualId(VALOR_PESO_PORCENTUAL_SUPERIOR_A_CIEN);
        // act - assert
        BasePrueba.assertThrows(() -> licitacionRequerimientoBuilder.build(), 
        		ExcepcionValorInvalido.class, String.format(PESO_PORCENTUAL_DEBE_TENER_UN_VALOR_MAXIMO_DE, VALOR_MAXIMO_PESO_PORCENTUAL));
	}
	
	@Test
    public void validarCreacionLicitacionRequerimientoConPesoPorcentualNegativoTest() {
		// arrange
		LicitacionRequerimientoTestDataBuilder licitacionRequerimientoBuilder = new LicitacionRequerimientoTestDataBuilder()
        		.withPesoPorcentualId(VALOR_PESO_PORCENTUAL_NEGATIVO);
        // act - assert
        BasePrueba.assertThrows(() -> licitacionRequerimientoBuilder.build(), ExcepcionValorInvalido.class, PESO_PORCENTUAL_DEBE_SER_UN_VALOR_POSITIVO);
	}
	
	@Test
    public void validarCreacionLicitacionRequerimientoExistenciaPreviaTest() {
		// arrange
        LicitacionRequerimiento licitacionRequerimiento = new LicitacionRequerimientoTestDataBuilder().build();
        
        RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento = Mockito.mock(RepositorioLicitacionRequerimiento.class);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioLicitacionRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        
        ServicioCrearLicitacionRequerimiento servicioCrearLicitacionRequerimiento = new ServicioCrearLicitacionRequerimiento(
        		repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearLicitacionRequerimiento.ejecutar(licitacionRequerimiento), 
        		ExcepcionDuplicidad.class, EL_REQUERIMIENTO_YA_EXISTE_EN_LA_LICITACION);
	}
	
	@Test
    public void validarCreacionLicitacionRequerimientoConLicitacionNoExistenteTest() {
		// arrange
        LicitacionRequerimiento licitacionRequerimiento = new LicitacionRequerimientoTestDataBuilder().build();
        
        RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento = Mockito.mock(RepositorioLicitacionRequerimiento.class);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioLicitacionRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(false);
        
        ServicioCrearLicitacionRequerimiento servicioCrearLicitacionRequerimiento = new ServicioCrearLicitacionRequerimiento(
        		repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearLicitacionRequerimiento.ejecutar(licitacionRequerimiento), ExcepcionValorInvalido.class, LA_LICITACION_NO_EXISTE);
	}
	
	@Test
    public void validarCreacionLicitacionRequerimientoConRequerimientoNoExistenteTest() {
		// arrange
        LicitacionRequerimiento licitacionRequerimiento = new LicitacionRequerimientoTestDataBuilder().build();
        
        RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento = Mockito.mock(RepositorioLicitacionRequerimiento.class);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioLicitacionRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(false);
        
        ServicioCrearLicitacionRequerimiento servicioCrearLicitacionRequerimiento = new ServicioCrearLicitacionRequerimiento(
        		repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearLicitacionRequerimiento.ejecutar(licitacionRequerimiento), ExcepcionValorInvalido.class, EL_REQUERIMIENTO_NO_EXISTE);
	}
	
}
