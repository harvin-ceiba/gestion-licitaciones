package com.ceiba.propuesta_requerimiento.servicio;

import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;
import com.ceiba.propuesta_requerimiento.modelo.entidad.PropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.puerto.repositorio.RepositorioPropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.servicio.testdatabuilder.PropuestaRequerimientoTestDataBuilder;

public class ServicioCrearPropuestaRequerimientoTest {
	
    private static final String EL_REQUERIMIENTO_YA_EXISTE_EN_LA_PROPUESTA = "El Requerimiento ya se encuentra asociado a la Propuesta";
    private static final String LA_PROPUESTA_PROPUESTA_NO_EXISTE = "La Propuesta no existe en el sistema";
    private static final String EL_REQUERIMIENTO_NO_EXISTE = "El Requerimiento no existe en el sistema";
	
	@Test
    public void validarCreacionPropuestaRequerimientoTest() {
		// arrange
        PropuestaRequerimiento propuestaRequerimiento = new PropuestaRequerimientoTestDataBuilder().build();
        
        RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento = Mockito.mock(RepositorioPropuestaRequerimiento.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioPropuestaRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(true);
        
        ServicioCrearPropuestaRequerimiento servicioCrearPropuestaRequerimiento = new ServicioCrearPropuestaRequerimiento(
        		repositorioPropuestaRequerimiento, repositorioPropuesta, repositorioRequerimiento);
        
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioCrearPropuestaRequerimiento.ejecutar(propuestaRequerimiento));
	}
	
	@Test
    public void validarCreacionPropuestaRequerimientoExistenciaPreviaTest() {
		// arrange
        PropuestaRequerimiento propuestaRequerimiento = new PropuestaRequerimientoTestDataBuilder().build();
        
        RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento = Mockito.mock(RepositorioPropuestaRequerimiento.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioPropuestaRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        ServicioCrearPropuestaRequerimiento servicioCrearPropuestaRequerimiento = new ServicioCrearPropuestaRequerimiento(
        		repositorioPropuestaRequerimiento, repositorioPropuesta, repositorioRequerimiento);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPropuestaRequerimiento.ejecutar(propuestaRequerimiento), ExcepcionDuplicidad.class, EL_REQUERIMIENTO_YA_EXISTE_EN_LA_PROPUESTA);
	}
	
	@Test
    public void validarCreacionPropuestaRequerimientoConPropuestaNoExistenteTest() {
		// arrange
        PropuestaRequerimiento propuestaRequerimiento = new PropuestaRequerimientoTestDataBuilder().build();
        
        RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento = Mockito.mock(RepositorioPropuestaRequerimiento.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioPropuestaRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearPropuestaRequerimiento servicioCrearPropuestaRequerimiento = new ServicioCrearPropuestaRequerimiento(
        		repositorioPropuestaRequerimiento, repositorioPropuesta, repositorioRequerimiento);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPropuestaRequerimiento.ejecutar(propuestaRequerimiento), ExcepcionValorInvalido.class, LA_PROPUESTA_PROPUESTA_NO_EXISTE);
	}
	
	@Test
    public void validarCreacionPropuestaRequerimientoConRequerimientoNoExistenteTest() {
		// arrange
        PropuestaRequerimiento propuestaRequerimiento = new PropuestaRequerimientoTestDataBuilder().build();
        
        RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento = Mockito.mock(RepositorioPropuestaRequerimiento.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioPropuestaRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearPropuestaRequerimiento servicioCrearPropuestaRequerimiento = new ServicioCrearPropuestaRequerimiento(
        		repositorioPropuestaRequerimiento, repositorioPropuesta, repositorioRequerimiento);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPropuestaRequerimiento.ejecutar(propuestaRequerimiento), ExcepcionValorInvalido.class, EL_REQUERIMIENTO_NO_EXISTE);
	}
	
}
