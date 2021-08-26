package com.ceiba.licitacion_requerimiento.servicio;

import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;

public class ServicioEliminarLicitacionRequerimientoTest {
	
	private static final String EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION = "El Requerimiento no se encuentra asociado a la Licitacion";
	private static final String LA_LICITACION_NO_EXISTE = "La Licitacion no existe en el sistema";
	private static final String EL_REQUERIMIENTO_NO_EXISTE = "El Requerimiento no existe en el sistema";

	@Test
    public void validarEliminacionLicitacionRequerimientoTest() {
		// arrange
        RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento = Mockito.mock(RepositorioLicitacionRequerimiento.class);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioLicitacionRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioLicitacion.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(true);
        
        ServicioEliminarLicitacionRequerimiento servicioEliminarLicitacionRequerimiento = new ServicioEliminarLicitacionRequerimiento(
        		repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
        
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioEliminarLicitacionRequerimiento.ejecutar(Mockito.anyLong(), Mockito.anyLong()));
	}
	
	
	@Test
    public void validarEliminacionLicitacionRequerimientoExistenciaPreviaTest() {
		// arrange
        RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento = Mockito.mock(RepositorioLicitacionRequerimiento.class);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioLicitacionRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        
        ServicioEliminarLicitacionRequerimiento servicioEliminarLicitacionRequerimiento = new ServicioEliminarLicitacionRequerimiento(
        		repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarLicitacionRequerimiento.ejecutar(Mockito.anyLong(), Mockito.anyLong()), 
        		ExcepcionValorInvalido.class, EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION);
	}
	
	@Test
    public void validarEliminacionLicitacionRequerimientoConLicitacionNoExistenteTest() {
		// arrange
        RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento = Mockito.mock(RepositorioLicitacionRequerimiento.class);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioLicitacionRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioLicitacion.existe(Mockito.anyLong())).thenReturn(false);
        
        ServicioEliminarLicitacionRequerimiento servicioEliminarLicitacionRequerimiento = new ServicioEliminarLicitacionRequerimiento(
        		repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarLicitacionRequerimiento.ejecutar(Mockito.anyLong(), Mockito.anyLong()), ExcepcionValorInvalido.class, LA_LICITACION_NO_EXISTE);
	}
	
	@Test
    public void validarEliminacionLicitacionRequerimientoConRequerimientoNoExistenteTest() {
		// arrange
        RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento = Mockito.mock(RepositorioLicitacionRequerimiento.class);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioLicitacionRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioLicitacion.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(false);
        
        ServicioEliminarLicitacionRequerimiento servicioEliminarLicitacionRequerimiento = new ServicioEliminarLicitacionRequerimiento(
        		repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarLicitacionRequerimiento.ejecutar(Mockito.anyLong(), Mockito.anyLong()), ExcepcionValorInvalido.class, EL_REQUERIMIENTO_NO_EXISTE);
	}
	
}
