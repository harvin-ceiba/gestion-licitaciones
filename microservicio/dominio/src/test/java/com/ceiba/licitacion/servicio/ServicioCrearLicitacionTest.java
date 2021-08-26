package com.ceiba.licitacion.servicio;

import com.ceiba.licitacion.modelo.entidad.Licitacion;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion.servicio.testdatabuilder.LicitacionTestDataBuilder;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearLicitacionTest {
	
	private static final String LA_LICITACION_YA_EXISTE_EN_EL_SISTEMA = "La licitacion ya existe en el sistema";
	
	@Test
    public void validarCreacionLicitacionTest() {
		// arrange
        Licitacion licitacion = new LicitacionTestDataBuilder().build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        Mockito.when(repositorioLicitacion.existeCodigo(Mockito.anyString())).thenReturn(false);
        ServicioCrearLicitacion servicioCrearLicitacion = new ServicioCrearLicitacion(repositorioLicitacion);
        
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioCrearLicitacion.ejecutar(licitacion));
	}
	
	@Test
    public void validarCreacionLicitacionCodigoExistenteTest() {
		// arrange
        Licitacion licitacion = new LicitacionTestDataBuilder().build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        Mockito.when(repositorioLicitacion.existeCodigo(Mockito.anyString())).thenReturn(true);
        ServicioCrearLicitacion servicioCrearLicitacion = new ServicioCrearLicitacion(repositorioLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearLicitacion.ejecutar(licitacion), ExcepcionDuplicidad.class, LA_LICITACION_YA_EXISTE_EN_EL_SISTEMA);
	}
	
}
