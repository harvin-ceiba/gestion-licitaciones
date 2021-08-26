package com.ceiba.propuesta_requerimiento.servicio;

import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;
import com.ceiba.propuesta_requerimiento.puerto.repositorio.RepositorioPropuestaRequerimiento;

public class ServicioEliminarPropuestaRequerimientoTest {
	
    private static final String EL_REQUERIMIENTO_NO_EXISTE_EN_LA_PROPUESTA = "El Requerimiento no se encuentra asociado a la Propuesta";
    private static final String LA_PROPUESTA_PROPUESTA_NO_EXISTE = "La Propuesta no existe en el sistema";
    private static final String EL_REQUERIMIENTO_NO_EXISTE = "El Requerimiento no existe en el sistema";

	@Test
    public void validarEliminacionPropuestaRequerimientoTest() {
		// arrange
        RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento = Mockito.mock(RepositorioPropuestaRequerimiento.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioPropuestaRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(true);
        
        ServicioEliminarPropuestaRequerimiento servicioEliminarPropuestaRequerimiento = new ServicioEliminarPropuestaRequerimiento(
        		repositorioPropuestaRequerimiento, repositorioPropuesta, repositorioRequerimiento);
        
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioEliminarPropuestaRequerimiento.ejecutar(Mockito.anyLong(), Mockito.anyLong()));
	}
	
	@Test
    public void validarEliminacionPropuestaRequerimientoSinExistenciaPreviaTest() {
		// arrange
        RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento = Mockito.mock(RepositorioPropuestaRequerimiento.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioPropuestaRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        ServicioEliminarPropuestaRequerimiento servicioEliminarPropuestaRequerimiento = new ServicioEliminarPropuestaRequerimiento(
        		repositorioPropuestaRequerimiento, repositorioPropuesta, repositorioRequerimiento);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarPropuestaRequerimiento.ejecutar(Mockito.anyLong(), Mockito.anyLong()), 
        		ExcepcionValorInvalido.class, EL_REQUERIMIENTO_NO_EXISTE_EN_LA_PROPUESTA);
	}
	
	@Test
    public void validarEliminacionPropuestaRequerimientoConPropuestaNoExistenteTest() {
		// arrange
        RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento = Mockito.mock(RepositorioPropuestaRequerimiento.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioPropuestaRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarPropuestaRequerimiento servicioEliminarPropuestaRequerimiento = new ServicioEliminarPropuestaRequerimiento(
        		repositorioPropuestaRequerimiento, repositorioPropuesta, repositorioRequerimiento);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarPropuestaRequerimiento.ejecutar(Mockito.anyLong(), Mockito.anyLong()), 
        		ExcepcionValorInvalido.class, LA_PROPUESTA_PROPUESTA_NO_EXISTE);
	}
	
	@Test
    public void validarEliminacionPropuestaRequerimientoConRequerimientoNoExistenteTest() {
		// arrange
        RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento = Mockito.mock(RepositorioPropuestaRequerimiento.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioPropuestaRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarPropuestaRequerimiento servicioEliminarPropuestaRequerimiento = new ServicioEliminarPropuestaRequerimiento(
        		repositorioPropuestaRequerimiento, repositorioPropuesta, repositorioRequerimiento);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarPropuestaRequerimiento.ejecutar(Mockito.anyLong(), Mockito.anyLong()), 
        		ExcepcionValorInvalido.class, EL_REQUERIMIENTO_NO_EXISTE);
	}
	
}
