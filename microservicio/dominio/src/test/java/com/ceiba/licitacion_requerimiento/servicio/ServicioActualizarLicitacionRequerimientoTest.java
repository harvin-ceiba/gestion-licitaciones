package com.ceiba.licitacion_requerimiento.servicio;

import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion_requerimiento.modelo.entidad.LicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.servicio.testdatabuilder.LicitacionRequerimientoTestDataBuilder;

public class ServicioActualizarLicitacionRequerimientoTest {
	
	private static final String EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION = "El Requerimiento no se encuentra asociado a la Licitacion";
	private static final String LA_LICITACION_NO_EXISTE = "La Licitacion no existe en el sistema";
	private static final String EL_REQUERIMIENTO_NO_EXISTE = "El Requerimiento no existe en el sistema";

	@Test
    public void validarActualizacionLicitacionRequerimientoTest() {
		// arrange
        LicitacionRequerimiento licitacionRequerimiento = new LicitacionRequerimientoTestDataBuilder().build();
        
        RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento = Mockito.mock(RepositorioLicitacionRequerimiento.class);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioLicitacionRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioLicitacion.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(true);
        
        ServicioActualizarLicitacionRequerimiento servicioActualizarLicitacionRequerimiento = new ServicioActualizarLicitacionRequerimiento(
        		repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
        
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioActualizarLicitacionRequerimiento.ejecutar(licitacionRequerimiento));
	}
	
	
	@Test
    public void validarActualizacionLicitacionRequerimientoExistenciaPreviaTest() {
		// arrange
        LicitacionRequerimiento licitacionRequerimiento = new LicitacionRequerimientoTestDataBuilder().build();
        
        RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento = Mockito.mock(RepositorioLicitacionRequerimiento.class);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioLicitacionRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
        
        ServicioActualizarLicitacionRequerimiento servicioActualizarLicitacionRequerimiento = new ServicioActualizarLicitacionRequerimiento(
        		repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarLicitacionRequerimiento.ejecutar(licitacionRequerimiento), 
        		ExcepcionValorInvalido.class, EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION);
	}
	
	@Test
    public void validarActualizacionLicitacionRequerimientoConLicitacionNoExistenteTest() {
		// arrange
        LicitacionRequerimiento licitacionRequerimiento = new LicitacionRequerimientoTestDataBuilder().build();
        
        RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento = Mockito.mock(RepositorioLicitacionRequerimiento.class);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioLicitacionRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioLicitacion.existe(Mockito.anyLong())).thenReturn(false);
        
        ServicioActualizarLicitacionRequerimiento servicioActualizarLicitacionRequerimiento = new ServicioActualizarLicitacionRequerimiento(
        		repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarLicitacionRequerimiento.ejecutar(licitacionRequerimiento), ExcepcionValorInvalido.class, LA_LICITACION_NO_EXISTE);
	}
	
	@Test
    public void validarActualizacionLicitacionRequerimientoConRequerimientoNoExistenteTest() {
		// arrange
        LicitacionRequerimiento licitacionRequerimiento = new LicitacionRequerimientoTestDataBuilder().build();
        
        RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento = Mockito.mock(RepositorioLicitacionRequerimiento.class);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        
        Mockito.when(repositorioLicitacionRequerimiento.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioLicitacion.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(false);
        
        ServicioActualizarLicitacionRequerimiento servicioActualizarLicitacionRequerimiento = new ServicioActualizarLicitacionRequerimiento(
        		repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarLicitacionRequerimiento.ejecutar(licitacionRequerimiento), ExcepcionValorInvalido.class, EL_REQUERIMIENTO_NO_EXISTE);
	}
	
}
